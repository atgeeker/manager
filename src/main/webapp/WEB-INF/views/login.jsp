<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html class="bg-img">
<head>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">

    <title>测试管理系统</title>
    <!-- bootstrap 3.0.2 -->
    <link href="${contextPath}/static/css/login/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <!-- font Awesome -->
    <link href="${contextPath}/static/css/login/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <!-- Theme style -->
    <link href="${contextPath}/static/css/login/AdminLTE.css" rel="stylesheet" type="text/css"/>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="/managersys/static/js/html5shiv.js"></script>
    <script src="/managersys/static/js/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery 2.0.2 -->
    <script src="${contextPath}/static/js/login/jquery.min.js"></script>
    <script src="${contextPath}/static/js/jquery.validate.min.js" type="text/javascript"></script>
    <script src="${contextPath}/static/js/messages_zh.min.js" type="text/javascript"></script>

    <!-- validate 插件错误提示颜色 -->
    <style type="text/css">
        .error {
            color: red;
        }
    </style>

</head>
<body class="bg-img">
<div class="form-box" id="login-box">
    <div class="header">用户登录</div>
    <form id="loginForm" name="login" action="login" method="POST" onsubmit="return loginSubmit();">
        <div class="body bg-gray">
            <div class="form-group">
                <input type="text" id="username" name="username" class="form-control" placeholder="User ID"/>
            </div>
            <div class="form-group">
                <input type="password" id="password" name="password" class="form-control" placeholder="Password"/>
            </div>
            <c:if test="${loginError !=null }">
                <label id="loginError" style="color:red">
                        ${loginError}
                </label>
            </c:if>
            <div class="form-group">
                <input type="checkbox" id="rememberMe" name="rememberMe"/> 记住我
            </div>
        </div>
        <div class="footer">
            <button type="submit" class="btn bg-olive btn-block">登 录</button>
            <p><a href="#">忘记密码</a></p>
            <!-- <a href="register.html" class="text-center">Register a new membership</a> -->
        </div>
    </form>
</div>
</body>
<script type="text/javascript">
    $().ready(function () {
        $("#loginForm").validate({
            rules: {
                username: {
                    required: true,
                    minlength: 4
                },
                password: {
                    required: true,
                    minlength: 6
                }
            },
            messages: {
                username: {
                    required: "请输入用户名",
                    minlength: "至少4个字符"
                },
                password: {
                    required: "请输入密码",
                    minlength: "至少6个字符"
                }
            }
        })
    });

    //登录表单提交
    function loginSubmit() {
        return $("#loginForm").validate().form();
    }
</script>
</html>