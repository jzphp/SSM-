
var email_RegisterFinishedTpl = '<div id="signin" class="rl-modal ">\
		  <div class="rl-modal-header">\
		    <button type="button" class="rl-close js-refresh" data-dismiss="modal" aria-hidden="true"></button>\
		    <h1>\
				<span data-fromto="signup:signin"  class="xa-showSignin">登录</span>\
				<span  class="active-title">注册</span>\
		    </h1>\
		  </div>\
		  <div class="rl-modal-body phoneVerityBox">\
		    <form id="signup-form">\
				<p class="rlf-tip-globle " id="signin-globle-error"></p>\
				<div class="user_header"></div>\
				<p class="title">注册成功，请立即验证邮箱</p>\
				<p class="subtitle">邮件发送至 \
				<span class="color-red js-account breakall"></span>\
				</p>\
				<div class="rlf-group clearfix finished_wrap">\
					<a  class="moco-btn moco-btn-red " id="js-gotoVerity" style="padding:12px 25px; margin-right:10px;" target="_blank">去邮箱验证</a>\
			        <a href="//www.imooc.com/user/phonevalidate/"  target="_blank" class="moco-btn moco-btn-normal" style="padding:12px 25px;">其它验证方式</a>\
			    	<a href="//www.imooc.com/help/detail/75" target="_blank" class="cantGot  js-resendMail" style="  position: relative;top: 10px; display:block">收不到邮件怎么办</a>\
			    </div>\
		    </form>\
		  </div>\
		</div>'