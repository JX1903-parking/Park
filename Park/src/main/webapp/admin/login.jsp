<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台登录-智能车牌识别停车管理</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/xadmin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/lib/layui/layui.js" charset="utf-8"></script>

</head>
<body class="login-bg">
<div class="login layui-anim layui-anim-up">
    <div class="message">智能车牌识别停车管理系统后台登录</div>
    <div id="darkbannerwrap"></div>
    <form class="layui-form" method="post">
        <input name="userid" id="userid" type="text" class="layui-input" required lay-verify="required"
               placeholder="请输入用户名">
        <hr class="hr15">
        <input name="upass" id="upass" type="password" class="layui-input" required lay-verify="required"
               placeholder="请输入密码">
        <hr class="hr15">
        <input name="securityCode" required lay-verify="required" placeholder="请输入验证码" type="text" autocomplete="off"
               style="width: 190px;">
        <img src="serial/getimage.action" οnclick="VerificationCode()" name="securityCode" id="Verify"
             style="cursor:hand;" alt="看不清，换一张" width="116"
             height="36">
        <hr class="15">
        <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
        <hr class="hr20">

    </form>
</div>

<script>


    /**
     * 登录验证
     * */
    function loginch() {
        var uname = $("#userid").val();
        var upwd = $("#upass").val();
        if (null == uname || "" == uname && null == upwd || "" == upwd) {
            return false;
        } else {
            return true;
        }
    };
    $(function () {


        /**
         * 用户名检测是否存在
         */

        $("#userid").blur(function () {
            var url = "${pageContext.request.contextPath}/login/CheckName.action";
            var id = $("#userid").val();
            var urldata = {userid: id};
            $.post(url, urldata, function (data) {
                //返回的JSON数据
                if ("userfail" === data.info) {
                    layer.msg("账号不存在");
                    $("#userid").text("");
                    $("#Verify").attr("src", "${pageContext.request.contextPath}/serial/getimage.action?timestamp=" + new Date().getTime());
                } else if ("Non-exist" === data.info) {
                    layer.msg("账号已注销，如有问题，请联系管理员");
                    $("#userid").text("");
                    $("#Verify").attr("src", "${pageContext.request.contextPath}/serial/getimage.action?timestamp=" + new Date().getTime());

                } else if ("Prohibit" === data.info) {
                    layer.msg("账号已禁用，请联系管理员");
                    $("#userid").text("");
                    $("#Verify").attr("src", "${pageContext.request.contextPath}/serial/getimage.action?timestamp=" + new Date().getTime());
                } else {
                    layer.msg("账号无误");
                }

            }, "json")
        });


        /**
         *验证码刷新
         */
        $(function () {
            //点击图片更换验证码
            $("#Verify").click(function () {
                $("#Verify").attr("src", "${pageContext.request.contextPath}/serial/getimage.action?timestamp=" + new Date().getTime());
            });
        });

        layui.use('form', function () {
            var form = layui.form;
            //监听提交
            form.on('submit(login)', function (data) {
                $.ajax({
                    async: true,
                    url: "${pageContext.request.contextPath}/login/adLogin.action",
                    type: "POST",
                    dataType: "text",
                    data: data.field,
                    success: function (redata) {

                        if ("adminsucc" == redata) {
                            layer.msg("登录成功");
                            window.location.href = "${pageContext.request.contextPath}/admin/index.jsp";
                        } else if ("tollsucc" == redata) {
                            layer.msg("登录成功");
                            window.location.href = "${pageContext.request.contextPath}/tollman/index.jsp";
                        } else if ("fail" == redata) {
                            layer.msg("登陆失败,用户名或密码错误");
                            <%--window.location.href = "${pageContext.request.contextPath}/admin/login.jsp";--%>
                            $("#Verify").attr("src", "${pageContext.request.contextPath}/serial/getimage.action?timestamp=" + new Date().getTime());

                        } else if ("codefail" == redata) {
                            layer.msg("验证码错误");
                            $("#Verify").attr("src", "${pageContext.request.contextPath}/serial/getimage.action?timestamp=" + new Date().getTime());

                        } else if ("Prohibit" == redata) {
                            layer.msg("账号已禁用，请联系管理员解冻");
                            $("#Verify").attr("src", "${pageContext.request.contextPath}/serial/getimage.action?timestamp=" + new Date().getTime());

                        } else {
                            layer.msg("账号无效，请先联系传一管理员");
                            <%--window.location.href = "${pageContext.request.contextPath}/admin/login.jsp";--%>
                            $("#Verify").attr("src", "${pageContext.request.contextPath}/serial/getimage.action?timestamp=" + new Date().getTime());

                        }
                    },
                    error: function () {

                        layer.msg("服务器崩溃，请求失败");
                    }
                })
                return false;
            })
        });
    });
</script>
</body>
</html>
