<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
</head>
<body>
<div class="row">
    <div class="col-md-12">
        <div class="panel panel-default">
            <div class="tab-content">
                <div class="panel panel-default">
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="icon-home"></i> 首页</a></li>
                        <li><a href="#">用户管理</a></li>
                    </ol>
                    <div role="form" id="search_form_mytask" class="form-horizontal">
                        <div id="simpleSearchLabel">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">用户名</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="s_eusername"
                                           name="s_eusername" placeholder="用户名">
                                </div>
                                <button id="btn-search-user" class="btn btn-primary btn-sm"
                                        style="margin-left: 11%">
                                    <i class="icon-search"></i> 查询
                                </button>
                            </div>
                        </div>
                    </div>
                    <div id="batch-toolbar">
                        <shiro:hasAnyRoles name="admin,manager">
                            <button id="btn-search-add" class="btn btn-primary btn-sm">
                                <i class="icon-search"></i> 添加
                            </button>
                            <button id="btn-search-edit" class="btn btn-primary btn-sm">
                                <i class="icon-search"></i> 修改
                            </button>
                            <button id="btn-search-del" class="btn btn-danger btn-sm">
                                <i class="icon-search"></i> 删除
                            </button>
                        </shiro:hasAnyRoles>
                    </div>
                    <table id="queryUserTable"></table>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $('#queryUserTable').bootstrapTable(
            {
                classes: 'table table-hover',
                pagination: true,
                height: 450,
                sidePagination: 'server',
                dataType: 'json',
                striped: 'true',
                pageNumber: 1,
                pageSize: 10,
                pageList: [1, 10, 20],
                queryParamsType: '',//默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
                // 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
                showRefresh: true,
                toolbar: '#toolbar',
                showColumns: true,
                search: true,
                showToggle: 'true',
                showPaginationSwitch: 'true',
                uniqueId: 'id',
                clickToSelect: 'true',
                queryParams: function (params) {
                    params.username = $("#s_eusername").val();
                    return params;
                },
                method: 'POST',
                contentType: "application/x-www-form-urlencoded",
                url: '${contextPath}/manuser/queryuser',
                columns: [
                    {
                        radio: true
                    },
                    {
                        field: 'id',
                        title: 'ID',
                        sortable: true
                    },
                    {
                        field: 'username',
                        title: '用户名',
                        sortable: true
                    }, {
                        field: 'realname',
                        title: '用户真实姓名'
                    }, {
                        field: 'password',
                        title: '密码',
                        sortable: true
                    }, {
                        field: 'status',
                        title: '状态'

                    }, {
                        field: 'ipaddress',
                        title: 'ip地址'
                    }, {
                        field: 'ipaddress',
                        title: 'ip地址',
                        switchable: true
                    }],
            }
        );
    });

    $('#btn-search-user').on('click', function () {
        //var username = $("#username").val();
        $('#queryUserTable').bootstrapTable("refresh", {queryUserList: {pageNumber: 1}});
    });

    //添加
    $("#btn-search-add").click(function () {
        BootstrapDialog.show({
            id: 'typeDialog',
            title: '添加用户',
            message: $('<div></div>').load('${contextPath}/manuser/loadadduserpage')
        });
    });

    //删除
    $('#btn-search-del').on('click', function () {
        var rows = $('#queryUserTable').bootstrapTable('getSelections');
        if (rows.length == 0) {
            BootstrapDialog.alert({
                title: '警告',
                type: BootstrapDialog.TYPE_WARNING,   //增加类型
                message: '请选择一条数据'
            });
            return;
        }

        //确认
        BootstrapDialog.confirm({
            title: '确认',
            message: '你确定要删除?',
            btnCancelLabel:'取消',
            btnOKLabel:'确认',
            callback: function (result) {
                if (result) {
                    $.post("${contextPath}/manuser/delUser",
                        {
                            id: rows[0].id
                        }, function (data) {
                            BootstrapDialog.show({
                                title: '操作结果',
                                message: data.errorMsg,
                                buttons: [{
                                    label: '确认',
                                    cssClass: 'btn-primary',
                                    action: function (dialogItself) {
                                        dialogItself.close();
                                        loadPage('${contextPath}/manuser/queryuserpage');
                                    }
                                }]
                            });
                        });
                } else {
                    console.log("not delete!");
                }
            }
        });
    });

    //修改
    $("#btn-search-edit").on('click',function(){
        var rows = $('#queryUserTable').bootstrapTable('getSelections');
        if (rows.length == 0) {
//            BootstrapDialog.alert({
//                title: '警告',
//                buttonLabel:'确认',
//                type: BootstrapDialog.TYPE_WARNING,   //增加类型
//                message: '请选择一条数据'
//            });

            BootstrapDialog.warning('请选择一条数据');

            return;
        }
        BootstrapDialog.show({
            id:'fdialog',
            title: '修改信息',
            message: $('<div></div>').load('${contextPath}/manuser/edituser?id='+rows[0].id),
            buttons: [{
                label: '关闭',
                cssClass: 'btn-primary',
                action : function(dialogItself){
                    dialogItself.close();
                }
            }],
            data:{
                'id':rows[0].id,
                'username':rows[0].username
            }
        });



    });




</script>
</body>
</html>
