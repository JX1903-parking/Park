<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>车辆出场收费</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <script src="${pageContext.request.contextPath}/tollman/js/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/tollman/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/tollman/css/xadmin.css">
    <script src="${pageContext.request.contextPath}/tollman/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/tollman/js/xadmin.js"></script>

</head>

<body>
<div class="layui-upload">
    <button type="button" class="layui-btn" id="test2">
        <i class="layui-icon">&#xe67c;</i>车辆出场
    </button>
    <div class="layui-upload-list">
        <img class="layui-upload-img" id="demo2">
        <p id="demoText"></p>
    </div>
</div>
<script src="/static/build/layui.js"></script>
<script>
    layui.use('upload', function(){
        var upload = layui.upload;

        //执行实例
        var uploadInst = upload.render({
            elem: '#test2' //绑定元素
            ,url: '${pageContext.request.contextPath}/file/upImg.action' //上传接口
            ,dataType:'json'
            ,method: 'post'
            // ,accept:'images'
            // ,acceptMime: 'image/jpg, image/png'//只显示 jpg 和 png 文件
            ,auto:true
            ,done: function(res){
                if(res.code==1){
                    layer.msg("文件上传失败");
                }else{
                    layer.msg(res.mag);
                    //上传完毕回调
                }
            }
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#demo2').attr('src', result); //图片链接（base64）
                });
            }
            ,error: function(){
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
                    <input class="layui-input" style="width: 181%;"  type="text" autocomplete="off" disabled/>
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
                    <input class="layui-input" style="width: 181%;" type="text" autocomplete="off" />
                    <a class="layui-btn">缴费</a>
                </div>

            </div>
        </div>
    </div>

</div>
</body>
</html>
