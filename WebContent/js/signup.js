

	var signupTpl = '<div id="signup" class="rl-modal  rl-model-signup">\
	 <div class="rl-modal-header">\
		    <button type="button" class="rl-close" data-dismiss="modal" aria-hidden="true"></button>\
		    <h1>\
				<span data-fromto="signup:signin" class="xa-showSignin">登录</span>\
				<span class="active-title">注册</span>\
		    </h1>\
		  </div>\
		  <div class="rl-modal-body js-modal-body js-registerWrap">\
		    <form id="signup-form pr">\
				<div class="rlf-group  pr">\
				<div class="rlf-areacode js-code-btn">+<span>86</span><i class="imv2-arrow1_d"></i></div>\
							<input type="text"  maxlength="37" value="" name="email" data-callback="checkusername" data-validate="require-mobile-phone" autocomplete="off" class="ipt ipt-phone" placeholder="请输入注册手机号"/>\
							<p class="rlf-tip-wrap errorHint color-red" data-error-hint="请输入正确的手机号"></p>\
						</div>\
				<div class="rlf-group clearfix form-control ">\
				    <input type="text"  name="verify" class="ipt ipt-verify js-emailverify l" data-validate="require-string" data-callback="checkverity" autocomplete="off" maxlength="4" data-minLength="4" placeholder="请输入验证码">\
				    <a href="javascript:void(0)" hidefocus="true" class="verify-img-wrap js-verify-refresh"></a>\
				    <a href="javascript:void(0)" hidefocus="true" class="icon-refresh js-verify-refresh"></a>\
					<p class="rlf-tip-wrap errorHint color-red" data-error-hint="验证码错误"></p>\
				</div>\
				<div class="rlf-group rlf-appendix form-control  clearfix" style="margin-bottom:0">\
					<label for="signup-protocol" class="rlf-autoin l" hidefocus="true"><input type="checkbox" class="auto-cbx" id="signup-protocol">同意<a class="ipt-agreement" target="_blank" href="https://www.imooc.com/help/detail/89">《慕课网注册协议》</a></label>\
					<p class="rlf-tip-wrap errorHint color-red rlf-tip-globle"  id="signup-globle-error" data-error-hint="请同意慕课网注册协议"></p>\
				</div>\
				<div class="rlf-group clearfix">\
					<a href="javascript:void(0)"  id="signup-btn"  hidefocus="true" class="moco-btn moco-btn-red moco-btn-lg btn-full btn r"> 注册 </a>\
				</div>\
		    </form>\
		  </div>\
		  <div class="rl-model-footer">\
		  	<div class="pop-login-sns clearfix">\
		  		<span class="l ">其他方式登录：</span>         \
		  		<a href="javascript:void(0)" hidefocus="true" data-login-sns="/passport/user/tplogin?tp=weibo" class="pop-sns-weibo r"><i class="imv2-weibo"></i></a>\
		  		<a href="javascript:void(0)" hidefocus="true" data-login-sns="/passport/user/tplogin?tp=weixin" class="pop-sns-weixin r"><i class="imv2-weixin"></i></a>\
		  		<a href="javascript:void(0)" hidefocus="true" data-login-sns="/passport/user/tplogin?tp=qq" class="pop-sns-qq r"><i class="imv2-qq"></i></a>\
		  	</div>\
		  </div>\
		  <div class="areacode-box js-code-box">\
		  		<ul class="code-tab">\
					<li class="curr js-code-tab">常用</li><li class="js-code-tab">A</li><li class="js-code-tab">B</li><li class="js-code-tab">C</li>\
					<li class="js-code-tab">D</li><li class="js-code-tab">E</li><li class="js-code-tab">F</li><li class="js-code-tab">G</li>\
					<li class="js-code-tab">H</li><li class="js-code-tab">J</li><li class="js-code-tab">K</li>\
					<li class="js-code-tab">L</li><li class="js-code-tab">M</li><li class="js-code-tab">N</li>\
					<li class="js-code-tab">P</li><li class="js-code-tab">R</li><li class="js-code-tab">S</li>\
					<li class="js-code-tab">T</li><li class="js-code-tab">W</li>\
					<li class="js-code-tab">X</li><li class="js-code-tab">Y</li><li class="js-code-tab">Z</li>\
		  		</ul>\
		  		<div class="code-title"><span>常用</span></div>\
		  		<div class="code-list nano">\
					<ul class="nano-content js-code-list">\
					</ul>\
		  		</div>\
		  </div>\
		</div>\
	'




