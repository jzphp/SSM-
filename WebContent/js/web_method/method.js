    'use strict';
    var Webname_Regular = /^[0-9a-zA-Z-_ \u4e00-\u9fa5]*$/,           //昵称的正则表达式。
        Webpassword_Regular = /^^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/,        //注册登录密码的正则表达式。
        //Webphone_Regular = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|17[0|1|3|5|6|7|8]|18[0|1|2|3|4|5|6|7|8|9])\d{8}$/,   //手机号的正则表达式。
        Webphone_Regular = /^(13[0-9]|14[0-9]|15[0-9]|16[0-9]|17[0-9]|18[0-9]|19[0-9])\d{8}$/,      //手机号的正则表达式。
        Webqq_Regular = /^[1-9][0-9]{4,14}$/;                              //QQ号的正则表达式
    //创建网页快捷方式
    function toDesktop(sUrl,sName){
        try{
            var WshShell = new ActiveXObject("WScript.Shell");
            var oUrlLink = WshShell.CreateShortcut(WshShell.SpecialFolders("Desktop") + "\\" + sName + ".url");
            oUrlLink.TargetPath = sUrl;
            oUrlLink.Save();
        }catch(e){
            alert("当前IE安全级别不允许操作！");
        }
    }
    //收藏网页
    function show_Favorite(sURL, sTitle){
        sURL = encodeURI(sURL);try{window.external.addFavorite(sURL,
            sTitle);}catch(e)
        {try{window.sidebar.addPanel(sTitle, sURL, "");}catch
            (e)
        {alert("加入收藏失败，请使用Ctrl+D进行添加,或手动在浏览器里进行设置.");}}
    }
    //检测键盘事件。(保证输入值为数字并且，解除方向键的时间监听)
    function keyboards(chooser){       //参数：需要检测的输入框选择器；
        chooser.on("keyup",function(e){
            if(e.keyCode == 37 || e.keyCode == 38 || e.keyCode == 39 || e.keyCode == 40){
                //执行数字和方向键的代码
            }else{
                chooser.val(chooser.val().replace(/[^0-9]/g,''))
            }
        })
    }
    //弹窗方法
    function pop_method(obj){
        layer.open({
            type: obj.type,                    //设为1即可
            title: obj.title,                  //是否设置默认标题，设置为false即可
            closeBtn: obj.closeBtn,           //设为1即可
            area:obj.area,                     //设置尺寸
            skin: obj.skin,                    //没有背景色
            shadeClose: obj.shadeClose,       //点击蒙版弹窗是否消失
            content: obj.content              //节点
        });
    }
    //复制粘贴板
    function copyToClipboard(elem) {
        var targetId = "_hiddenCopyText_";
        var isInput = elem.tagName === "INPUT" || elem.tagName === "TEXTAREA";
        var origSelectionStart, origSelectionEnd;
        if (isInput) {
            // 如果是input标签或textarea，则直接指定该节点
            target = elem;
            origSelectionStart = elem.selectionStart;
            origSelectionEnd = elem.selectionEnd;
        } else {
            // 如果不是，则使用节点的textContent
            target = document.getElementById(targetId);
            if (!target) {
                //如果不存在，则创建一个
                var target = document.createElement("textarea");
                target.style.position = "absolute";
                target.style.left = "-9999px";
                target.style.top = "0";
                target.id = targetId;
                document.body.appendChild(target);
            }
            target.textContent = elem.textContent;
        }
        // 聚焦目标节点，选中它的内容
        var currentFocus = document.activeElement;
        target.focus();
        target.setSelectionRange(0, target.value.length);
        // 进行复制操作
        var succeed;
        try {
            succeed = document.execCommand("copy");
        } catch(e) {
            succeed = false;
        }
        // 不再聚焦
        if (currentFocus && typeof currentFocus.focus === "function") {
            currentFocus.focus();
        }
        if (isInput) {
            // 清空临时数据
            elem.setSelectionRange(origSelectionStart, origSelectionEnd);
        } else {
            // 清空临时数据
            target.textContent = "";
        }
        return succeed;
    }
    //时间搓转化为日期
    function formatDate(now)   {
        var   year = new Date(now).getFullYear();
        var   month = new Date(now).getMonth()+1;
        var   date = new Date(now).getDate();
        var   hour = new Date(now).getHours();
        if(hour < 10){hour = "0"+hour;}
        var   minute = new Date(now).getMinutes();
        if(minute < 10){minute = "0"+ minute;}
        var   second = new Date(now).getSeconds();
        return  year+"/"+month+"/"+date+" "+hour+":"+minute;
    }
    //分转元保留二位小数
    function money(money) {
        return (parseInt(money) * 100 / 10000).toFixed(2);
    }
    //系统后台左侧的导航显示隐藏
    function system_background_nav(){
        $(".sideMenu h3").click(function() {
            if($(this).hasClass("on")) {
                $(this).next().slideUp();
                $(this).removeClass("on");
            } else {
                $(this).next().slideDown();
                $(this).addClass("on");
            }
        });
    }
    //分享赚钱
    function newpage_indexshare(){
        //微信分享的弹窗提示
        var photoSrc;  //抓取当前点击的商品图片链接放置位置。
        var goodsIDphoto; //获取商品的ID
        var FXclick = $(".fight_link .myfr");
        FXclick.on("click",function(){
            goodsIDphoto = $(this).next().val();
            $.ajax({
                type:"post",
                url:"user/share/activity?",
                data:{activityId:goodsIDphoto},
                async:true,
                dataType:"json",
                success:function(datacon){
                    if(datacon.code == 10000){
                        console.log(datacon);
                        //成功的回调
                        $("#shopQRCode").attr("src",datacon.data)
                    }
                }
            });
            $("#copy").css("background","#ff366f");
            if($(this).attr("data") == 1){ //新人专享
                photoSrc = $(this).parent().next().children().attr("src");
            }else{
                photoSrc = $(this).next().next().children().attr("src");
            }
            console.log(photoSrc);
            layer.open({
                type: 1,
                title: false,
                closeBtn: 1,
                area:['920px','480px'],
                skin: 'layui-layer-nobg', //没有背景色
                shadeClose: true,
                content: $("#share_box")
            });
            LinkShare();
            $("#share_box").parents(".layui-layer").css("top",120);
        });
        function LinkShare(){
            //分享到QQ空间。
            var QQ_shareUrl = 'http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?';
            QQ_shareUrl += 'url=' + encodeURIComponent('http://laqu.com/user-spokesman-index?memberType=1&inviteCode='+$(".shareUrl").val());   //参数url设置分享的内容链接|默认当前页location
            QQ_shareUrl += '&summary=' + encodeURIComponent("亲爱的们都来看看吧，好东西要分享给最好的朋友，赶紧去免费领取吧！");    //参数summary设置分享摘要，可选参数
            QQ_shareUrl += '&pics=' + encodeURIComponent(photoSrc);   //参数pics设置分享图片的路径，多张图片以＂|＂隔开，可选参数
            $(".space").attr("href",QQ_shareUrl);
            //分享到腾讯微博。
            var tweet_shareUrl = 'http://v.t.qq.com/share/share.php?';
            tweet_shareUrl += 'title=' + encodeURIComponent("亲爱的们都来看看吧，好东西要分享给最好的朋友，赶紧去免费领取吧！");    //分享的标题
            tweet_shareUrl += '&url=' + encodeURIComponent('http://laqu.com/user-spokesman-index?memberType=1&inviteCode='+$(".shareUrl").val());    //分享的链接
            //tweet_shareUrl += '&appkey=5bd32d6f1dff4725ba40338b233ff155';    //在腾迅微博平台创建应用获取微博AppKey
            tweet_shareUrl += '&pic=' + encodeURIComponent(photoSrc);    //分享的图片，如果是多张图片，则定义var _pic='图片url1|图片url2|图片url3....'
            $(".blogs").attr("href",tweet_shareUrl);
            //分享到新浪微博
            var sina_shareUrl = 'http://v.t.sina.com.cn/share/share.php?&appkey=895033136';     //真实的appkey ，必选参数
            sina_shareUrl += '&url='+ encodeURIComponent('http://laqu.com/user-spokesman-index?memberType=1&inviteCode='+$(".shareUrl").val());     //参数url设置分享的内容链接|默认当前页location，可选参数
            sina_shareUrl += '&title=' + encodeURIComponent("亲爱的们都来看看吧，好东西要分享给最好的朋友，赶紧去免费领取吧！");    //参数title设置分享的标题|默认当前页标题，可选参数
            sina_shareUrl += '&content=' + 'utf-8';   //参数content设置页面编码gb2312|utf-8，可选参数
            sina_shareUrl += '&pic=' + encodeURIComponent(photoSrc);  //参数pic设置图片链接|默认为空，可选参数
            $(".weibo").attr("href",sina_shareUrl);
        }
        LinkShare();
    }