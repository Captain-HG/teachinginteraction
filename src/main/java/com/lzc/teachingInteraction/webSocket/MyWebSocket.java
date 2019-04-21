package com.lzc.teachingInteraction.webSocket;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.lzc.teachingInteraction.rabbitmq.MyRabbitmq;
import com.lzc.teachingInteraction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/websocket/{userId}")
@Component
public class MyWebSocket {
    private static MyRabbitmq rabbitmq;
    @Autowired
    public void setRabbitmq(MyRabbitmq rabbitmq ) {
        MyWebSocket.rabbitmq = rabbitmq;
    }

    private static UserService userService;
    @Autowired
    public void setUserService(UserService userService ) {
        MyWebSocket.userService = userService;
    }

    //用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //用来记录sessionId和该session进行绑定
    private static Map<String, Session> map = new ConcurrentHashMap<String, Session>();

    //用户id
    private Integer userId;



    /**
     *      * 连接建立成功调用的方法
     *     
     */
//    @OnOpen
//    public void onOpen(Session session, @PathParam("userName") String userName) {
//        this.session = session;
//        this.userName = userName;
//
//        map.put(session.getId(), session);
//
//        webSocketSet.add(this);//加入set中
//        System.out.println("有新连接加入！" + userName + "+当前在线人数为" + webSocketSet.size());
//
//        this.session.getAsyncRemote().sendText("欢迎"+userName+"成功连接上WebSocket(其频道号："+session.getId()+")-->当前在线人数为："+webSocketSet.size());
//    }
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        this.session = session;
        System.out.println(userId);
        map.put(userId, session);
        webSocketSet.add(this);//加入set中
        System.out.println("有新连接加入！" + userId + "+当前在线人数为" + webSocketSet.size());
        System.out.println("连接后的map:"+map);

        this.session.getAsyncRemote().sendText("欢迎"+userService.selectById(userId).getuName()+"成功连接上WebSocket");
    }

    /**
     *      * 连接关闭调用的方法
     *     
     */
    @OnClose
    public void onClose() {

        webSocketSet.remove(this);//从set中删除
        map.remove("1");
        System.out.println("删除中map:"+map);
        System.out.println("有一连接关闭！当前在线人数为" + webSocketSet.size());
    }

    /**
     *      * 收到客户端消息后调用的方法
     *      *
     *      * @param message 客户端发送过来的消息
     */
//    @OnMessage
//    public void onMessage(String message, Session session, @PathParam("userName") String userName) {
////        System.out.println("来自客户端的消息:" + message);
//////群发消息
////        broadcast(userName+":"+message);
//        //从客户端传过来的数据是json数据，所以这里使用jackson进行转换为SocketMsg对象，
//        // 然后通过socketMsg的type进行判断是单聊还是群聊，进行相应的处理:
//        ObjectMapper objectMapper = new ObjectMapper();
//        SocketMsg socketMsg;
//
//        try {
//            socketMsg = objectMapper.readValue(message, SocketMsg.class);
//            if (socketMsg.getType() == 1) {
//                //单聊.需要找到发送者和接受者.
//
//                socketMsg.setFromUser(session.getId());//发送者.
//                Session fromSession = map.get(socketMsg.getFromUser());
//                Session toSession = map.get(socketMsg.getToUser());
//                //发送给接受者,对方的频道号存在，而且在线情况
//                if (toSession != null&&map.containsKey(toSession.getId())&&toSession.getId()!=fromSession.getId()) {
//                    //发送给发送者.
//                        fromSession.getAsyncRemote().sendText(userName + "：" + socketMsg.getMsg());
//                        toSession.getAsyncRemote().sendText(userName + "：" + socketMsg.getMsg());
//
//
//                } else {
//                    //发送给发送者.
//                    fromSession.getAsyncRemote().sendText("系统消息：对方不在线或者您输入的频道号不对");
//                }
//            } else {
//                //群发消息
//                broadcast(userName + ": " + socketMsg.getMsg());
//            }
//
//        } catch (JsonParseException e) {
//            e.printStackTrace();
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
    @OnMessage
    public void onMessage(String message, Session session, @PathParam("userId") String userId) {
//        System.out.println("来自客户端的消息:" + message);
////群发消息
//        broadcast(userName+":"+message);
        //从客户端传过来的数据是json数据，所以这里使用jackson进行转换为SocketMsg对象，
        // 然后通过socketMsg的type进行判断是单聊还是群聊，进行相应的处理:
        ObjectMapper objectMapper = new ObjectMapper();
        SocketMsg socketMsg;

        try {
            socketMsg = objectMapper.readValue(message, SocketMsg.class);
            if (socketMsg.getType() == 1) {
                //单聊.需要找到发送者和接受者.

                socketMsg.setFromUser(userId);//发送者.
                Session fromSession = map.get(socketMsg.getFromUser());
                Session toSession = map.get(socketMsg.getToUser());
                //发送给接受者,对方的频道号存在，而且在线情况
                if (toSession != null&&toSession.getId()!=fromSession.getId()) {
                    System.out.println("发送信息："+map);
                        //发送给发送者.
                        fromSession.getAsyncRemote().sendText(userService.selectById(userId).getuName() + "：" + socketMsg.getMsg());
                        toSession.getAsyncRemote().sendText(userService.selectById(userId).getuName() + "：" + socketMsg.getMsg());

                    //对方不在线的情况下，使用消息队列


                } else {
                    //发送给发送者.
                    //fromSession.getAsyncRemote().sendText("系统消息：对方不在线或者您输入的频道号不对");

                    rabbitmq.CreateExchange(userId,socketMsg.getToUser());
                    rabbitmq.contextLoads(userId,socketMsg.getToUser(),socketMsg.getMsg());
                    fromSession.getAsyncRemote().sendText("系统消息：对方不在线,你发送的也将会被接受");

                }
            } else {
                //群发消息
                broadcast(userId + ": " + socketMsg.getMsg());
            }

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     *      * 发生错误时调用
     *      *
     *     
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     *      * 群发自定义消息
     *      *
     */
    public void broadcast(String message) {
        for (MyWebSocket item : webSocketSet) {
            //同步异步说明参考：http://blog.csdn.net/who_is_xiaoming/article/details/53287691
            //this.session.getBasicRemote().sendText(message);
            item.session.getAsyncRemote().sendText(message);//异步发送消息.
        }
    }
}

