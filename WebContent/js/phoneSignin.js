	 var phoneSigninTpl = '<div id="signin" class="rl-modal">\
		  <div class="rl-modal-header">\
		    <h1>\
				<span class="active-title">登录</span>\
				<span data-fromto="signin:signup" class="xa-showSignup">注册</span>\
		    </h1>\
		    <button type="button" class="rl-close" data-dismiss="modal" hidefocus="true" aria-hidden="true"></button>\
		  </div>\
		  <div class="rl-modal-body js-loginWrap">\
		  	<div class="clearfix">\
					<form id="signup-form" autocomplete="off">\
						<div class="rlf-group pr">\
							<div class="rlf-areacode">+86</div>\
							<input type="text" value=""  maxlength="37" name="phone" data-validate="require-mobile-phone" autocomplete="off" class="ipt ipt-phone js-phone-name" placeholder="短信登录仅限中国大陆用户"/>\
							<p class="rlf-tip-wrap errorHint color-red" data-error-hint="请输入正确的手机号"></p>\
						</div>\
						<div class="rlf-group pr phoneVerityBox">\
							<input type="text" id="js-phoneVerity" data-validate="require-string" data-minLength="4"   class="ipt ipt-pwd" placeholder="请输入短信验证码" maxlength="4" autocomplete="off"/>\
							<p class="reSend pa active js-phonecode-box"><span class="js-signin-send">获取验证码</span></p>\
							<p class="rlf-tip-wrap errorHint color-red" data-error-hint="请输入正确验证码" ></p>\
						</div>\
						<div class="rlf-group rlf-appendix form-control  clearfix">\
							<label for="auto-signin" class="rlf-autoin l" hidefocus="true"><input type="checkbox" checked="checked" class="auto-cbx" id="auto-signin">7天内自动登录</label>\
						</div>\
						<p class="rlf-tip-globle color-red" id="signin-globle-error"></p>\
						<div class="rlf-group clearfix">\
							<input  type="button" value="登录" hidefocus="true" class="moco-btn moco-btn-red moco-btn-lg btn-full xa-phone-login"/>\
						</div>\
				    </form>\
		  	</div>\
		  </div>\
		  <div class="rl-model-footer">\
			<div class="pop-login-sns clearfix">\
				<span class="l rlf-other xa-showSignin">账号密码登录</span>\
				<a href="javascript:void(0)" hidefocus="true" data-login-sns="/passport/user/tplogin?tp=weibo" class="pop-sns-weibo l"><i class="imv2-weibo"></i></a>\
				<a href="javascript:void(0)" hidefocus="true" data-login-sns="/passport/user/tplogin?tp=weixin" class="pop-sns-weixin l"><i class="imv2-weixin"></i></a>\
				<a href="javascript:void(0)" hidefocus="true" data-login-sns="/passport/user/tplogin?tp=qq" class="pop-sns-qq l"><i class="imv2-qq"></i></a>\
			</div>\
			 <div class="erweima xa-showQrcode"></div>\
		  </div>\
		</div>\
	'
