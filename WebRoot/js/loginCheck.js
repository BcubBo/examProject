/**
 * 
 */

var account = null;
var password = null;
var submitButton = null;
var form = null;

$(function() {
    account = $("#user_code");
    password = $("#user_password");
    submitButton = $("#loginButton");
    form = $("#form1");
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


                } else if (data.result == "false") {

                    $("#checkBoxUser").html("用户不存在,请注册").css("color", "red");


                }
            },
            error: function(data) {}






        });



    });
    submitButton.bind("click", function() {


        $.ajax({

            type: "GET",
            url: $("#hidden").val() + "/login.do",
            data: { method: "loginCheck", userCode: account.val(), password: password.val() },
            dataType: "json",
            success: function(data) {
                if (data.result == "true") {

                    form.submit();


                } else if (data.result == "false") {

                    $("#checkBoxUser").html("请检查账号和密码").css("color", "red");
                    $("#checkBox").html("请检查账号和密码").css("color", "red");


                }
            },
            error: function(data) {

                window.location = "error.jsp";




            }






        });
        if (password.val().length < 6) {


            $("#checkBox").css("color", "red").html("密码长度错误，最少为6位");

        } else {

            $("#checkBox").css("color", "yellowgreen").html("密码输入格式正确");


        };














    
    
    
    
    
    
    
    
    });
});