/**
 * 
 */

$(function(){
	
	var userCode = $("#userCode");
	var password = $("#password");
	var password2 = $("#password2");
	var email = $("#email");
	
	//email验证
	var checkUsernameReg = /^[A-Za-z]{3}\w{0,13}$/;
	//用户名验证
	
	//密码验证

	var userCodeBox = $("#userCodeBox");
	var passwordBox = $("#passwordBox");
	var password2Box = $("#password2Box");
	$("tr").css("width","500px");
	var genderBox = $("#genderBox");
	var emailBox = $("#emailBox");
	
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
			
			userCodeBox.css("color","purple").html("您输入的用户名为:"+(userCode.val()));
			
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
					url:$("#hidden").val()+"/userName.do",
					data:{method:"checkAccountExist",userCode:userCode.val()},
					dataType:"json",
					success:function(data){
						
						 if (data.result == "true") {

							 userCodeBox.css("color","red").html("用户已存在，不可注册");					
							 
						
						
					}else if(data.result=="false"){
						
						userCodeBox.css("color","yellowgreen").html("可以注册");
						userNameCheck =true;
						//用户名校验通过
					}//if条件
						
					},
					error:function(){
						
						window.location ="errorBackToRegister.jsp";
						
						
					}
					
					
					
					
					
					
					
				});//userName用户名ajax异步验证结尾
			}//判断是否为空值的位置
		}
		
		
		
		
		
	});//userCode事件
	
	

	
	
	
	var emailReg = /^([A-Za-z]+\w*\@){1}(\w+\.)+[A-Za-z0-9]+$/ig;
	var checkPasswordReg = /^\w{8,32}$/;
	//密码格式验证
	password.bind("focus",function(){
	
			
			passwordBox.html("请输入密码，最少为8位字符").css("color","purple");
			
		
		
	}).bind("blur",function(){
		
		if(password.val().match(checkPasswordReg)&& password.val()!=null && password.val()!=""){
					
					passwordBox.html("正确").css("color","yellowgreen");
					
					//正则验证密码的正确性
					
				}else if(password.val()==null || password.val()==""){
					
					passwordBox.html("错误，不可为空").css("color","red");
					
				}else{
					
					passwordBox.html("错误，不符合规范,最少位8位字符").css("color","red");
					
				}//密码验证
			
		
	});//首次密码验证;

	password2.bind("focus",function(){
		
		password2Box.html("请再次输入密码").css("color","purple");
		
		
		
	}).bind("blur",function(){
		
		if(password.val()==password2.val() && password2.val()!=null && password2.val()!=""){
			
			password2Box.html("二次输入正确").css("color","yellowgreen");
			passwordCheck = true;
			//双次密码验证通过
			
			
		}else{
			
			password2Box.html("请检查密码").css("color","red");
			
		}
		
		
		
		
		
		
	});//二次校验密码；
	email.bind("focus",function(){
		
		emailBox.html("请输入邮箱，例如:vip@vip.com.cn").css("color","purple");
		
		
		
	}).bind("blur",function(){
		
		if(email.val().match(emailReg)&& email.val()!=null && email.val()!=""){
					
					emailBox.html("正确").css("color","yellowgreen");
					emailCheck = true;
					
					
				}else{
					
					emailBox.html("错误，请检查格式，例如：vip@vip.com.cn").css("color","red");
					
				}
		
		
		
	});//email校验

	var submitBtn = $("#submit");
	submitBtn.bind("click",function(){

		if(userNameCheck == true && emailCheck == true && passwordCheck == true){
				submitBtn.submit();

		}else{
			alert("请检查数据");
			
			
			
		}
		
		
		
	})//submit点击事件;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
});//结尾
