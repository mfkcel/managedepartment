<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/tld/c.tld"%>
    
<div class="container">
<div class="row">
	<div class="col-md-5">
	<div class="input-group">
	      <input type="text" class="form-control" placeholder="请输入要查询的员工姓名...">
	      <span class="input-group-btn">
	        <a class="btn btn-primary" role="button" href="">查&nbsp;&nbsp;找</a>
	      </span>
	</div><!-- /input-group -->
	</div>
	<div class="col-md-2 col-md-offset-5">
		<a role="button" href="${pageContext.request.contextPath }/user/pre.do" class="btn btn-primary">新&nbsp;&nbsp;增</a>
	</div>
</div><!-- end row -->
<br/>
<div class="row">
	<div class="list">
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>序号</td>
					<td>昵称</td>
					<td>姓名</td>
					<td>员工类别</td>
					<td>部门ID</td>
					<td>操作</td>
				</tr>
			</thead>
			<c:forEach var="user" items="${users }" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${user.userName}</td>
					<td>****</td>
					<td>${user.trueName}</td>
					<td>${user.roleName}</td>
					<td>${user.deptId}</td>
					<td>
						<a class="btn btn-info" href="${pageContext.request.contextPath }/user/pre.do?id=${user.id}">修&nbsp;改</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="btn btn-danger" href="${pageContext.request.contextPath }/user/delete.do?id=${user.id}">删&nbsp;除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div> <!-- end row -->
</div>