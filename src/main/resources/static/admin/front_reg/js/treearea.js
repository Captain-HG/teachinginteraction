function AreaListJS(regionTextList, regionTextHidden, regionCheckBoxListPanel) {
    this.RegionTextList = regionTextList;//根据传进来的参数初始ID
    this.RegionTextHiden = regionTextHidden;//隐藏域的id
    this.RegionCheckBoxListPanel = regionCheckBoxListPanel;////根据传进来的参数初始div ID

    $("#" + this.RegionTextList).bind('click', { obj: this }, function (event) {
        ShowRegionCheckBoxList(event.data.obj);//注意获取传递参数的方式  
    })
    function ShowRegionCheckBoxList(obj) {
        var isShow = $("#" + obj.RegionCheckBoxListPanel).css("display");
        if (isShow == "none") {//已经显示时，不在处理，否则多次点击文本框位置有偏差  
            TreeDiv = obj.RegionCheckBoxListPanel;//当前显示树状图的div
            TreeID = obj.RegionTextList;//当前input
            TreeHiddenID = obj.RegionTextHiden;//隐藏域的input id
            var offset = $("#" + obj.RegionTextList).offset(); //根据传递的参数计算位置
            var location = getScroll();
            $("#" + obj.RegionCheckBoxListPanel).css("left", "0px");//根据传递的参数计算
            $("#" + obj.RegionCheckBoxListPanel).css("top", "0px");//根据传递的参数计算
            $("#" + obj.RegionCheckBoxListPanel).css("background", "white");//根据传递的参数计算
            $("#" + obj.RegionCheckBoxListPanel).show();//根据传递的参数计算
        }
    }
}
getScroll = function () {//计算滚动条的位置
    var t, l;
    if (document.documentElement && document.documentElement.scrollTop) {
        t = document.documentElement.scrollTop;
        l = document.documentElement.scrollLeft;
    } else if (document.body) {
        t = document.body.scrollTop;
        l = document.body.scrollLeft;
    }
    else {
        t = 0; l = 0;
    }
    return { top: t, left: l };
}
//判断鼠标在不在弹出层范围内
function checkIn(id, evt) {
    var yy = 20;   //偏移量
    var str = "";
    //var x = window.event.clientX;
    //var y = window.event.clientY;

    var x = evt.clientX;
    var y = evt.clientY;

    if (id != "") {
        var obj = $("#" + id)[0];
        if (x > obj.offsetLeft && x < (obj.offsetLeft + obj.clientWidth) && y > (obj.offsetTop - yy) && y < (obj.offsetTop + obj.clientHeight)) {
            return true;
        } else {
            return false;
        }
    }
}
//点击body关闭弹出层
$(document).click(function (evt) {
    var C_ID = "";
    
    //if (evt) {//不是ie
    //    C_ID = evt.target.id;
    //} else if (window.event) {//ie
    //    C_ID = window.event.srcElement.id;
    //}

    var target = evt.srcElement || evt.target;
    C_ID = target.id;
    //判断是否是三个控件
    if (C_ID != "Area2" && C_ID != "Area3" && C_ID != "AddArea2" && C_ID != "AddArea3" && C_ID != "txtServiceArea2") {
        var is = checkIn(TreeDiv,evt);
        if (!is) {
            $("#" + TreeDiv).hide();
        }
    }
});