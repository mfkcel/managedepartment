<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
	<script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/bootstrap/js/jquery.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/manageequipment.css">
</head>
<%
	Object user = session.getAttribute("currentUser");
	if(user == null) {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}
	Object info = request.getAttribute("mainPage");
	String mainPage = null;
	if(info == null){
		mainPage = "./jsp/welcome.jsp";
	}
	else {
		mainPage = (String)info;
	}
%>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="navbar-inverse" id="pageheader">
					<span id="left">设备管理系统</span>
					<span id="right" class="col-md-offset-7">当前用户:&nbsp;<span>${currentUser.userName }</span></span>
				</div>
			</div>
		</div>
		<br/>
		<div class="row">
			<div class="col-md-2">
				<div class="list-group">
					<a class="list-group-item" href="${pageContext.request.contextPath}/system">系统菜单</a>
					<a class="list-group-item" href="${pageContext.request.contextPath}/department/list.do">部门管理</a>
					<a class="list-group-item" href="${pageContext.request.contextPath}/user">用户管理</a>
					<a class="list-group-item" href="${pageContext.request.contextPath}/equipment">设备类型管理</a>
					<a class="list-group-item" href="${pageContext.request.contextPath}/buy">采购管理</a>
					<a class="list-group-item" href="${pageContext.request.contextPath}/system/logout">安全退出</a>
				</div>
			</div>
			<div class="col-md-7">
				<div class="container">
					<div class="row">
						<ol class="breadcrumb">
						  <li><a href="#">主页</a></li>
						</ol>
					</div>
					<div class="row">
						<div class="content">
							<jsp:include page="<%=mainPage %>"></jsp:include>
						
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>