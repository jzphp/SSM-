	var signinTpl ='<div id="signin" class="rl-modal">\
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
							<input type="text" value=""  maxlength="37" name="email" data-validate="require-mobile-phone" autocomplete="off" class="xa-emailOrPhone ipt ipt-email js-own-name" placeholder="请输入登录手机号/邮箱"/>\
							<p class="rlf-tip-wrap errorHint color-red" data-error-hint="请输入正确的邮箱或手机号"></p>\
						</div>\
						<div class="rlf-group  pr">\
							<a href="javascript:void(0)" hidefocus="true" class="proclaim-btn js-proclaim imv2-visibility_off is-pwd" tabindex="-1"></a>\
							<input type="password" name="password" data-validate="require-password" class="ipt ipt-pwd js-loginPassword js-pass-pwd" placeholder="请输入密码" maxlength="16" autocomplete="off"/>\
					        <p class="rlf-tip-wrap errorHint color-red " data-error-hint="请输入6-16位密码,区分大小写,不能用空格"></p>\
						</div>\
						<div class="rlf-group clearfix form-control js-verify-row">\
						    <input type="text"  name="verify" class="ipt ipt-verify l" data-validate="require-string" data-callback="checkverity"  maxlength="4" data-minLength="4" placeholder="请输入验证码">\
						    <a href="javascript:void(0)" hidefocus="true" class="verify-img-wrap js-verify-refresh"></a>\
						    <a href="javascript:void(0)" hidefocus="true" class="icon-refresh js-verify-refresh"></a>\
							<p class="rlf-tip-wrap errorHint color-red" data-error-hint="请输入正确验证码"></p>\
						</div>\
						<div class="rlf-group rlf-appendix form-control  clearfix">\
							<label for="auto-signin" class="rlf-autoin l" hidefocus="true"><input type="checkbox" checked="checked" class="auto-cbx" id="auto-signin">7天内自动登录</label>\
							<a href="//www.imooc.com/help/detail/127" class="rlf-forget r" target="_blank" hidefocus="true">无法登录</a>\
							<div class="rlf-line r"></div>\
							<a href="//www.imooc.com/user/newforgot" class="rlf-forget r" target="_blank" hidefocus="true">找回密码</a>\
						</div>\
						<p class="rlf-tip-globle color-red" id="signin-globle-error"></p>\
						<div class="rlf-group clearfix">\
							<input  type="button" value="登录" hidefocus="true" class="moco-btn moco-btn-red moco-btn-lg btn-full xa-login"/>\
						</div>\
				    </form>\
		  	</div>\
		  </div>\
		  <div class="rl-model-footer">\
			<div class="pop-login-sns clearfix">\
				<span class="l rlf-other xa-showPhoneSignin">手机短信登录</span>\
				<a href="javascript:void(0)" hidefocus="true" data-login-sns="/passport/user/tplogin?tp=weibo" class="pop-sns-weibo l"><i class="imv2-weibo"></i></a>\
				<a href="javascript:void(0)" hidefocus="true" data-login-sns="/passport/user/tplogin?tp=weixin" class="pop-sns-weixin l"><i class="imv2-weixin"></i></a>\
				<a href="javascript:void(0)" hidefocus="true" data-login-sns="/passport/user/tplogin?tp=qq" class="pop-sns-qq l"><i class="imv2-qq"></i></a>\
			</div>\
			 <div class="erweima xa-showQrcode"></div>\
		  </div>\
		</div>\
	'


