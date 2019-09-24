<%--
  Created by IntelliJ IDEA.
  User: ony
  Date: 2019/9/20
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>车牌识别-智能车牌识别停车管理</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/layui/layui.js" charset="utf-8"></script>

</head>
<body>
<div class="layui-upload">
    <button type="button" class="layui-btn" id="test1">
        <i class="layui-icon">&#xe67c;</i>车辆入场
    </button>
    <div class="layui-upload-list">
        <img class="layui-upload-img" id="demo1">
        <p id="demoText"></p>
    </div>
</div>
<script src="/static/build/layui.js"></script>
<script>
    layui.use('upload', function () {
        var upload = layui.upload;

        //执行实例
        var uploadInst = upload.render({
            elem: '#test1' //绑定元素
            , url: '${pageContext.request.contextPath}/file/upImg.action' //上传接口
            , dataType: 'json'
            , method: 'post'
            // ,accept:'images'
            // ,acceptMime: 'image/jpg, image/png'//只显示 jpg 和 png 文件
            , auto: true
            , done: function (res) {
                if (res.code == 1) {
                    layer.msg("文件上传失败");
                } else {
                    layer.msg(res.mag);
                    //上传完毕回调
                }
            }
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            }
            , error: function () {
                //请求异常回调
            }
        });
    });
</script>
<div class="layui-input-block">
    <div class="layui-row">
        <div class="layui-col-md6" style="width: 106px;">
            <div class="layui-container">
                <strong>车牌号：</strong>
            </div>
        </div>
        <div class="layui-col-md6" style="width: 3%;">
            <div class="layui-container" style="width: 101px;">
                <input class="layui-input" style="width: 181%;" type="text" autocomplete="off" disabled/>
            </div>
        </div>
    </div>
</div>
<div class="layui-input-block">
    <div class="layui-row">
        <div class="layui-col-md6" style="width: 106px;">
            <div class="layui-container">
                <strong>入场时间：</strong>
            </div>
        </div>
        <div class="layui-col-md6" style="width: 3%;">
            <div class="layui-container" style="width: 101px;">
                <input class="layui-input" style="width: 181%;" type="text" autocomplete="off" disabled/>
            </div>
        </div>
    </div>
</div>
<div class="layui-input-block">
    <div class="layui-row">
        <div class="layui-col-md6" style="width: 106px;">
            <div class="layui-container">
                <strong>出场时间：</strong>
            </div>
        </div>
        <div class="layui-col-md6" style="width: 3%;">
            <div class="layui-container" style="width: 101px;">
                <input class="layui-input" style="width: 181%;" type="text" autocomplete="off" disabled/>
            </div>
        </div>
    </div>
</div>
<div class="layui-input-block">
    <div class="layui-row">
        <div class="layui-col-md6" style="width: 106px;">
            <div class="layui-container">
                <strong>停车时长：</strong>
            </div>
        </div>
        <div class="layui-col-md6" style="width: 3%;">
            <div class="layui-container" style="width: 101px;">
                <input class="layui-input" style="width: 181%;" type="text" autocomplete="off" disabled/>
            </div>
        </div>
    </div>
</div>
<div class="layui-input-block">
    <div class="layui-row">
        <div class="layui-col-md6" style="width: 106px;">
            <div class="layui-container">
                <strong>应收费用：</strong>
            </div>
        </div>
        <div class="layui-col-md6" style="width: 3%;">
            <div class="layui-container" style="width: 101px;">
                <input class="layui-input" style="width: 181%;" type="text" autocomplete="off" disabled/>
            </div>
        </div>
    </div>
</div>
<div class="layui-input-block">
    <div class="layui-row">
        <div class="layui-col-md6" style="width: 106px;">
            <div class="layui-container">
                <strong>请输入金额：</strong>
            </div>
        </div>
        <div class="layui-col-md6" style="width: 3%;">
            <div class="layui-container" style="width: 101px;">
                <input class="layui-input" style="width: 181%;" type="text" autocomplete="off"/>
                <a class="layui-btn">缴费</a>
            </div>

        </div>
    </div>
</div>
</div>
</body>
</html>