<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div class="col-md-3 left_col">
    <div class="left_col scroll-view">
        <div class="navbar nav_title" style="border: 0;">
            <a href="${contextPath}/admin/index" class="site_title"><i class="fa fa-paw"></i>
                <span>Welcome to here!</span></a>
        </div>
        <!-- sidebar menu -->
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                    <li><a><i class="fa fa-home"></i> 用户管理 <span
                            class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <shiro:hasAnyRoles name="admin,manager">
                                <li><a style="cursor: pointer"
                                       onclick="loadPage('${contextPath}/manuser/loadadduserpage');">
                                    添加用户
                                </a></li>
                            </shiro:hasAnyRoles>
                            <li><a style="cursor: pointer" onclick="loadPage('${contextPath}/manuser/queryuserpage');">
                                用户查询
                            </a></li>
                            <shiro:hasAnyRoles name="admin,manager">
                                <li><a style="cursor: pointer"
                                       onclick="loadPage('${contextPath}/management/queryrolepage');">
                                    角色维护
                                </a></li>
                            </shiro:hasAnyRoles>
                            <li><a style="cursor: pointer" onclick="loadPage('${contextPath}/manuser/loadupload');">
                                文件上传
                            </a></li>
                        </ul>
                    </li>
                    <shiro:hasAnyRoles name="admin,manager">
                    <li><a><i class="fa fa-edit"></i> 系统管理 <span
                            class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a style="cursor: pointer" onclick="loadPage('${contextPath}/operationlogpage');">
                                系统操作日志查询
                            </a></li>
                            <li><a style="cursor: pointer" onclick="loadPage('${contextPath}/log');">
                                系统操作日志测试查询
                            </a></li>
                        </ul>
                    </li>
                    </shiro:hasAnyRoles>
                    <li><a><i class="fa fa-edit"></i> Forms <span
                            class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="form.html">General Form</a></li>
                            <li><a href="form_advanced.html">Advanced Components</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <!-- /sidebar menu -->

        <!-- /menu footer buttons -->
        <div class="sidebar-footer hidden-small">
            <a data-toggle="tooltip" data-placement="top" title="Settings"> <span
                    class="glyphicon glyphicon-cog" aria-hidden="true"></span>
            </a> <a data-toggle="tooltip" data-placement="top" title="FullScreen">
            <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
        </a> <a data-toggle="tooltip" data-placement="top" title="Lock"> <span
                class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
        </a> <a href="${contextPath}/logout" data-toggle="tooltip" data-placement="top" title="Logout"> <span
                class="glyphicon glyphicon-off" aria-hidden="true"></span>
        </a>
        </div>
        <!-- /menu footer buttons -->
    </div>
</div>
