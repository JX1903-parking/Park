<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>智能车牌识别停车管理-收费端</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/tollman/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/tollman/css/login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/tollman/css/xadmin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/tollman/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/tollman/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/tollman/lib/layui/layui.js" charset="utf-8"></script>

</head>
<body class="login-bg">
<div class="login layui-anim layui-anim-up">
    <div class="message">智能车牌识别停车管理系统收费员登录</div>
    <div id="darkbannerwrap"></div>
    <form class="layui-form" method="post">
        <input name="userid" id="userid" placeholder="用户名" type="text" class="layui-input">
        <hr class="hr15">
        <input name="upass" id="upass" placeholder="密码" type="password" class="layui-input">
        <hr class="hr15">
        <input name="securityCode" placeholder="验证码" type="text" autocomplete="off" style="width: 190px;">
        <img src="../serial/getimage.action" id="Verify" style="cursor:hand;" alt="看不清，换一张" width="116"
             height="36">
        <hr class="15">
        <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">

        <%--        <a href="${pageContext.request.contextPath}/reception/index.jsp"> <input type="button" value="前台"--%>
        <%--                                                                                 style="width: 100%;margin-top: 10px;"></a>--%>
        <hr class="hr20">
    </form>
</div>

<script>

    $(function () {

        /**
         *验证码刷新
         */
        $(function () {
            //点击图片更换验证码
            $("#Verify").click(function () {
                $("#Verify").attr("src", "${pageContext.request.contextPath}/serial/getimage.action?timestamp=" + new Date().getTime());
            });
        });

        //ajax异步提交
        layui.use('form', function () {
            var form = layui.form;
            //监听提交
            form.on('submit(login)', function (data) {
                $.ajax({
                    async: true,
                    url: "${pageContext.request.contextPath}/login/tollmanLogin.action",
                    type: "POST",
                    dataType: "text",
                    data: data.field,
                    success: function (redata) {
                        layer.msg(redata);
                        if ("success" == redata) {
                            layer.msg("登录成功");
                            window.location.href = "${pageContext.request.contextPath}/tollman/index.jsp";
                        } else if ("fail" == redata) {
                            layer.msg("登陆失败");
                            window.location.href = "tollman/login.jsp";
                        } else if ("codefail" == redata) {
                            layer.msg("验证码错误");
                        } else if ("Prohibit" == redata) {
                            layer.msg("账号已禁用，请联系管理员解冻");
                        } else {
                            layer.msg("账号无效，请先联系传一管理员");
                            window.location.href = "tollman/login.jsp";
                        }
                    },
                    error: function () {
                        layer.msg("失服务器崩溃，请求败");
                    }
                })
                return false;
            })
        });
    });
</script>
</body>
</html>
