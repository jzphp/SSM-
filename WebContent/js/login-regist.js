define(['/static/lib/login-regist/login-view.js','placeholder'], function($) {
    var viewSignin = "";
    var viewSignup = "";
    var m = {
        signin:function(){
            if(viewSignup == "") {
                if(viewSignin == ""){
                     viewSignin = new Loginview ({
                        el: 'body',
                        mode: 'signin'});               
                    viewSignin.render();
                }else{
                    viewSignin.render('signin');
                }
            }else{
                viewSignup.render('signin');
            }

        },
        signup:function(){
            if(viewSignin == ""){

                if(viewSignup == ""){
                    viewSignup = new Loginview ({
                        el: 'body',
                        mode: 'signup'});
                    viewSignup.render()
                }else{
                    viewSignup.render('signup');
                }
            }else{

                 viewSignin.render('signup');
            }
        }
    };

	return {
        init : function(){
        	//$("body").append(getTpl("signin"));
        	m.signin();
            imoocSSO.preLogin({
                error:function(){
                    setTimeout(imoocSSO.preLogin,2000);
                }
            });
        },
		signup:function(){
			m.signup();
            imoocSSO.preLogin({
                error:function(){
                    setTimeout(imoocSSO.preLogin,2000);
                }
            });
		}
    };

});


