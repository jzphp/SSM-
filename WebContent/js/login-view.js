define(['placeholder','modalbutton','autocomplete','../util/core.js','../jquery-qrcode/jquery.qrcode.min.js','../jquery-nanoscroller/jquery.nanoscroller.js',
    './tpl/signup.js',
    './tpl/signin.js',
    './tpl/erweima.js',
    './tpl/phoneVerity.js',
    './tpl/registerFinished.js',
    './tpl/emailVerity.js',
    './tpl/email_RegisterFinished.js',
    './tpl/phoneValidate.js',
    './tpl/phoneSignin.js',
    './tpl/areacode.js',
    '../util/cookie.js',
    '../backbone/backbone-1.0.0.min.js'], function() {



      Loginview = Backbone.View.extend({

        initialize: function(options) {
            this.verifyFinished = false;
            this.options = options;
            if(options&&options.mode=="signup"){
                this.dom = signupTpl;
            }else{
                this.dom = signinTpl;
            }
            this.interval = null;
            this.val = null;
            this.loginWithCode = false;
            this.verifyLoad = false;
            this.IfPWDTypeChange = true;
            var _this = this;
            moco.validateCallback['checkusername'] = function(value){

               _this.blurToCheckUserName(value);
            };
            moco.validateCallback['checkverity'] = function(value){
               _this.checkverity(value);
            }

            if( OP_CONFIG){
                new Fingerprint2().get(function(result){
                  OP_CONFIG.browser_key=result; 
                });
            }
        },

        events: {
            "mousedown #signup-btn":    "clickToSignup",
            "click .js-verify-refresh":   "clickToRefreshVerifyCode",
            "click .xa-showSignup":   "clickToShowSignup",
            "click .xa-showSignin":   "clickToShowSignin",
            "click .xa-showPhoneSignin":   "clickToShowPhoneSignin",
            "mousedown .js-proclaim":   "clickToProclaimCode",
            "click .xa-showQrcode":   "clickToShowQrcode",
            "click .xa-hideQrcode":   "clickToHideQrcode",
            "click .xa-refresh":   "clickToShowQrcode",
            "keyup .xa-emailOrPhone":   "keyupCheckEmailOrPhone",
            "focus .xa-emailOrPhone":   "focusautocomplete",
            "focus input":   "focusToHideError",
            "blur .xa-emailOrPhone":   "blurToTrim",
            "click .js-reSend":   "clickToresendPhoneCode",
            "click .js-voicecode-send":   "clickToresendVoiceCode",
            "click .js-signin-send":   "clickSigninPhoneCode",
            "click .js-signin-voice-send":   "clickSigninVoiceCode",
            "click .js-back":   "clickToBack",
            "click [data-login-sns]":   "clickShowotherLogin",
            "click .xa-endRegister":   "clickToFinishedRegiter",
            "mousedown .xa-submitePhoneVerity":    "clickTosubmitePhoneVerity",
            "click .xa-login":    "clickToLogin",
            "click .xa-phone-login":    "clickToPhoneLogin",
            "keyup .js-loginPassword":    "keyupJudgeIfShwoVerity",
            "keyup .js-loginWrap input":    "keyupToTriggerLogin",
            "keyup .js-registerWrap input":    "keyupToTriggerRegister",
            "keyup .js-phoneVerityWrap input":    "keyupToTriggerSubmitePhoneVerity",
            "click #js-gotoVerity":    "clickToVerityEmail",
            "click  .js-gotoSetting":    "clickTolink",
            "click  .js-gotoLearn":    "clickTolearn",
            "keydown .ipt-verify" : "focusIfCanVertify",
            "click #signup-protocol":    "clickProtocol",
            "click  .js-code-tab":    "clickAreaCode",
            "click  .js-code-btn":    "showAreaCode",
            "click  [data-code]":    "setAreaCode",
        },

        focusIfCanVertify : function(){
            console.log("change================")
            this.verifyFinished = false;
        },

        keyupToTriggerLogin:function(e){
            if(e.keyCode=="13"){
                this.$el.find(".xa-login").trigger('click');
            }
        },

        keyupToTriggerRegister:function(e){
            if(e.keyCode=="13"){
                this.$el.find("#signup-btn").trigger('mousedown');
            }

        },

        keyupToTriggerSubmitePhoneVerity: function(e){
            if(e.keyCode=="13"){
                this.$el.find(".xa-submitePhoneVerity").trigger('mousedown');
            }
        },

        keyupJudgeIfShwoVerity: function(){
            if(!this.loginWithCode){
                if(!this.verifyLoad){
                        this.verifyLoad = true;
                        var _this = this;
                        $.get( imoocSSO.checkVerifyUrl,"username="+$('[name="email"].ipt').val(), function(data){
                                if(data.status == 10001){
                                _this.showLoginVerify();
                                }
                            },"json");
                        }
                }else{
                    this.showLoginVerify();
                 }


        },
        showLoginVerify:function(){

            if( this.$el.find('.js-verify-row').css("display")=='none') {

                this.$el.find('.js-verify-row').show();
                this.$el.find('.verify-img-wrap').append(
                    $('<img class="verify-img"/>')
                );
            }
            this.refreshVerifyCode();
        },

        focusToHideError:function(){
            $('.rlf-tip-globle').text('');
        },

        blurToTrim:function(event){
             $(event.currentTarget).val($.trim( $(event.currentTarget).val()));
        },

        focusautocomplete: function(event){
            $(event.currentTarget).autocomplete();
        },
        clickProtocol:function(){
            if (!$("#signup-protocol")[0].checked) {
                $("#signup-protocol").parents(".rlf-group").find('.rlf-tip-wrap').addClass("rlf-tip-error").html("请同意慕课网注册协议");
            }else{
                $("#signup-protocol").parents(".rlf-group").find('.rlf-tip-wrap').removeClass("rlf-tip-error").html("");
            }
        },

        clickToSignin: function(){
        },

        clickShowotherLogin: function(event){
            this.winsns.open($(event.currentTarget).attr("data-login-sns"));
        },
        keyupCheckEmailOrPhone: function(event){
            var $node = $(event.currentTarget);
            if($node.val().indexOf("@")!=-1) {
                $node.attr("data-validate","require-email");
                //$node.parent().find(".errorHint").attr("data-error-hint","邮箱格式错误");
                this.$el.find(".xa-passwordWrap").show();
            }else{
                if($node.val().indexOf("+")==0){
                    $node.attr("data-validate","");
                }else{
                    $node.attr("data-validate","require-mobile-phone");
                }
                  //$node.parent().find(".errorHint").attr("data-error-hint","手机号格式错误");
                this.$el.find(".xa-passwordWrap").hide();
            }

        },
         math:function(){
            var genericEmailLinks="sohu.com::http://mail.sohu.com \
                        |sina.com,sina.cn :: http://mail.sina.com \
                        |vip.sina.com :: http://vip.sina.com.cn \
                        |126.com :: http://www.126.com \
                        |163.com :: http://mail.163.com \
                        |vip.163.com :: http://vip.163.com \
                        |vip.126.com :: http://vip.126.com \
                        |qq.com,vip.qq.com :: http://mail.qq.com \
                        |msn.com,outlook.com,hotmail.com,live.cn,live.com :: http://outlook.com \
                        |gmail.com :: http://www.gmail.com \
                        |yahoo.com.cn,yahoo.cn,aliyun.com :: http://mail.aliyun.com \
                        |yahoo.com.tw :: http://mail.yahoo.com.tw \
                        |21cn.com :: http://mail.21cn.com \
                        |tom.com :: http://mail.tom.com/ ",
            genericEmailLinksMap={};

            $.each(genericEmailLinks.split("|"),function(index,v){
                var val=v.split("::"),
                    v=$.trim(val[1]),
                    i,len;
                val=val[0].split(",");
                for(i=0,len=val.length;i<len;i++){
                    genericEmailLinksMap[$.trim(val[i])]=v;
                }
            });


            var link = genericEmailLinksMap[this.val.username.match(/[^@]*$/)[0]];
            return link;


        },
        clickToVerityEmail: function(){
            var link = this.math()
            window.open(link);
            //window.location.reload();

        },

        clickTolink: function(){
            window.location.href = '//www.imooc.com/user/setprofile'
        },

        blurToCheckUserName: function(value){
            var username = value;
            moco.validateCallback.rel = false;
            var url="/passport/user/checkphone"
            ,data= {phone:username};
            if(username.indexOf("@")!=-1){

                url=imoocSSO.checkUserName;
                data = {username:username};
            }
            $.ajax({
                url:url,
                method:"get",
                async: false,
                data:data,
                dataType:"json",
                success:function(data){
                    if(data.status==10001){
                        moco.validateCallback['errorHint'] = '';
                        moco.validateCallback.rel = true;
                    }
                    else{
                        moco.validateCallback['errorHint'] = data.msg;
                        moco.validateCallback.rel = false;

                       // $(event.currentTarget).parent().find(".errorHint").html("fail");

                    }
                },
                error:function(){
                    moco.validateCallback['errorHint'] = "网络错误"

                },
            })

        },

        checkverity: function(value){
                moco.validateCallback.rel = false;
                console.log(this.verifyFinished)
                if(this.verifyFinished) {
                    if(moco.validateCallback['errorHint'] != ''){
                        moco.validateCallback['errorHint'] = "网络错误"
                    }else{
                        moco.validateCallback.rel = true;
                    }

                    return;
                }
                var _this = this;
                console.log('开始校验验证码');
                var _this = this;
                $.ajax({
                    url:imoocSSO.checkVerifyCode,
                    method:"get",
                    async: false,
                    data:{verify: value},
                    dataType:"json",
                    success:function(data){
                        console.log('this.emailRetisterFinish',_this.emailRetisterFinish)
                        if(! this.emailRetisterFinish) {
                            if(data.status == 10001){
                                moco.validateCallback['errorHint'] = '';
                                moco.validateCallback.rel = true;
                            }
                            else{
                                moco.validateCallback['errorHint'] = data.msg;
                            }
                        }
                    },
                    error:function(){
                        moco.validateCallback['errorHint'] = "网络错误"

                    },

                    complete:function(){
                        _this.verifyFinished = true;
                    },
                })

        },

        clickToSignup: function(event){

            console.log("点击注册======");
            if (!W.validate(this.$el.find(".xa-emailOrPhone").parent())) {
                return;
            }
            if (!W.validate(this.$el.find(".ipt-verify ").parent())) {
                return;
            }
            if (!$("#signup-protocol")[0].checked) {
                $("#signup-protocol").parents(".rlf-group").find('.rlf-tip-wrap').addClass("rlf-tip-error").html("请同意慕课网注册协议");
                return;
            }

            $(event.currentTarget).text("正在注册...");
             $(event.currentTarget).attr("disabled","disabled");

            var data = {
                code:$(".js-code-btn").text(),
                username: this.$el.find("[name='email'].ipt").val(),
                verify: this.$el.find(".ipt-verify").val(),
            }

            this.val = data;



                this.phoneRegister(data);

        },

        clickToShowSignup: function(){
            clearInterval(this.interval);
            this.dom = signupTpl;
            this.render();
            $(".nano").nanoScroller();
        },

        clickToShowSignin: function(){
            clearInterval(this.interval);
            this.dom = signinTpl;
            this.render();

        },

        clickToShowQrcode: function(){
            clearInterval(this.interval);
            this.dom = erweimaTpl;
            this.render();
            var code = new GUID().newGUID();
            //扫描二维码用的url，不用改https
            var codeStr =  "http://www.imooc.com?ma="+code;
            $('#qrcode').qrcode({width: 160,height: 160,text: codeStr});
            this.loopScan(code);
        },

        clickToHideQrcode: function() {
            clearInterval(this.interval);
            this.dom = signinTpl;
            this.render();
        },

        clickToProclaimCode: function(event) {
            event.stopPropagation();
            this.proclaimCode(event);
        },

        clickToRefreshVerifyCode: function(){
            this.refreshVerifyCode();
        } ,

        clickTosubmitePhoneVerity: function(vals) {

            if (!W.validate(this.$el.find("#js-phoneVerity").parent())) {
                return;
            }

            if (!W.validate(this.$el.find(".js-pass-pwd").parent())) {
                return;
            }
            $(".xa-submitePhoneVerity").text("正在提交...");
            $(".xa-submitePhoneVerity").attr("disabled","disabled");
            var _this = this;
            var plantform = $.getUrlParam('plantform');
            var val ={
                number:$(".js-phoneNumber").data("phone"),
                mobileverify:$("#js-phoneVerity").val(),
                password:$("#js-password").val(),
                type:1,
                referer:window.location.protocol+"//"+window.location.hostname,
                plantform: plantform,
            }
            if($(".js-phoneNumber").data("code")!="+86"){
                val.number = $(".js-phoneNumber").data("code") + val.number;
            }

            var _data = { username:$(".js-phoneNumber").html()}
            $.ajax({
                url:"/passport/user/phoneregister",
                data:val,
                method:"post",
                dataType:"json",
                success:function(res){
                    if(res.status == 10001){

                            // var uid = res['userInfo']['uid'];
                            // var ipaddata = {};
                            // ipaddata.account = val.number;
                            //  ipaddata.uid = uid;
                            // ipaddata.plantform = $.getUrlParam('plantform');
                            // if(plantform=='ipad'){
                            //     window.webkit.messageHandlers.registerSuccess.postMessage(JSON.stringify(ipaddata));
                            //     return;
                            // }

                            imoocSSO.crossDomainAction(function(){
                                _this.showRegisterFinished(_data);

                            })
                            imoocSSO.setCrossDomainCookie(res['data']['url']);

                    }else{
                        $("#signin-globle-error").addClass("rlf-tip-error").html(res['msg']);
                    }

                },
                error:function(res){

                    $("#signup-globle-error").addClass("rlf-tip-error").html("服务错误，稍后重试");
                },
                complete:function(){

                    $(".xa-submitePhoneVerity").text("提交").removeAttr("disabled").removeClass("disabled");
                }

            })

        },


        clickToFinishedRegiter: function(){
            window.location.href="//www.imooc.com/user/setprofile"
        },

        showPhoneVerity: function(val){
            this.dom = phoneVerityTpl;
            this.render();
            $(".js-phoneNumber").html(val.code+" "+val.username).attr("data-code",val.code).attr("data-phone",val.username);
            var appendVoicecodeFlag = 0;
            var index = 60;
                clearInterval(this.interval);
            var voicestr = "";
            if(val.code=="+86"){
                voicestr = '<span class="voicecode-send js-voicecode-send"><i class="imv2-vol_up"></i>语音接听</span>'
            }
            var senddom = $(".js-phonecode-box");
            var _this = this;
            senddom.removeClass("active").html('重新发送 '+index);
            this.interval = setInterval(function(){
                index--;
                
                if(index==0){
                    senddom.addClass("active");
                    senddom.html('<span class="js-reSend">重新发送</span>'+voicestr);
                    clearInterval(_this.interval);
                }else{
                    senddom.html('重新发送 '+index);
                }
                
            },1000)
        },
        clickToShowPhoneSignin: function(){
            clearInterval(this.interval);
            this.dom = phoneSigninTpl;
            this.render();
        },
        //手机登录验证码
        clickSigninPhoneCode: function() {
            $("#js-phoneVerity").parents(".rlf-group").find('.rlf-tip-wrap').html("");
            clearInterval(this.interval);
            this.phoneSignin(0);
        },
        //手机登录语音验证码
        clickSigninVoiceCode: function() {
            clearInterval(this.interval);
            this.phoneSignin(1);
        },
        //手机号登陆，获取验证码
        phoneSignin: function(type) {
            if (!W.validate(this.$el.find(".js-phone-name").parent())) {
                return;
            }

            var _this = this;
            var val = {
                phone:$(".js-phone-name").val(),
                typecode:type
            };
  
            $.ajax({
                url:"/passport/user/getphonelogincode",
                data:val,
                method:"post",
                dataType:"json",
                success:function(data){
                     if(data.status == 10001){

                        _this.showPhoneSignin();

                     }else{
                        //重发5次 不允许再发
                        if(data.status == 11001){
                            
                            $(".js-phonecode-box").html("");
                        }
                        $('.rlf-tip-globle').text(data.msg);
                    }
                },
                error:function(){
                    $("#signup-globle-error").addClass("rlf-tip-error").html("服务错误，稍后重试");
                }
            })

        },
        showPhoneSignin: function(){
            var index = 60;
            clearInterval(this.interval);
            var senddom = $(".js-phonecode-box");
            var _this = this;
            senddom.removeClass("active").html('重新发送 '+index);
            this.interval = setInterval(function(){
                index--;
                
                if(index==0){
                    senddom.addClass("active");
                    senddom.html('<span class="js-signin-send">重新发送</span><span class="voicecode-send js-signin-voice-send"><i class="imv2-vol_up"></i>语音接听</span>');
                    clearInterval(_this.interval);
                }else{
                    senddom.html('重新发送 '+index);
                }
                
            },1000)
        },

        loginWarnTipTemp: function(result,isflag,id){
            var tepl= '<p class="warn-info" style="font-size: 16px;line-height: 28px;max-width: 600px;">'+result+'</p>';
            if(isflag && typeof id != 'undefined'){
                if(id == 'imooc'){
                     tepl+= '<p class="warn-tip" style="color: #999;margin-top: 30px;">可能导致账号冻结的原因  <a href="//www.imooc.com/help/detail/81" target="_blank" style="color: #08c !important;">了解详情</a></p>';
                }else{
                     tepl+= '<p class="warn-tip" style="color: #999;margin-top: 30px;">可能导致账号冻结的原因  <a href="//www.imooc.com/help/detail/101" target="_blank" style="color: #08c !important;">了解详情</a></p>';
                }
            }
            tepl+='<div class="moco-modal-btns"><a class="moco-btn moco-btn-blue moco-modal-close js-modal-close" href="javascript:void(0)"><span>确定</span></a></div>';                 
            return tepl;
        },
        clickToPhoneLogin: function(vals,type) {
            if (!W.validate(this.$el.find(".js-phone-name").parent())) {
                return;
            }
            if (!W.validate(this.$el.find("#js-phoneVerity").parent())) {
                return;
            }

            var remember=$("#auto-signin")[0].checked?"1":"0";
            var _this = this;
            var val = {
                phone:$(".js-phone-name").val(),
                code: $("#js-phoneVerity").val(),
                remember:remember,
                referer:window.location.protocol+"//"+window.location.hostname,
            };

            $(".xa-phone-login").val("正在登录...").attr("disabled","disabled").addClass('disabled');
            $(".js-signin-send,.js-signin-voice-send").attr("disabled","disabled");

            $.ajax({
                url:"/passport/user/phonelogin",
                data:val,
                method:"post",
                dataType:"json",
                success:function(data){
                     if(data.status == 10001){
                        if(data.caution){
                           var str=_this.loginWarnTipTemp(data.caution,false);

                            $("#signin [data-dismiss],#signup [data-dismiss]").trigger("click");
                            if( $.dialog){
                                $.dialog(str,{
                                    title: '提示',
                                    modal: true,
                                    callback: function(){
                                        window.location.href = 'http://www.imooc.com/index/usercheck?uid=' + data.data.userInfo.uid;
                                    }
                                });
                            }else{
                                alert(data.caution)
                                window.location.href = 'http://www.imooc.com/index/usercheck?uid=' + data.data.userInfo.uid;
                            }
                        }else{
                            imoocSSO.crossDomainAction(function(){
                                window.location.reload();
                            })
                            imoocSSO.setCrossDomainCookie(data['data']['url']);
                        }


                     }else if(data.status == 10020){
                        var str = '';
                        var _str= '十分抱歉，由于您的账号最近在实战中存在严重违规的情况，已做冻结账号处理';
                        str=_this.loginWarnTipTemp(_str,true,'shizhan');
                        if( $.dialog){
                            $.dialog(str,{
                                title: '提示',
                                modal: true
                            });
                        }else{
                            alert(_str)
                        }

                            $("#signin [data-dismiss],#signup [data-dismiss]").trigger("click");
                    }else if(data.status == 10021){
                        var str = '';
                        var _str= '十分抱歉，由于您的账号最近在实战中被多次警告，已做冻结账号处理';
                        str=_this.loginWarnTipTemp(_str,true,'shizhan');
                        if( $.dialog){
                            $.dialog(str,{
                                title: '提示',
                                modal: true
                            });
                        }else{
                            alert(_str)
                        }

                            $("#signin [data-dismiss],#signup [data-dismiss]").trigger("click");
                    }else if(data.status == 10022){
                        var str = '';
                        var _str = '十分抱歉，由于您的账号最近在慕课网被多次警告，已做冻结账号处理';
                        str=loginWarnTipTemp(_str,true,'imooc');
                        if( $.dialog){
                            $.dialog(str,{
                                title: '提示',
                                modal: true
                            });
                        }else{
                            alert(_str)
                        }

                            $("#signin [data-dismiss],#signup [data-dismiss]").trigger("click");
                    }else if(data.status == 10006){
                        var str = '';
                        var _str = '十分抱歉，由于您的账号最近在慕课网中存在严重违规的情况，已做冻结账号处理';
                        str=loginWarnTipTemp(_str,true,'imooc');
                        if( $.dialog){
                            $.dialog(str,{
                                title: '提示',
                                modal: true
                            });
                        }else{
                            alert(_str)
                        }

                            $("#signin [data-dismiss],#signup [data-dismiss]").trigger("click");
                    }else{
                        $(".xa-phone-login").val("登录").removeAttr("disabled").removeClass("disabled");
                        $("#signin-globle-error").addClass("rlf-tip-error").html(data.msg);
                    }
                },
                error:function(){
                    $(".xa-phone-login").val("登录").removeAttr("disabled").removeClass("disabled");
                    $("#signup-globle-error").addClass("rlf-tip-error").html("服务错误，稍后重试");
                },
                complete:function(){
                    $(".xa-phone-login").val("登录").removeAttr("disabled").removeClass("disabled");
                }
            })
        },
        showAreaCode:function(){
            $(".js-code-box").toggle();
            if($(".js-code-list li").length==0){
                this.bindAreaCode(0);
            }
        },
        setAreaCode:function(event){
            var code = $(event.target).data("code");
            $(".js-code-btn span").text(code);
            $(".js-code-box").hide();
            $(".ipt-phone").focus();

            if(code!="86") {
                $(".ipt-phone").attr("data-validate","");
                $(".ipt-phone").parents(".rlf-group").find('.rlf-tip-wrap').html("")
            }else{
                $(".ipt-phone").attr("data-validate","require-mobile-phone");
            }

        },
        clickAreaCode:function(event){
            var obj = $(event.target);
            obj.addClass('curr').siblings().removeClass('curr');
            this.bindAreaCode(obj.index());
        },
        bindAreaCode:function(id){
            var areacode = AreaCode[id];
            var str = "";
            for(var i=0; i<areacode.length; i++){
                str += '<li data-code="'+areacode[i].code+'">'+areacode[i].name+'（+'+areacode[i].code+' ）</li>'
            }
            $(".js-code-list").html(str);
            $(".nano").nanoScroller();
        },
        clickToBack: function() {
            this.clickToShowSignup();
        },
        clickTolearn:function(){
            var url = cookieInfo.get("urlcookie")||"/";
            if(url.indexOf("checkemail")!=-1||url.indexOf("phonevalidate")!=-1|| url.indexOf("newlogin")!=-1 ||  url.indexOf("newsignup")!=-1){
                url="/"
            }
            window.location.href = url;
        },
        clickToShowSignin: function(){
            this.dom = signinTpl;
            this.render();
        },
        showRegisterFinished: function(data){
            this.dom = registerFinishedTpl;
            this.render();
        },
        clickToresendPhoneCode: function() {
            clearInterval(this.interval);

            this.phoneRegister(this.val,0);
        },
        //语音验证码
        clickToresendVoiceCode: function() {
            clearInterval(this.interval);

            this.phoneRegister(this.val,1);
        },

        phoneRegister: function(vals,type) {
            $("#signup-btn").attr("disabled","disabled");
            $(".reSend").attr("disabled","disabled");

            var _this = this;
            var val = {
                number:vals.username,
                verify: vals.verify
            };
            if(type) {
                val.typecode = 1;
            }
            if(vals.code != "+86"){
                val.number = vals.code + val.number;
            }

            $.ajax({
                url:"/passport/user/phoneregister",
                data:val,
                method:"post",
                dataType:"json",
                success:function(data){
                     if(data.status == 10001){

                        _this.showPhoneVerity(vals);

                        // $(".rl-modal-body").html(getTpl("phoneVerity"));


                     }else{

                        $("#signup-btn").text("注册").removeAttr("disabled").removeClass("disabled");
                        $("#signup-globle-error").addClass("rlf-tip-error").html(data.msg);
                        //重发5次 不允许再发
                        if(data.status == 11001){
                            $('.rlf-tip-globle').text(data.msg);
                            $(".js-reSend").css("color","#B4B8BB");
                            $(".js-reSend").css("cursor","default");
                            $(".js-reSend").removeClass("active");
                            $(".js-reSend").html("");
                            $(".js-voicecode-send").html("");
                            $(".js-reSend").removeClass("js-reSend");
                            $(".js-second").html("");
                        }
                    }

                },
                error:function(){
                    $("#signup-btn").text("注册").removeAttr("disabled").removeClass("disabled");
                    $("#signup-globle-error").addClass("rlf-tip-error").html("服务错误，稍后重试");
                },
                complete:function(){
                    $("#signup-btn").text("注册").removeAttr("disabled").removeClass("disabled");
                    $(".reSend").removeAttr("disabled");
                }

            })


        },

        loopScan: function(code){
            var _this = this;
            var index = 0;
            var _code = code;
            function scanCode(){

                if(!$(document).find(".js-pageLogin").length){

                    if(!$(document).find(".modal-backdrop").length){
                        return
                    }
                }
                if(index>=30){
                    clearInterval(_this.interval);
                    $(".qrcode-bk-validate").removeClass("hide");
                    $(".qrcode-bk-scand").addClass("hide");
                }else{
                    $.ajax({
                        url:"/passport/user/ScanCodesz",
                        method:"post",
                        data:{codeid: _code},
                        dataType:"json",
                        success:function(obj){
                            //var obj = JSON.parse(data);
                            var status = obj.data[0]['status']
                            if( status != 3) {
                                if(status == 0){
                                    $(".qrcode-bk-scand").removeClass("hide");
                                    $(".qrcode-bk-validate").addClass("hide");
                                }
                                else{
                                    if(status == 1) {
                                        clearInterval(_this.interval);
                                        _this.getToken({
                                            keyid: obj.data[0]['keyid'],
                                            uid: obj.data[0]['uid'],
                                            codeid: _code,
                                         });
                                        ///passport/user/scancode
                                     // {"result":0,"data":[{"status":"0","kyeid":"8a461c0046ffc97fa75df66372c9a51f"}],"msg":1000}
                                    }
                                    if(status == 2) {
                                        $(".qrcode-bk-scand").addClass("hide");
                                        $(".qrcode-bk-validate").addClass("hide");
                                    }
                                }
                            }

                        },
                        error:function(data){
                        }
                    })
                }
                index++;
            }
            clearInterval(this.interval);
            this.interval= setInterval(scanCode, 2000);

        },

        clickToLogin: function(event) {
            $('.xa-emailOrPhone').keyup();
            if (!W.validate(this.$el.find(".xa-emailOrPhone").parent())) {
                return;
            }
            if (!W.validate(this.$el.find(".js-pass-pwd ").parent())) {
                return;
            }

            if (!W.validate(this.$el.find(".ipt-verify ").parent())) {
                return;
            }

            var data = {
                username: this.$el.find("[name='email'].ipt").val(),
                password: this.$el.find("[name='password'].ipt").val(),
                verify: this.$el.find(".ipt-verify").val(),
            }
            this.val = data;


            var _this = this;
            $(".xa-login").val("正在登录...");
            $(".xa-login").attr("disabled","disabled");
            var $this=$(event.currentTarget);
            var signInForm=$('#signup-form');
            if($this.hasClass("disabled")){ return;}
            var remember=$("#auto-signin")[0].checked?"1":"0",
                    params = {
                        username:data.username,
                        password:data.password,
                        verify:data.verify,
                        remember:remember,
                        pwencode:1,
                        browser_key:OP_CONFIG.browser_key
                    };

                //sso方式登录
                imoocSSO.login({
                    data:params,
                    success:function(data){
                        var userinformation = data.data;
                        data.data={userInfo:""}
                        if(data.status==10001){
                            _this.fireLogined(data.data.userInfo);
                            return ;
                        }

                        else if(data.status==900001){
                            window.location.href="//www.imooc.com/user/userfrozen";
                            return ;
                        }
                        else if(data.status == 10005||data.status == 10007||data.status == 90003){ // 需要出验证码
                            _this.showLoginVerify();
                        }else if(data.status == 10024){
                            cookieInfo.set('urlcookie', document.URL, { expires : 1, domain:'imooc.com', path:"/"});
                            window.location.href = "//www.imooc.com/user/checkemail";
                            return;
                        }else if(data.status == 10025){ //uuid超过8个 需要验证手机
                            window.location.href = "//www.imooc.com/index/phonecheck?uid=" + userinformation ;
                            return;
                        }
                        $("#signin-globle-error").addClass("rlf-tip-error").html(data.msg);

                        if(_this.loginWithCode){
                            _this.refreshVerifyCode();
                            signInForm.find('.ipt-verify').val('');
                        }
                        //$("#signin-btn").button("reset");
                    },
                    error:function(){
                        $("#signin-globle-error").addClass("rlf-tip-error").html("服务错误，稍后重试");
                    },
                    complete:function(){
                         $(".xa-login").val("登录").removeAttr("disabled").removeClass("disabled");
                    }
                })
        },
        fireLogined: function(data,signup) {
            var e=$.extend($.Event("logined.imooc"),{_data:data});

            $("#signin [data-dismiss],#signup [data-dismiss]").trigger("click");
            $(document).trigger(e);
            this.winsns.clear();

            if(e.isDefaultPrevented()){
                return ;
            }
            //default actions; can be prevent by call e.preventDefault method
            if(signup) {
                window.location.replace("//www.imooc.com/user/setprofile");
                return ;
            }
            var pathname=window.location.pathname,forward;

            forward="error,forget,logout,newforgot,userfrozen,sendresult,resetpasspage,resetpassword,checkaopenguser".split(",").join("|");
            forward=new RegExp("\\/(?:"+forward+")(?:\\/|$|\\?|#)");
            if(forward.test(pathname)){ //remove pathname=="/" index login
                window.location.replace("/"); ///index
                return ;
            }
            if(OP_CONFIG&&OP_CONFIG.page=='newlogin'){
                if(fromURL!=undefined && fromURL!=""){
                    window.location.replace(fromURL);
                    return ;
                }
            }

            window.location.reload();
        },

        getToken : function (ops){
            $.ajax({
                url:"/passport/user/scancode",
                method:"post",
                dataType:"json",
                data:ops,
                success:function(res){
                    
                    if( res.data.caution){
                        
                        $('#signin').hide()
                        $('.modal-backdrop').hide()
                        
                        var str = '<p class="warn-info" style="font-size: 16px;line-height: 28px;max-width: 600px;">'+res.data.caution+'</p>';
                            str += '<div class="moco-modal-btns">';
                                str += '<a class="moco-btn moco-btn-blue js-modal-close" href="javascript:void(0)">'
                                    str += '<span>确定</span>';
                                str += '</a>';
                            str += '</div>';
                        
                        if( $.dialog){
                            $.dialog( str,{
                                title: '警告',
                                modal: true,
                                callback: function(){
                                    window.location.href = '//www.imooc.com/index/usercheck?uid=' + res.data.userInfo.uid;
                                }
                            });
                        }else{
                            alert(res.data.caution)
                            window.location.href = '//www.imooc.com/index/usercheck?uid=' + res.data.userInfo.uid;
                        }
                        return;
                    }
                    
                    imoocSSO.crossDomainAction(function(){
                        window.location.reload();
                    })
                    imoocSSO.setCrossDomainCookie(res['data']['url'])
                },
                error:function(error){
                }
            })
        },

        proclaimCode : function(event){
            if(this.IfPWDTypeChange){
                if($(".js-pass-pwd").attr("type")=="password"){
                    $(".js-pass-pwd").attr("type",'text');
                    $(event.target).addClass('imv2-visibility').removeClass('imv2-visibility_off')
                }else{
                    $(".js-pass-pwd").attr("type",'password');
                    $(event.target).removeClass('imv2-visibility').addClass('imv2-visibility_off')
                }
                this.IfPWDTypeChange = false;
                var _this = this;
                setTimeout(function(){
                    _this.IfPWDTypeChange = true;
                },200)
            }
        },

        refreshVerifyCode: function(){
            this.$el.find('.verify-img').attr('src', imoocSSO.verifyCodeUrl+"?t=" + new Date().getTime());
        } ,

        // showLoginVerify: function(){
        //     this.loginWithCode = true;
        //     this.$el.find('.js-verify-row').show();
        // },



        winsns: function(){
            var o={};

            function clearPrev(){//dereference
                for(var key in o){
                    if(key.indexOf("/user")>-1){
                        o[key].close&&o[key].close();
                        o[key]=null;
                        delete o[key];
                    }
                }
            }

            return {
                open:function(url){
                    var l,t;
                    if(o[url]&&o[url].closed===false){
                        o[url].focus&&o[url].focus();
                        return ;
                    }
                    clearPrev();
                    l=(screen.width-650)/2,
                    t=(screen.height-400)/2;
                    (o[url]=window.open(url+"&browser_key="+OP_CONFIG.browser_key+"&referer="+window.location.protocol+"//"+window.location.hostname, '_blank', 'toolbar=no, directories=no, status=no, menubar=no, width=650, height=500, top='+t+', left='+l)).focus();
                },
                clear:clearPrev
            }
        }(),

        render: function(mode) {
            $(document.body).addClass('overhidden');
            if(mode == 'signin'){
                this.dom = signinTpl;
                clearInterval(this.interval);
            }
            if(mode == 'signup'){
                this.dom = signupTpl;
                clearInterval(this.interval);
            }

            this.loginWithCode=false;
            this.verifyLoad = false
            $(".rl-modal").remove();
            $(".modal-backdrop").remove();
            this.$el.append(this.dom);

            if(this.dom!==signinTpl) {
                this.$el.find('.verify-img-wrap').append(
                    $('<img class="verify-img"/>')
                );
                this.refreshVerifyCode();
            }else{
                this.$el.find('.js-verify-row').hide();
            }
            var m=$(".rl-modal");
            m.modallogin("show");
            if(typeof(ownName) !== "undefined"){
                $(".js-own-name").val(ownName)
            };
            var $node =$(".xa-emailOrPhone");
            if($node.val()){
                if($node.val().indexOf("@")!=-1) {
                    $node.attr("data-validate","require-email");
                }else{
                    if($node.val().indexOf("+")==0){
                        $node.attr("data-validate","");
                    }else{
                        $node.attr("data-validate","require-mobile-phone");
                    }
                }
            }
        }

    });


    var winsns=(function(){
        var o={};

        function clearPrev(){//dereference
            for(var key in o){
                if(key.indexOf("/user")>-1){
                    o[key].close&&o[key].close();
                    o[key]=null;
                    delete o[key];
                }
            }
        }

        return {
            open:function(url){
                var l,t;
                if(o[url]&&o[url].closed===false){
                    o[url].focus&&o[url].focus();
                    return ;
                }
                clearPrev();
                l=(screen.width-650)/2,
                t=(screen.height-400)/2;
                (o[url]=window.open(url+"&referer="+window.location.protocol+"//"+window.location.hostname, '_blank', 'toolbar=no, directories=no, status=no, menubar=no, width=650, height=500, top='+t+', left='+l)).focus();
            },
            clear:clearPrev
        }
    })();



    var fireLogined=window.__fireLogined=window.__fireLogined||function(data,signup){

        var e=$.extend($.Event("logined.imooc"),{_data:data});
        $("#signin [data-dismiss],#signup [data-dismiss]").trigger("click");
        $(document).trigger(e);
        winsns.clear();
        // $.dialog('<div class="regisetdHintDialog"><div class="icon-tick-revert hint-icon s-right"></div>\
        //     <div class="finshBox">\
        //     <p class=" hint1">成功授权登录，是否现在前往绑定？</p>\
        //      <p class=" hint2">您的帐号存在安全隐患，完成邮箱/手机验证将提升安全程度</p>\
        //     <a href="/user/setprofile" class="moco-btn moco-btn-blue " id="js-gotoVerity" target="_blank">马上去验证</a>\
        //     <button class="moco-btn moco-btn-normal  js-refresh">暂不验证</button>\
        //     </div>\
        // </div>\
        // ',{modal:true,title:" "});

        if(e.isDefaultPrevented()){
            return ;
        }
        //default actions; can be prevent by call e.preventDefault method
        if(signup) {
            window.location.replace("//www.imooc.com/user/setprofile");
            return ;
        }
        var pathname=window.location.pathname,forward;

        forward="error,forget,logout,newforgot,userfrozen,sendresult,resetpasspage,resetpassword,checkaopenguser,newsignup".split(",").join("|");
        forward=new RegExp("\\/(?:"+forward+")(?:\\/|$|\\?|#)");
        if(forward.test(pathname)){ //remove pathname=="/" index login
            window.location.replace("/"); ///index
            return ;
        }
        window.location.reload();

    }





 

});
