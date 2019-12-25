/*Created by Administrator on 2017/11/12.*/
$(function(){
    //轮播图
    $(".slideTxtBox").slide({mainCell:".bd ul",effect:"leftLoop",gaidonglunbo:"#gaidonglunbo",autoPlay:true,interTime:3000});
    $(".slidebanner").slide({mainCell:".bd ul",effect:"left",autoPlay:true,interTime:3000});
    //显示右侧信息表单
    $(".font").on("click",function(){$.ajax({url:"http://www.laqu.com/query/maintailQq",type:"post",async:false,dataType:"json",data:{"departmentId":"4"}}).done(function(datacon){if(datacon.code == 10000){var link;var arr = datacon.data.marketList;if(arr.length < 1){link = 3004100509;}else{var merchantConsulting=parseInt(arr.length*Math.random());alink=arr[merchantConsulting];}var shop_service="http://wpa.qq.com/msgrd?v=3&uin="+alink+"&site=qq&menu=yes";window.open(shop_service);}else{shop_service="http://wpa.qq.com/msgrd?v=3&uin="+3004100509+"&site=qq&menu=yes";window.open(shop_service);}});});
    //下浮窗关闭
    $(".lqset_bottomfloat_off").on("click",function(){$(".lqset_float").hide();});
    //点击控制页面上划
    function clicknav(dom,px,domaname){dom.on("click",function(){$(document).scrollTop(px);$(".lqset_top div ul").children("li").removeClass(domaname);dom.addClass(domaname);});}
    //绑定节点控制页面的上划
    clicknav($(".laset_nav1"),700,"active");clicknav($(".laset_nav2"),1200,"active");clicknav($(".laset_nav3"),3280,"active");clicknav($(".laset_nav4"),3980,"active");clicknav($(".laset_nav5"),4700,"active");clicknav($(".laset_nav6"),5460,"active");
    //消除input的placeholder默认样式
    var placeholder = "";
    $("input").on("blur",function(){$(this).attr("placeholder",placeholder);});
    $("input").on("focus",function(){placeholder = $(this).attr("placeholder");$(this).attr("placeholder","");});
    //对修改插件的改动
    $("#gaidonglunbo li").on("mouseover",function(){var datanum = $(this).attr("data");$("#gaidonglunbo li").removeClass("active");$(this).addClass("active");$(".slideTxtBox .bd ul").css("left",-((parseInt(datanum)+ 1) *650)+"px");$(".slideTxtBox .hd ul").children("li").removeClass("on");$(".slideTxtBox .hd ul").children("li").eq(datanum).addClass("on");});
    var phonetxt = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|17[0|1|3|5|6|7|8]|18[0|1|2|3|4|5|6|7|8|9]|19[0|1|2|3|4|5|6|7|8|9])\d{8}$/;   //手机号的正则表达式。
    $("#registerbtn").on("click",function(){$("#form1").submit();});
});













