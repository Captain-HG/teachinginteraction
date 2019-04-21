package com.lzc.teachingInteraction.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;


import com.lzc.teachingInteraction.shiro.ShiroRealm;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Properties;

/**
 * @author hg
 * shiro的配置类
 */
@Configuration
public class ShiroConfig {
    /**
     * 编写ShiroFilterFactoryBean，subject的工厂
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全关联
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        shiroFilterFactoryBean.setLoginUrl("/userLogin.html");
        shiroFilterFactoryBean.setSuccessUrl("/index.html");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        /**
         * shiro内置过滤器
         *    常用：anon:无需认证 ，authc:必须认证才可访问，user:如果使用remembenMe可再次访问,
         *    perms:该资源必须得到资源权限c才可以访问   role:该资源必须得到角色权限c才可以访问
         */
        // 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 --> : 这是一个坑，一不小心代码就不好使了
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //放行静态资源
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/druid/**", "anon");
//        filterChainDefinitionMap.put("/login-remember", "anon");
//        filterChainDefinitionMap.put("/login-rememberUp", "anon");
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/loginSure", "anon");
        filterChainDefinitionMap.put("/userRegister.html", "anon");
        filterChainDefinitionMap.put("/**", "authc");
//        filterChainDefinitionMap.put("/", "anon");

//        filterChainDefinitionMap.put("/**", "user");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }



    /**
     * 编写SecurityManager，安全管理
     */
    @Bean
     public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        //设置自定义规则，关联Realm
        securityManager.setRealm(shiroRealm());
//        //用户授权/认证信息Cache, 采用EhCache缓存,配置redis缓存
//        securityManager.setCacheManager(getEhCacheManager());
//        //配置自定义session管理，使用redis
////        securityManager.setSessionManager(sessionManager());


        return securityManager;
    }


    /**
     * 编写ShiroRealm,可自定义
     */
    @Bean
    public ShiroRealm shiroRealm(){
        ShiroRealm shiroRealm = new ShiroRealm();
        return new ShiroRealm();
    }

    /**
     * thymeleaf与shiro
     */
     @Bean
    public ShiroDialect shiroDialect(){
         return new ShiroDialect();
     }








}
