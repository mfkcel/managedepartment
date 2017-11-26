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
		<a role="button" href="${pageContext.request.contextPath }/repair/pre.do" class="btn btn-primary">新&nbsp;&nbsp;增</a>
	</div>
</div><!-- end row -->
<br/>
<div class="row">
	<div class="list">
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>序号</td>
					<td>设备ID</td>
					<td>设备名称</td>
					<td>设备类型</td>
					<td>报修人员</td>
					<td>维修人员</td>
					<td>报修时间</td>
					<td>完成时间</td>
					<td>设备状态</td>
					<td>维修状态</td>
				</tr>
			</thead>
			<c:forEach var="repair" items="${repairs }" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${repair.equipmentId}</td>
					<td>${repair.equiptName}</td>
					<td>${repair.equiptTypeName}</td>
					<td>${repair.userman}</td>
					<td>${repair.repairmen}</td>
					<td>${repair.repairTime}</td>
					<td>${repair.finishTime}</td>
					<td>
						<c:choose>
							<c:when test="${repair.state == 1 }"><p class="text-success">设备维修成功</p></c:when>
							<c:when test="${repair.state == 2 }"><p class="text-danger">报废</p></c:when>
						</c:choose>
					</td><!-- end 状态  状态较多或后续会更改还是要封装起来-->
					<td>
						<c:choose>
							<c:when test="${repair.finishTime == 1 }"><p class="text-danger">未处理</p></c:when>
							<c:when test="${repair.finishTime == 2 }"><p class="text-primary">已处理</p></c:when>
							<c:when test="${repair.finishTime == 3 }"><p class="text-warning">处理中</p></c:when>
						</c:choose>
					</td><!-- end 状态  状态较多或后续会更改还是要封装起来-->
					<td>
						<a class="btn btn-info" href="${pageContext.request.contextPath }/repair/pre.do?id=${department.id}">修&nbsp;改</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="btn btn-danger" href="${pageContext.request.contextPath }/repair/delete.do?id=${department.id}">删&nbsp;除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div> <!-- end row -->
</div>