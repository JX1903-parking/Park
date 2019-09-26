<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>前台用户管理</title>
    <%String path = request.getContextPath();%>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/xadmin.css">
    <script src="${pageContext.request.contextPath}/admin/js/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/admin/js/myfunction.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/admin/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/xadmin.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/jqueryui/jquery-ui.css">
    <script src="${pageContext.request.contextPath}/admin/jqueryui/jquery-ui.js"></script>

</head>

<body>
<input type="hidden" name="path" id="path" value="<%=path%>"/>
<div class="x-nav"><span class="layui-breadcrumb"> <a href="">首页</a> <a href="">演示</a> <a> <cite>导航元素</cite></a> </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       onclick="location.reload()" title="刷新"> <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
    </a></div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <div class="demoTable">

                        <div class="layui-inline layui-show-xs-block">
                            <input type="date" class="layui-input" autocomplete="off" placeholder="开始日" name="starttime"
                                   id="starttime">
                        </div>
                        <div class="layui-input-inline layui-show-xs-block">
                            <input type="date" class="layui-input" autocomplete="off" placeholder="截止日" name="endtime"
                                   id="endtime">
                        </div>
                        <div class="layui-input-inline layui-show-xs-block">
                            <input type="text" name="username" placeholder="请输入用户名" autocomplete="off" id="username"
                                   class="layui-input">
                        </div>

                        <div class="layui-input-inline layui-show-xs-block">

                           <span> <button class="layui-btn" data-type="reload"><i
                                   class="layui-icon">&#xe615;</i></button></span>

                        </div>
                    </div>
                    <div class="layui-card-body ">
                        <table class="layui-table" lay-filter="test" id="Logtable" align="center"></table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>



<script>
    //ajax提交数据
    layui.use('table', function () {
        var table = layui.table;

        table.render({
            elem: '#Logtable'
            , url: '${pageContext.request.contextPath}/log/findByLog.action' //数据接口
            , page: true //开启分页
            , limit: 10
            , limits: [10, 15, 20]
            , id: 'LogReload'
            , parseData: function (res) {

                return {
                    "code": eval(res.code), //解析接口状态
                    "count": res.count, //解析数据长度
                    "data": res.data//解析数据列表
                };
            }
            , cols: [[ //表头
                {field: 'uname', title: '操作人', minWidth: 50}
                , {field: 'module', title: '模块', minWidth: 50}
                , {field: 'incident', title: '方法', minWidth: 40}
                , {field: 'description', title: '方法描述', minWidth: 80}
                , {field: 'ip', title: 'ip地址', minWidth: 80}
                , {field: 'acttime', title: '操作时间', minWidth: 80}
                , {field: 'rsponseDate', title: '响应时间', minWidth: 40}

            ]]
        });
        //触发查询按钮
        var $ = layui.$, active = {
            reload: function () {
                var username = $('#username');
                var starttime = $('#starttime');
                var endtime = $('#endtime');
                //执行重载
                table.reload('LogReload', {
                    where: {
                        username: username.val(),
                        starttime: starttime.val(),
                        endtime: endtime.val(),
                    }
                }, 'data');
            }
        };

        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        })



    });
</script>
</html>
