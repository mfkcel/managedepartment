<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/tld/c.tld"%>
    
<div class="container">
<div class="row">
	<div class="col-md-5">
	<div class="input-group">
	      <input type="text" class="form-control" placeholder="请输入要查询的部门...">
	      <span class="input-group-btn">
	        <a class="btn btn-primary" role="button" href="">查&nbsp;&nbsp;找</a>
	      </span>
	</div><!-- /input-group -->
	</div>
	<div class="col-md-2 col-md-offset-5">
		<a role="button" href="${pageContext.request.contextPath }/department/pre.do" class="btn btn-primary">新&nbsp;&nbsp;增</a>
	</div>
</div><!-- end row -->
<br/>
<div class="row">
	<div class="list">
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>部门编号</td>
					<td>部门名称</td>
					<td>部门简介</td>
					<td>操作</td>
				</tr>
			</thead>
			<c:forEach var="department" items="${departments }" varStatus="index">
				<tr>
					<td>${department.id }</td>
					<td>${department.departName }</td>
					<td>${department.remark}</td>
					<td>
						<a class="btn btn-info" href="${pageContext.request.contextPath }/department/pre.do?id=${department.id}">修&nbsp;改</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="btn btn-danger" href="${pageContext.request.contextPath }/department/delete.do?id=${department.id}">删&nbsp;除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div> <!-- end row -->
</div>