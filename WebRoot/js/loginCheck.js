



$(function() {
	var account = $("#user_code");
	var  password = $("#user_password");
	var submitButton = $("#loginButton");
	var  form = $("#form1");
    
   
    
   

    userNameFlag = false;
    passwordFlag =false;
    account.bind("focus", function() {

        //



    }).bind("blur", function() {

        $.ajax({

            type: "GET",
            url: $("#hidden").val() + "/login.do",
            data: { method: "checkAccountExist", userCode: account.val() },
            dataType: "json",
            success: function(data) {
                if (data.result == "true") {

                    $("#checkBoxUser").html("用户在数据库中存在可登录").css("color", "yellowgreen");
                    userNameFlag = true;

                } else if (data.result == "false") {

                    $("#checkBoxUser").html("用户不存在,请注册").css("color", "red");


                }
            },
            error: function(data) {
            	 alert("请检查账户");
                 window.location="login.jsp";
            }


           



        });



    });
    password.bind("blur", function() {


        $.ajax({

            type: "GET",
            url: $("#hidden").val() + "/logindoublecheck.do",
            data: { method: "loginCheck", userCode: account.val(), password: password.val() },
            dataType: "json",
            success: function(data) {
                if (data.doubleCheckResult == "true") {

                         $("#checkBox").css("color", "yellowgreen").html("密码输入格式正确");
                        
                         passwordFlag = true;
                     
                    


                } else if (data.doubleCheckResult == "false") {

                    $("#checkBoxUser").html("请检查账号和密码").css("color", "red");
                    $("#checkBox").html("请检查账号和密码").css("color", "red");


                }
            },
            error: function(data) {
            	alert("请检查账户");
                window.location = "login.jsp";




            }
        });//密码异步验证
        submitButton.bind("click",function(){
	
        	if(userNameFlag == true && passwordFlag ==true){
        		
        		
        		form.submit();
        		
        		
        		
        		
        		
        	}else{
        		
        		
        		alert("请检查账户和密码");
        		
        		
        	}
	
	
	
	
	
	
	
	
	
        });





        });
       














    
    
    
    
    
    
    
    

});