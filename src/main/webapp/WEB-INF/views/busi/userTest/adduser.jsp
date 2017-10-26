<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="tab-content">
					<div class="panel panel-default">
						<ol class="breadcrumb">
							<li><a href="#"><i class="icon-home"></i> 首页</a></li>
							<li><a href="#">任务管理</a></li>
							<li><a href="#"><i class="icon-globe"></i> 我的任务</a></li>
						</ol>
						<div role="form" id="search_form_mytask" class="form-horizontal">
							<div id="simpleSearchLabel">
								<div class="form-group">
									<label for="taskType" class="col-sm-2 control-label">任务类型</label>
									<div class="col-sm-3">
										<select class="form-control" id="taskType" name="taskType">
											<option value="">全部</option>
											<option value="01">生产网内数据下发</option>
											<option value="02">生产网内数据提交</option>
											<option value="03">生产数据外发</option>
											<option value="04">外部数据提交</option>
											<option value="05">代发工资数据提交</option>

										</select>
									</div>
									<label for="taskSummary" class="col-sm-2 control-label">任务概述</label>

									<div class="col-sm-3">
										<input type="text" class="form-control" id="taskSummary"
											name="taskSummary" placeholder="输入任务概述">
									</div>
								</div>

								<div class="form-group">
									<label for="taskStatus" class="col-sm-2 control-label">任务状态</label>

									<div class="col-sm-3">
										<select class="form-control" id="taskStatus" name="taskStatus">
											<option value="">--请选择--</option>
											<option value="1">待提交</option>
											<option value="2">待复核</option>
											<option value="3">待使用</option>
											<option value="4">待销毁</option>

										</select>
									</div>
									<label for="taskNum" class="col-sm-2 control-label">任务编号</label>

									<div class="col-sm-3">
										<input type="text" class="form-control" id="taskNum"
											name="taskNum" placeholder="输入任务编号">
									</div>
								</div>
							</div>
							<div id="advancedSearchLabel" hidden>
								<div class="form-group">
									<label for="approvalSys" class="col-sm-2 control-label">审批系统</label>

									<div class="col-sm-3">
										<input type="text" class="form-control" id="approvalSys"
											name="approvalSys" placeholder="输入审批系统">
									</div>

									<label for="approvalNum" class="col-sm-2 control-label">审批单号</label>

									<div class="col-sm-3">
										<input type="text" class="form-control" id="approvalNum"
											name="approvalNum" placeholder="输入审批单号">
									</div>


								</div>
								<div class="form-group">
									<label for="taskTheme" class="col-sm-2 control-label">任务主题</label>

									<div class="col-sm-3">
										<input type="text" class="form-control" id="taskTheme"
											name="taskTheme" placeholder="输入任务主题">
									</div>
									 <label for="taskAcceptance"
										class="col-sm-2 control-label">任务接收员</label>

									<div class="col-sm-3">
										<input type="text" class="form-control" id="taskAcceptance"
											name="taskAcceptance" placeholder="输入任务接收员">
									</div>
								</div>
								
							</div>
							<div class="form-group">

								<label class="col-sm-2 control-label"></label>

								<div class="col-sm-5">
									<button id="btn-search-mytask" class="btn btn-danger"
										style="margin-left: 11%">
										<i class="icon-search"></i> 查询
									</button>
									<button id="btn-clear-mytask" class="btn btn-primary">
										<i class="icon-reply"></i> 重置
									</button>
									<button id="btn-create-mytask" class="btn btn-primary"
										style="margin-right: 11%">
										<i class="icon-file"></i> 创建任务
									</button>
								</div>
							</div>
						</div>
					</div>
					
					<div id="batch-toolbar">
						<button id="btn_add" class="btn btn-danger" data-toggle="modal"
							data-target="#myModal">
						<i class="icon-plus"></i> 新增
					</button>
					</div>
					<div role="tabpanel" class="tab-pane active" id="term">
						<ul class="nav nav-tabs" role="tablist">
							<li role="tabpanel" class="active"><a href="#det"
								aria-controls="det" role="tab" data-toggle="tab"><i
									class="icon-film"></i> 详细列表</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 增加信息页面 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">新增</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="txt_departmentname">部门名称</label> <input type="text"
							name="txt_departmentname" class="form-control"
							id="txt_departmentname" placeholder="部门名称">
					</div>
					<div class="form-group">
						<label for="txt_parentdepartment">上级部门</label> <input type="text"
							name="txt_parentdepartment" class="form-control"
							id="txt_parentdepartment" placeholder="上级部门">
					</div>
					<div class="form-group">
						<label for="txt_statu">描述</label> <input type="text"
							name="txt_statu" class="form-control" id="txt_statu"
							placeholder="状态">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭
					</button>
					<button type="button" id="btn_submit" class="btn btn-primary"
						data-dismiss="modal">
						<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>保存
					</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
    seajs.use(["datepicker", 'jquery', 'table', 'select', 'dialog', 'cbjup'], function ( $, $ , $, $, dialog, cbjup) {
        //查询
        $('#btn-search-mytask').on('click', function () {
            $('#term-grid-mytask').bootstrapTable("refresh", {mytaskQuery: {pageNumber: 1}});
        });
        //创建任务
        $('#btn-create-mytask').on('click', function () {
        	BootstrapDialog.alert('I want banana!');
            dialog.show({
                id: 'myModal',
                title: '请选择任务类型'
            });
        });
        //重置
        $('#btn-clear-mytask').on('click', function () {
            $("#taskType").val("");
            $("#approvalNum").val("");
            $("#approvalSys").val("");
            $("#taskSummary").val("");
            $("#taskTheme").val("");
            $("#taskAcceptance").val("");
            $("#taskStatus").val("");
            $("#taskNum").val("");
        });

        $('#term-grid-mytask').bootstrapTable({
            queryParams: function (params) {
                params.taskType = $("#taskType").val();
                params.taskSummary = $("#taskSummary").val();
                params.taskStatus = $("#taskStatus").val();
                params.approvalSys = $("#approvalSys").val();
                params.approvalNum = $("#approvalNum").val();
                params.taskTheme = $("#taskTheme").val();
                params.taskAcceptance = $("#taskAcceptance").val();
                params.taskValidStartTmStart = $('#taskValidStartTmStart').val();
                params.taskValidStartTmEnd = $('#taskValidStartTmEnd').val();
                params.taskValidEndTmStart = $('#taskValidEndTmStart').val();
                params.taskValidEndTmEnd = $('#taskValidEndTmEnd').val();
                params.taskNum = $("#taskNum").val();
                return params;
            }
        });
    });
    
  //注册新增按钮的事件
  $("#btn_add").click(function () {  
	  $("#myModalLabel").text("新增"); 
	  $('#myModal').modal(); 
	  });
    function responseHandler(res) {
        seajs.use(['jquery'], function ($) {
            //$("th:eq(10)", $("tr")).hide();
            $("input[value='10']").attr("hidden", "hidden");
            if ($("input[value='10']").attr("flag") == 1) {

            } else {
                $("input[value='10']").click();
                $("input[value='10']").attr("flag", "1");
            }

        });
        return res;
    }

</script>
