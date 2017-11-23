<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
<script
	src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath }/bootstrap/js/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/manageequipment.css">
</head>
<body>
	<div class="container">
		<div class="loginwrap">
			<div class="col-md-4 col-md-offset-5" id="login">
				<div>
					<form action="${pageContext.request.contextPath }/user/login.do" method="post">
						<table>
							<tr>
								<td>用户名:&nbsp;&nbsp;</td>
								<td><input name="userName" type="text" value="${user.userName }"/></td>
							</tr>
							<tr>
								<td colspan="2"><br /></td>
							</tr>
							<tr>
								<td>密&nbsp;码&nbsp;&nbsp;&nbsp;</td>
								<td><input type="password" name="password" value="${user.password }"/></td>
							</tr>
							<tr>
								<td colspan="2"><br /></td>
							</tr>
							<tr>
								<td><input type="button" value="重置" class="btn btn-primary"/></td>
								<td><input type="submit" value="登陆" class="btn btn-primary"/></td>
							</tr>
							<tr>
								<td colspan="2"><br /></td>
							</tr>
							<tr>
								<td colspan="2"><span id="info">${erroMsg }</span></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
