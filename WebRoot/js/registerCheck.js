/**
 * 
 */

$(function(){
	
	var userCode = $("#userCode");
	var password = $("#password");
	var password2 = $("#password2");
	var email = $("#email");
	var emailReg = /^([A-Za-z]+\w*\@){1}(\w+\.)+[A-Za-z0-9]+$/ig;
	//email验证
	var checkUsernameReg = /^[A-Za-z]{3}\w{0,13}$/;
	//用户名验证
	var checkPasswordReg = /^\w{8,32}$/;
	//密码验证

	var userCodeBox = $("#userCodeBox");
	var passwordBox = $("#passwordBox");
	var password2Box = $("#password2Box");
	$("tr").css("width","500px");
	var genderBox = $("#genderBox");
	var emaiBox = $("#emailBox");
	
	var userNameCheck = false;
	//用户名检查结果标记
	var passwordCheck =false;
	//密码检查结果标记
	var emailCheck = false;
	//邮箱检查结果标记
	
	//添加鼠标聚焦移除事件
	userCode.bind("focus",function(){
		
		if(userCode.val()==null || userCode.val()==""){
			
			userCodeBox.css("color","red").html("用户名不可为空且以字母开头最多16位数字");
			
			
		}else{
			
			userCodeBox.css("color","red").html("您输入的用户名为:"+(userCode.val()));
			
		}
		
		
		
		
	}).bind("blur",function(){
		
		if(userCode.val() ==null || userCode.val()==""){
			
			userCodeBox.css("color","red").html("用户名不可为空");
			
		}else{
			if(userCode.val()<3 ){
				
				userCodeBox.html("长度不够").css("color","red");
				
			}else if(userCode.val()>16){
				
				userCodeBox.html("最长位16位").css("color","red");
				
				
			}else if(userCode.val().match(checkUsernameReg)){
				
				
				$.ajax({
					
					type:"GET",
					url:$("#hidden").val()+"/register.do",
					data:{method:"checkAccountExist",userCode:userCode.val()},
					dataType:"json",
					success:function(data){
						
						 if (data.result == "true") {

							 userCodeBox.css("color","red").html("用户已存在，不可注册");					
							 
						
						
					}else if(data.result=="false"){
						
						userCodeBox.css("color","yellowgreen").html("可以注册");
						userNameCheck =true;
					}//if条件结尾
						
					},
					error:function(){
						
						window.location ="errorBackToRegister.jsp";
						
						
					}
					
					
					
					
					
					
					
				});//userName用户名ajax异步验证结尾
			}//判断是否位空值得位置
		}
		
		
		
		
		
	});//userCode事件结尾
	
	password.bind("focus",function(){}).bind("blur",function(){});//密码验证结尾;
	passwordBox.bind("focus",function(){}).bind("blur",function(){});//二次校验密码结尾；
	email.bind("focus",function(){}).bind("blur",function(){});//email校验结尾
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
});//结尾
