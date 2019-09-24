//查找单个用户的信息
function findBackUserById(userid) {
    openDialog("修改用户");
    var path=$("#path").val();
    $.ajax({
        async : true,
        url : path+"/user/findBackUserById.action",
        type : "POST",
        data : {"userid":userid},
        dataType : "json",
        success : function (redata) {
            $("#userid").val(redata.userid);
            $('#userid').attr('readOnly','readonly');
            $("#uname").val(redata.uname);
            $("#upass").val(redata.upass);
            $("input[type=radio][name='usex'][value="+redata.usex+"]").prop('checked','checked');
            $("#uage").val(redata.uage);
            $("#address").val(redata.address);
            $("#utel").val(redata.utel);
            $("#uemail").val(redata.uemail);
        },
        error : function() {
            alert("加载失败");
        }
    })
}
//dialog打开
function openDialog(title) {
    $("#top").text(title);
    $("#title").val(title);
    $('#userid').removeAttr('readOnly');
    $("#userid").val("");
    $("#uname").val("");
    $("#upass").val("");
    $("input[type=radio][name='usex'][value='男']").prop('checked','checked');
    $("#uage").val("");
    $("#utel").val("");
    $("#uemail").val("");
    $("#address").val("");
    $('#dialog').dialog("option","title", title).dialog('open');
}

//关闭
function closeDialog() {
    $('#dialog').dialog('close');
}

//增加修改通用
function manageBackUser() {
    var title=$('#dialog').dialog("option","title");
    alert(title);
    var form=$("#myform");
    var path=$("#path").val();
    $.ajax({
        async : true,
        url : path+"/user/freshBackUser.action",
        type : "POST",
        data : form.serialize(),
        dataType : "text",
        success : function (redata) {
            if(redata=="1")
            {
                alert(title+"成功");
                location.href=path+"/admin/backuserlist.jsp";
            }else{
                alert(title+"失败");
            }
            dclose();
        },
        error : function() {
            alert("加载失败");
        }
    })
}

function findUserById(userid) {
    openDialog("修改用户");
    var path=$("#path").val();
    $.ajax({
        async : true,
        url : path+"/user/findUserById.action",
        type : "POST",
        data : {"userid":userid},
        dataType : "json",
        success : function (redata) {
            $("#userid").val(redata.userid);
            $('#userid').attr('readOnly','readonly');
            $("#uname").val(redata.uname);
            $("#upass").val(redata.upass);
            $("input[type=radio][name='usex'][value="+redata.usex+"]").prop('checked','checked');
            $("#uage").val(redata.uage);
            $("#address").val(redata.address);
            $("#utel").val(redata.utel);
            $("#uemail").val(redata.uemail);
        },
        error : function() {
            alert("加载失败");
        }
    })
}

function manageUser() {
    var title = $('#dialog').dialog("option", "title");
    alert(title);
    var form = $("#myform");
    var path = $("#path").val();
    $.ajax({
        async: true,
        url: path + "/user/updateUser.action",
        type: "POST",
        data: form.serialize(),
        dataType: "text",
        success: function (redata) {
            if (redata == "1") {
                alert(title + "成功");
                location.href = path + "/admin/UserList.jsp";
            } else {
                alert(title + "失败");
            }
            dclose();
        },
        error: function () {
            alert("加载失败");
        }
    })
}