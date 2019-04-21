$(document).ready(function () {

    $(".OpeningLabs").click(function () {
        if(!$(".helpList").is(":hidden")) $(".helpList").hide();
        if ($(this).find("i").hasClass("layui-icon-triangle-d")) {
            $(this).find("i").removeClass("layui-icon-triangle-d").addClass("layui-icon-triangle-r");
        } else if ($(this).find("i").hasClass("layui-icon-triangle-r")) {
            $(this).find("i").removeClass("layui-icon-triangle-r").addClass("layui-icon-triangle-d");
        }
        $(".menuList").toggle();
    });
});
$(document).ready(function () {
    $(".helpBtn").click(function () {
        if(!$(".menuList").is(":hidden")) $(".menuList").hide();
        if ($(this).find("i").hasClass("layui-icon-triangle-d")) {
            $(this).find("i").removeClass("layui-icon-triangle-d").addClass("layui-icon-triangle-r");
        } else if ($(this).find("i").hasClass("layui-icon-triangle-r")) {
            $(this).find("i").removeClass("layui-icon-triangle-r").addClass("layui-icon-triangle-d");
        }
        $(".helpList").toggle();
    });
});