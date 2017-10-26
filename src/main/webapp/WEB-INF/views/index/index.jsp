<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <title>首页</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>

<body>
<a href="#" style="cursor: pointer"
   onclick="loadPage('${contextPath}/mytest/test/hello');">我的权限测试</a>
<a href="#" style="cursor: pointer"
   onclick="loadPage('${contextPath}/mytest/hello');">你好</a>
<a href="#" style="cursor: pointer"
   onclick="loadPage('${contextPath}/admin/adduser');">添加用户</a>
<a href="#" style="cursor: pointer"
   onclick="BootstrapDialog.alert( {title: '提示框',message: 'waring!'});">对话框1</a>

<a href="#" style="cursor: pointer" onclick="showDiv();">加载form表单</a>
<shiro:hasPermission name="admin">
    超级用户角色
</shiro:hasPermission>
<shiro:hasRole name="manager">
    管理员角色
</shiro:hasRole>
<div>
    <h1>开关按钮DEMO</h1>
    <label>添加bootstrap-switch.min.min.js 和 bootstrap-switch.min.css</label><br>
    <input type="checkbox" id="my-checkbox" name="my-checkbox" checked/>
</div>

<div>

    <br/>
    <div class="btn-group" data-toggle="buttons">
        <label class="btn btn-primary">
            <input type="checkbox"> 选项 1
        </label>
        <label class="btn btn-primary">
            <input type="checkbox"> 选项 2
        </label>
        <label class="btn btn-primary">
            <input type="checkbox"> 选项 3
        </label>
    </div>
</div>


<div>
    <h1>bootstrap table 演示</h1>
    <div id="transform-buttons" class="btn-group btn-default">
        <button class="btn btn-default" id="transform">
            <i class="glyphicon glyphicon-transfer"></i>
            <span data-zh="转换"  data-es="Transformar">Transform</span>
        </button>
        <button class="btn btn-default" id="destroy">
            <i class="glyphicon glyphicon-trash"></i>
            <span data-zh="摧毁" data-es="Destruir">Destroy</span>
        </button>
    </div>
    <table id="table-transform" data-toolbar="#transform-buttons">
        <thead>
        <tr>
            <th>Item ID</th>
            <th>Item Name</th>
            <th>Item Price</th>
            <th switchable="false">开启或关闭</th>
        </tr>
        </thead>
        <tbody>
        <tr id="tr_id_1" class="tr-class-1">
            <td id="td_id_1" class="td-class-1">1</td>
            <td>Item 1</td>
            <td>$1</td>
            <td>true</td>
        </tr>
        <tr id="tr_id_2" class="tr-class-2">
            <td id="td_id_2" class="td-class-2">2</td>
            <td>Item 2</td>
            <td>$2</td>
            <td>true</td>
        </tr>
        <tr id="tr_id_3" class="tr-class-3">
            <td id="td_id_3" class="td-class-3">3</td>
            <td>Item 3</td>
            <td>$3</td>
            <td>false</td>
        </tr>
        </tbody>
    </table>
</div>

<div class="x_content" id="formdiv">
    <br/>
    <form id="editUserForm" data-parsley-validate
          class="form-horizontal form-label-left">
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">用户账号 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="text" id="username" name="username"  readonly="readonly"
                       class="form-control col-md-7 col-xs-12">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">用户真实姓名 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="text" id="realname" name="realname"
                       class="form-control col-md-7 col-xs-12">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">密码 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <input type="password" id="password" name="password"  readonly="readonly"
                       class="form-control col-md-7 col-xs-12">
            </div>
        </div>

        <div class="ln_solid"></div>
        <div class="form-group">
            <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                <button type="button" id="addbtn" class="btn btn-success">修改</button>
            </div>
        </div>
    </form>
</div>
<script>

    $(document).ready(function () {
        //初始化开关按钮demo
        $("#my-checkbox").bootstrapSwitch({
            onText: "启动",
            offText: "停止",
            onColor: "success",
            offColor: "info",
            //size:"small",
            onSwitchChange: function (event, state) {
                if (state == true) {
                    $(this).val("1");
                    alert(1);
                } else {
                    $(this).val("2");
                    alert(2);
                }
            }
        });

        function showDiv() {
            BootstrapDialog.show({
                id: 'typeDialog',
                title: '添加用户',
                //message: $('<div></div>').load('${contextPath}/manuser/loadadduserpage')
                message: $('<div></div>').load($("#formdiv"))
            });
        }
    })


</script>
</body>
</html>
