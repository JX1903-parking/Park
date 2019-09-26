<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <%String path = request.getContextPath();%>
    <title>智能车牌识别停车管理</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/xadmin.css">
    <!-- <link rel="stylesheet" href="./css/theme5.css"> -->
    <script src="${pageContext.request.contextPath}/admin/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script>
        function getSysTime() {
            var myDate = new Date();
            var year = myDate.getFullYear(); //年
            var month = myDate.getMonth(); //月
            var day = myDate.getDate(); //日
            var hour = myDate.getHours(); //时
            var m = myDate.getMinutes(); //分
            var s = myDate.getSeconds(); //秒
            var datestr = year + "年" + (month + 1) + "月" + day + "日&nbsp;&nbsp;" + hour + ":" + m + ":" + s;
            $("#SystemDate").html(datestr);

        }

        function changeTime() {

            setInterval(getSysTime, 1000);
        }

        // 是否开启刷新记忆tab功能
        // var is_remember = false;
        window.onload = changeTime();
    </script>
</head>
<body class="index">
<!-- 顶部开始 -->
<div class="container">
    <div class="logo"><a href="./index.html">江湖驿站后台管理界面</a></div>
    <div class="left_open"><a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a></div>
    <ul class="layui-nav left fast-add" lay-filter="">
        <li id="SystemDate" style="margin-top: 15px;width: 350px">系统时间</li>
    </ul>
    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item"><a href="javascript:;">
            ${sessionScope.backUser.uname} </a>
            <dl class="layui-nav-child">
                <!-- 二级菜单 -->
                <dd><a onclick="xadmin.open('个人信息','javascrtpt:;')">个人信息</a></dd>
                <%--                <dd><a onclick="xadmin.open('切换帐号','javascrtpt:;')">切换帐号</a></dd>--%>
                <dd><a href="#">退出</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item to-index"><a href="/">前台首页</a></li>
    </ul>
</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->
<!-- 左侧菜单开始 -->
<div class="left-nav">
    <div id="side-nav">
        <ul id="nav">
            <li><a href="javascript:;"> <i class="iconfont left-nav-li" lay-tips="用户管理">&#xe6b8;</i> <cite>会员管理</cite>
                <i class="iconfont nav_right">&#xe697;</i></a>
                <ul class="sub-menu">
                    <li><a onclick="xadmin.add_tab('前台用户管理','../admin/UserList.jsp',true)"> <i
                            class="iconfont">&#xe6a7;</i>
                        <cite>前台用户管理</cite></a></li>
                    <li><a onclick="xadmin.add_tab('后台用户管理','../admin/backuserlist.jsp',true)"> <i
                            class="iconfont">&#xe6a7;</i>
                        <cite>后台用户管理</cite></a></li>
                </ul>
            </li>
            <li><a href="javascript:;"> <i class="iconfont left-nav-li" lay-tips="菜单管理">&#xe723;</i> <cite>菜单管理</cite>
                <i class="iconfont nav_right">&#xe697;</i></a>
                <ul class="sub-menu">
                    <li><a onclick="xadmin.add_tab('增加菜单','jsp路径',true)"> <i class="iconfont">&#xe6a7;</i>
                        <cite>增加菜单</cite></a></li>
                    <li><a onclick="xadmin.add_tab('修改菜单','jsp路径',true)"> <i class="iconfont">&#xe6a7;</i>
                        <cite>修改菜单</cite></a>
                    </li>
                </ul>
            </li>
            <li><a href="javascript:;"> <i class="iconfont left-nav-li" lay-tips="日志管理">&#xe723;</i> <cite>日志管理</cite>
                <i class="iconfont nav_right">&#xe697;</i></a>
                <ul class="sub-menu">
                    <li><a onclick="xadmin.add_tab('日志列表','../admin/LogList.jsp',true)"> <i
                            class="iconfont">&#xe6a7;</i>
                        <cite>日志列表</cite></a></li>
                </ul>
            </li>
            <li><a href="javascript:;"> <i class="iconfont left-nav-li" lay-tips="角色管理">&#xe723;</i> <cite>角色管理</cite>
                <i class="iconfont nav_right">&#xe697;</i></a>
                <ul class="sub-menu">
                    <li><a onclick="xadmin.add_tab('角色列表','#',true)"> <i class="iconfont">&#xe6a7;</i>
                        <cite>角色列表</cite></a></li>
                </ul>
            </li>

            <li><a href="javascript:;"> <i class="iconfont left-nav-li" lay-tips="系统配置">&#xe723;</i> <cite>系统配置</cite>
                <i class="iconfont nav_right">&#xe697;</i></a>
                <ul class="sub-menu">
                    <li><a onclick="xadmin.add_tab('参数配置','#',true)"> <i
                            class="iconfont">&#xe6a7;</i>
                        <cite>参数配置</cite></a></li>
                    <li><a onclick="xadmin.add_tab('权限配置','#',true)"> <i
                            class="iconfont">&#xe6a7;</i> <cite>权限配置</cite></a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>
<!-- <div class="x-slide_left"></div> -->
<!-- 左侧菜单结束 -->
<!-- 右侧主体开始 -->
<div class="page-content">
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
        <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
        </ul>
        <div class="layui-unselect layui-form-select layui-form-selected" id="tab_right">
            <dl>
                <dd data-type="this">关闭当前</dd>
                <dd data-type="other">关闭其它</dd>
                <dd data-type="all">关闭全部</dd>
            </dl>
        </div>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src="../admin/welcome.jsp" frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
        </div>
        <div id="tab_show"></div>
    </div>
</div>
<div class="page-content-bg"></div>
<style id="theme_style">
</style>

</body>
</html>
