define(function(require){function a(){OP_CONFIG.userInfo&&$.ajax({url:"/u/loading",dataType:"json",success:function(a){if(0==a.result){var c=window.location.href.indexOf("notices"),h=window.location.href.indexOf("messages");a.data.remind>0?(_not_unread=1,$(".msg_remind").show(),(-1!=c||-1!=h)&&(a.data.remind>99?$("#not_new").find(".not-num").html("99+").show():$("#not_new").find(".not-num").html("("+a.data.remind+")").show())):(_not_unread=0,_msg_unread||$(".msg_remind").hide())}}})}function c(){h=$(window).height(),t=$(document).scrollTop(),t>=768?($("#backTop").show(),$("#js-elevator-weixin").removeClass("no-goto")):($("#backTop").hide(),$("#js-elevator-weixin").addClass("no-goto"))}require("jquery"),require("/static/component/base/util/string"),require("/static/component/logic/common/userinfo.js"),require("/static/component/logic/cart/cart.js");var v=require("../../base/util/cookie.js"),g=require("/static/component/base/suggest/suggest"),b=require("store");if(setTimeout(function(){require.async("/static/moco/v1.0/dist/js/moco.min.js")},0),require.async("chat",function(){var a=!1,c=navigator.userAgent.toLowerCase().match(/msie ([\d.]+)/);if(c){var h=parseInt(c[1]);10>h&&(a=!0)}!a&&isLogin&&$.chat.init();var v=0;clearTimeout(v),v=setTimeout(function(){require.async("/static/moco/v1.0/dist/js/moco.min.js")},3e3)}),OP_CONFIG.usercaution&&OP_CONFIG.usercaution.length>0){var j=0;clearTimeout(j),j=setTimeout(function(){$.alert("警告",{info:'<span style="font-size: 14px; line-height: 24px;">'+OP_CONFIG.usercaution+"</span>",callback:function(){window.location.href="//www.imooc.com/passport/user/logout?referer=//www.imooc.com"}})},3e3)}$(document).delegate(".js-closeBindHint","click",function(){v.set("bindHintNotShow","true",{expires:1}),$(".js-bindHintBox").hide()}),$("body").delegate(".js-refresh","click",function(){window.location.reload()}),$(function(){var a=$('[data-search="top-banner"]'),c=new g(a),h=($(".search-area"),$(".showhide-search"),$(".search-input"));$("#nav, #sub-nav").on("click",".search-input",function(){$(".searchTags").hide()}),$("#nav, #sub-nav").on("blur",".search-input",function(a){0==$(a.currentTarget).val().length&&$(".searchTags").show()}),$("#nav,.course-top-search,#sub-nav,.search-warp").on("click",".showhide-search",function(a){return $(".searchTags").hide(),""!=h.val()?c.search(h.val()):h.focus(),a.stopPropagation(),!1}),$("#nav, #sub-nav").on("click",".search-area",function(a){return a.stopPropagation(),!1}),$(document).on("click",function(){""==h.val()&&v()});var v=function(){}}),$(function(){"code"==OP_CONFIG.page&&$("#J_GotoTop").hide();var h=0;clearTimeout(h),-2==OP_CONFIG.userout&&(h=setTimeout(function(){$.alert("你的账号在另一地点登录，已被强迫下线。",{info:"如果不是本人操作，建议你修改密码。",callback:function(){window.location.href="//www.imooc.com"}})},600)),a(),c(),$('[action-type="my_menu"],#nav_list').on("mouseenter",function(){$('[action-type="my_menu"]').addClass("hover"),$("#nav_list").show()}),$('[action-type="my_menu"],#nav_list').on("mouseleave",function(){$('[action-type="my_menu"]').removeClass("hover"),$("#nav_list").hide()}),$("#set_btn").click(function(){location.href="/space/course"}),$("#js-signin-btn").on("click",function(e){e.preventDefault(),require.async("../../logic/login/login-regist",function(a){a.init()})}),$("#js-signup-btn").on("click",function(e){e.preventDefault(),require.async("../../logic/login/login-regist",function(a){a.signup()})}),$("#nav-item a:eq(0)").click(function(){b.remove("lange_id"),b.remove("pos_id"),b.remove("tab_id"),b.remove("is_easy"),b.remove("sort")}),$("#backTop").click(function(){$("html,body").animate({scrollTop:0},200)}),$(window).scroll(function(){c()}),$(document).on("keydown",function(e){13==e.keyCode&&e.ctrlKey&&($(document).trigger("submit.imooc"),e.preventDefault())})}),!function(){var a,c,h;if(c=window.navigator.userAgent,h=/;\s*MSIE (\d+).*?;/.exec(c),h&&+h[1]<9){if(a=document.cookie.match(/(?:^|;)\s*ic=(\d)/),a&&a[1])return;$("body").prepend(["<div id='js-compatible' class='compatible-contianer'>","<p class='cpt-ct'><i></i>您的浏览器版本过低。为保证最佳学习体验，<a href='/static/html/browser.html'>请点此更新高版本浏览器</a></p>","<div class='cpt-handle'><a href='javascript:;' class='cpt-agin'>以后再说</a><a href='javascript:;' class='cpt-close'><i></i></a>","</div>"].join("")),$("#js-compatible .cpt-agin").click(function(){var d=new Date;d.setTime(d.getTime()+2592e6),document.cookie="ic=1; expires="+d.toGMTString()+"; path=/",$("#js-compatible").remove()}),$("#js-compatible .cpt-close").click(function(){$("#js-compatible").remove()})}}();var w=0;$("#header-user-card").on("mouseenter",function(){clearTimeout(w),$(this).hasClass("hover")||$(this).addClass("hover")}).on("mouseleave",function(e){e.stopPropagation();var a=$(this);w=setTimeout(function(){a.hasClass("hover")&&a.removeClass("hover")},300)});var k=function(){$.ajax({url:"//order.imooc.com/pay/cartorder",dataType:"jsonp",jsonp:"jsonpcallback",success:function(a){if(0==a.result&&(a.data.order&&1*a.data.order&&$(".js-cart-num").attr("data-ordernum",a.data.order),a.data.cart&&1*a.data.cart)){var c=parseInt(a.data.order);$(".js-cart-num").attr("data-cartnum",a.data.cart),$(".js-cart-num").html(parseInt(a.data.cart)+c).show()}},complete:function(){}})};k();var y=0,C=0;$("#shop-cart").on("mouseenter",function(){C||(C=1,$.initGetCart()),clearTimeout(y),$(this).hasClass("hover")||($(this).addClass("hover"),$("#nav").addClass("addZ-index"))}).on("mouseleave",function(e){e.stopPropagation();var a=$(this);y=setTimeout(function(){a.hasClass("hover")&&(a.removeClass("hover"),$("#nav").removeClass("addZ-index"),"index"==OP_CONFIG.module&&"index"==OP_CONFIG.page?$("#nav").addClass("addZ-index"):$("#nav").removeClass("addZ-index"))},300)}),$("#js-my-cart").on("click",".js-close",function(){var a=this,c=$(a).parents(".js-item"),h=c.data("typeid"),v=c.data("type"),g=c.data("goodsid"),b={type_id:h,type:v,goods_id:g};$.ajax({url:"//order.imooc.com/pay/delcartgoods",dataType:"jsonp",data:b,jsonp:"jsonpcallback",success:function(a){if("0"==a.result){c.remove();var h=$("#js-card-ul").find("li").length;if(0==h){var v='<div class="cart-title-box clearfix">                                        <h2 class="l">我的购物车</h2>                                        <h5 class="r">已加入<span class="js-incart-num">0</span>门课程</h5>                                    </div>                                    <div class="cart-wrap">                                        <div class="clear-cart">                                            <span class="cartIcon icon-shopping-cart"></span>                                            <h3>购物车里空空如也</h3>                                            <div class="text">快去这里选购你中意的课程</div>                                            <p><a class="go-link" href="//coding.imooc.com" target="_blank">实战课程</a></p>                                            <p><a class="go-link" href="//class.imooc.com" target="_blank">就业班</a></p>                                        </div>                                    </div>                                    <div class="more-box clearfix">                                        <div class="l show-box">                                            <span class="text"><a href="//order.imooc.com/myorder" target="_blank">我的订单中心</a></span>                                        </div>                                        <a href="//order.imooc.com/pay/cart" target="_blank" class="r moco-btn moco-btn-red go-cart">去购物车</a>                                    </div>';$("#js-my-cart").html(v),$(".js-cart-num").html("").attr("data-cartnum",0).hide()}else{var g=parseInt($(".js-cart-num").html()),b=parseInt($(".js-cart-num").attr("cartnum"));$(".js-cart-num").html(parseInt(g-1)).attr("cartnum",parseInt(b-1));var j=parseInt($(".js-incart-num").html());$(".js-incart-num").html(parseInt(j-1))}}else $.alert(a.msg)}})}),$(".js-show-menu").on("click",function(e){return $("html").addClass("holding"),$("body").addClass("slide-left"),$(".slide-left-opa")[0]||$("body").append('<div class="slide-left-opa" style="position: absolute; top: 0; right: 130px; left: 0;bottom: 0; background: rgba(0 ,0,0,0.3); z-index: 2000;"></div>'),document.getElementsByClassName("slide-left-opa")[0].addEventListener("touchstart",function(){return $("html").removeClass("holding"),$("body").removeClass("slide-left"),$(".slide-left-opa").remove(),!1},!1),e.stopPropagation(),!1}),$("body").on("click",".slide-left-opa",function(){$("html").removeClass("holding"),$("body").removeClass("slide-left"),$(".slide-left-opa").remove()}),!function(){$(document).on("click","[data-ast]",function(){$.get("/index/adclick",{ast:$(this).attr("data-ast"),r:(new Date).getTime()})}).on("click","[data-track]",function(){$.get("/index/clickuserlog",{track:$(this).attr("data-track"),r:(new Date).getTime()})})}(),$("#js-app-load").on("mouseover",function(){$(".js-load-box").show(),$("#nav").addClass("addZ-indexCode")}),$("#js-app-load").on("mouseout",function(){$(".js-load-box").hide(),$("#nav").removeClass("addZ-indexCode")})});