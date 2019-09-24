//用户名

$(function () {




//密码
    $("#upwd").blur(function () {
        var pwd = $("#upwd").val();
        // var pwdreg = /^(?![a-zA-z]+$)(?!\d+$)(?![!@#$%^&*]+$)[a-zA-Z\d!@#$%^&*]{6,16}$/;
        var pwReg = /^[a-zA-Z]\w{5,17}$/;
        if (null == pwd || "" == pwd) {
            alert("密码不能为空");
            $("#repwd_msg").html("密码不能为空");
            $("#repwd_msg").css("color", "red");
            return false;

        } else if (pwReg.test(pwd) == false) {
            alert("密码包含英文，数字和特殊符号中的两种");
            $("#epwd_msg").html("密码格式错误");
            $("#epwd_msg").css("color", "red");

            return false;
        } else {
            $("#epwd_msg").html("√");
            $("#epwd_msg").css("color", "green");
            return true;
        }

    });

//确认密码

    $("#reupwd").blur(function () {
        var pwd = $("#upwd").val();
        var repwd = $("#reupwd").val();
        if (null == repwd || "" == repwd) {
            $("#repwd_msg").html("不能为空");
            $("#repwd_msg").css("color", "red");
            return false;
        } else if (repwd == pwd) {
            $("#repwd_msg").html("密码一致");
            $("#repwd_msg").css("color", "green");
            return true;
        } else {
            $("#repwd_msg").html("密码不一致");
            $("#repwd_msg").css("color", "red");
            return false;
        }
    });


//电话
    $("#utel").blur(function () {
        var tel = $("#utel").val();
        var telReg = /^1[3456789]\d{9}$/;
        if (null == tel || "" == tel) {
            $("#etel_msg").html("手机号不能为空");
            return false;
        } else if (telReg.test(tel) == false) {
            alert("手机号码有误,必须为13开头，请重填");
            $("#etel_msg").html("电话号码有误");
            return false;
        } else {
            $("#etel_msg").html("√");
            return true;
        }
    });


    //邮箱
    $("#uemail").blur(function () {

        var email = $("#uemail").val();
        var reg = /^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/;
        if (reg.test(email) == false) {
            $("#email_msg").html("<font color='red'>电子邮件格式不正确，请重新输入</font>");
            return false;
        } else {
            $("#email_msg").html("<font color='green'>√</font>");
        }
        return true;
    });


});