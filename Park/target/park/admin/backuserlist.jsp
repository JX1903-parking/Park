<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <meta charset="UTF-8">.
    <title>文档审核</title>
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
    <script src="<%=path%>/admin/layui/layui.all.js"></script>
    <link rel="stylesheet" href="<%=path%>/admin/jqueryui/jquery-ui.css">
    <script src="<%=path%>/admin/jqueryui/jquery-ui.js"></script>
    <script>
        $(function() {
            $("#dialog").dialog({
                autoOpen : false,
                width : 350,
                height : 680,
                modal : true,
                draggable : false,
                resizable : false
            });
        });
    </script>
</head>

<body>
<input type="hidden" id="path" value="<%=path%>"/>
<div class="x-nav"><span class="layui-breadcrumb"> <a href="">首页</a> <a href="">演示</a> <a> <cite>导航元素</cite></a> </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       onclick="location.reload()" title="刷新"> <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
    </a></div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <%--                    <form class="layui-form layui-col-space5">--%>
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
                        <div class="layui-input-inline layui-show-xs-block">
                            <a class="layui-btn layui-btn-xs" onclick="openDialog('新增用户')">新增用户</a>
                        </div>
                        <%--                    </form>--%>
                    </div>
                    <div class="layui-card-body ">
                        <table class="layui-table" lay-filter="test" id="Usertable" align="center">
                        </table>
                        <div id="dialog" title="" class="layui-input-inline">
                            <form  id="myform">
                                <input type="hidden" id="title" name="title" value="123"/>
                                <div>用户ID：<input class="layui-input" type="text" name="userid" id="userid" readonly="" autocomplete="off"/></div><br/>
                                <div>用户名：<input class="layui-input" type="text" name="uname" id="uname" autocomplete="off"/></div><br/>
                                <div>密码：<input class="layui-input" type="text" name="upass" id="upass" autocomplete="off"/></div><br/>
                                <div>性别：<input type="radio" name="usex" value="男"/>男
                                    <input type="radio" name="usex" value="女"/>女
                                </div><br/>
                                <div>年龄：<input class="layui-input" type="text" name="uage" id="uage" autocomplete="off"/></div><br/>
                                <div>电话：<input class="layui-input" type="text" name="utel" id="utel" autocomplete="off"/></div><br/>
                                <div>邮箱：<input class="layui-input" type="text" name="uemail" id="uemail" autocomplete="off"/></div><br/>
                                <div>地址：<input class="layui-input" type="text" name="address" id="address" autocomplete="off"/></div><br/>
                                <input class="layui-btn" type="button" value="提交" onclick="manageBackUser()"/><p style="width: 150px; display: inline-block;"></p><input class="layui-btn" type="button" value="取消" onclick="closeDialog()"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script id="barDemo" type="text/html">
    {{#  if(d.param.paramname == '启用'){ }}
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="Prohibit">禁用</a>
    {{#  } }}
    {{#  if(d.param.paramname == '禁用'){ }}
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="Enable">启用</a>
    {{#  } }}
    <a class="layui-btn layui-btn-xs" lay-event="repassword">重置密码</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="deluser">删除用户</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="edituser">修改用户</a>
</script>

<script>
    layui.use('table', function () {
        var table = layui.table;

        table.render({
            elem: '#Usertable'
            , url: '${pageContext.request.contextPath}/user/findAllBackUser.action' //数据接口
            , page: true //开启分页
            ,limits:[3,5,10]
            ,limit: 5
            , id: 'userReload'
            , parseData: function (redata) {

                return {
                    "code": redata.code, //解析接口状态
                    "count": redata.count, //解析数据长度
                    "data": redata.data//解析数据列表
                };
            }
            , cols: [[ //表头
                {field: 'uname', title: '用户名', minWidth: 40}
                ,  {field: 'usex', title: '性别', minWidth: 40}
                , {field: 'uage', title: '年龄', minWidth: 40}
                , {field: 'regtime', title: '注册时间', minWidth: 180}
                ,{field: 'worktime', title: '工龄(年)', minWidth: 40}
                ,{field: 'utel', title: '电话', minWidth: 100}
                ,{field: 'paramname', title: '状态', minWidth: 20,templet: function(d){
                        return d.param.paramname
                    }
                }
                , {field: 'right', fixed: 'right', title: '操作', toolbar: '#barDemo', minWidth: 300}
            ]]
        });
        //触发查询按钮
        var $ = layui.$, active = {
            reload: function () {
                var username = $('#username');
                var starttime = $('#starttime');
                var endtime = $('#endtime');
                //执行重载
                table.reload('userReload', {
                    where: {
                        keyword: username.val(),
                        begintime: starttime.val(),
                        endtime: endtime.val(),
                    }
                }, 'data');
            }
        };

        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        })

        //监听行工具事件
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            if (obj.event === 'repassword') {
                layer.confirm('是否重置密码？', function (index) {
                    fal("${pageContext.request.contextPath}/user/updateBackUserParam.action", data.userid,123456);
                    layer.close(index);
                });
            } else if (obj.event === 'deluser') {
                layer.confirm('是否删除用户？', function (index) {
                    fal("${pageContext.request.contextPath}/user/updateBackUserParam.action", data.userid ,1);
                    layer.close(index);
                });

            } else if (obj.event === 'Enable') {
                layer.confirm('是否启用？', function (index) {
                    fal("${pageContext.request.contextPath}/user/updateBackUserParam.action", data.userid,5);
                    layer.close(index);
                    // $("#Enable").attr("disabled", "disabled"); //禁用"启用"按钮
                    // $("#Prohibit").removeAttr("disabled");      //启用"禁用"按钮
                });
            }else if (obj.event==='Prohibit'){
                layer.confirm('是否禁用？', function (index) {
                    fal("${pageContext.request.contextPath}/user/updateBackUserParam.action", data.userid,6);
                    layer.close(index);
                    // $("#Prohibit").attr("disabled", "disabled"); //禁用"禁用"按钮
                    // $("#Enable").removeAttr("disabled");      //启用"启用"按钮
                });
            }else if (obj.event==='edituser'){
                findBackUserById(data.userid);
            }
        });

        function fal(url, userid,paramid) {
            $.ajax({
                async: true,
                type: "post",
                url: url,
                dataType: "text",
                data: {"userid": userid,
                        "paramid":paramid},
                success: function (dat) {
                    if (dat == 1) {
                        layer.msg("修改成功");
                    } else {
                        layer.msg("修改失败");
                    }
                    //执行重载
                    table.reload('userReload', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                        , where: {
                            keyword: username.value,
                            begintime: starttime.value,
                            endtime: endtime.value,
                        }
                    }, 'data');
                },
                error: function (dat) {
                    layer.msg('服务器崩溃');
                }
            })

        }

    });
</script>


</html>
