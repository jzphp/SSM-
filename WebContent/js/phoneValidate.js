var phoneValidateTpl ='<div id="signin" class="rl-modal">\
	  <div class="rl-modal-body js-loginWrap">\
	  	<div class="clearfix">\
			<div class="l-left-wrap l">\
				<form id="signup-form" autocomplete="off">\
					<p class="rlf-tip-globle color-red" id="signin-globle-error"></p>\
					<div class="rlf-group pr">\
						<input type="text" value=""  maxlength="37" name="email" data-validate="require-mobile-phone" autocomplete="off" class="xa-emailOrPhone ipt ipt-email js-own-name" placeholder="请输入手机号"/>\
						<p class="rlf-tip-wrap errorHint color-red" data-error-hint="请输入正确手机号"></p>\
					</div>\
					<div class="rlf-group clearfix form-control js-verify-row">\
					    <input type="text"  name="verify" class="ipt ipt-verify l" data-validate="require-string" data-callback="checkverity"  maxlength="4" data-minLength="4" placeholder="请输入验证码">\
					    <a href="javascript:void(0)" hidefocus="true" class="verify-img-wrap js-verify-refresh"></a>\
					    <a href="javascript:void(0)" hidefocus="true" class="icon-refresh js-verify-refresh"></a>\
						<p class="rlf-tip-wrap errorHint color-red" data-error-hint="请输入正确验证码"></p>\
					</div>\
					<div class="rlf-group clearfix">\
						<input  type="button" value="验证和绑定" hidefocus="true" class="btn-red btn-full xa-login"/>\
					</div>\
			    </form>\
			</div>\
	  	</div>\
	  </div>\
	</div>\
'


