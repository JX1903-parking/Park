$(function () {

    $("#adname").blur(function () {
        var uname = $("#adname").val();
        if (null == uname || "" == uname) {
            alert("用户名不能为空");
            return false;
        }
        return true;
    });

    $("#adpwd").blur(function () {
        var upwd = $("#adpwd").val();
        if (null == upwd || "" == upwd) {
            alert("密码不能为空");
            return false;
        }
        return true;
    });



});