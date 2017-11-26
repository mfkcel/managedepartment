<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/tld/c.tld"%>
    
<div class="container">
<div class="row">
	<div class="col-md-5">
	<div class="input-group">
	      <input type="text" class="form-control" placeholder="请输入要查询的设备...">
	      <span class="input-group-btn">
	        <a class="btn btn-primary" role="button" href="">查&nbsp;&nbsp;找</a>
	      </span>
	</div><!-- /input-group -->
	</div>
	<div class="col-md-2 col-md-offset-5">
		<a role="button" href="${pageContext.request.contextPath }/equipment/pre.do" class="btn btn-primary">新&nbsp;&nbsp;增</a>
	</div>
</div><!-- end row -->
<br/>
<div class="row">
	<div class="list">
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>序&nbsp;&nbsp;&nbsp;&nbsp;号</td>
					<td>设&nbsp;备&nbsp;编&nbsp;号</td>
					<td>设&nbsp;备&nbsp;名&nbsp;称</td>
					<td>设&nbsp;备&nbsp;简&nbsp;介</td>
					<td>设&nbsp;备&nbsp;类&nbsp;型</td>
					<td>设&nbsp;备&nbsp;状&nbsp;态</td>
					<td>操&nbsp;&nbsp;&nbsp;&nbsp;作</td>
				</tr>
			</thead>
			<c:forEach var="equipment" items="${equipments }" varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td>${equipment.no}</td>
					<td>${equipment.name}</td>
					<td>${equipment.remark}</td>
					<%-- <td>
						<select class="form-control">
						  <c:forEach items="equipmentTypes" var="equipmentType">
						  	<c:if test="${equipmentType.id eq equipment.typeId }">
						  		<option >${equipmentType.typeName}</option>
						  	</c:if>
						  </c:forEach>
						</select>
					</td> --%>
					<td>hh</td>
					<td>
						<c:choose>
							<c:when test="${equipment.state == 1 }"><p class="text-primary">正常</p></c:when>
							<c:when test="${equipment.state == 2 }"><p class="text-warning">设备维修中...</p></c:when>
							<c:when test="${equipment.state == 3 }"><p class="text-danger">报废</p></c:when>
						</c:choose>
					</td><!-- end 状态  状态较多或后续会更改还是要封装起来-->
					<td>
						<a class="btn btn-info" href="${pageContext.request.contextPath }/equipment/pre.do?id=${equipment.id}">修&nbsp;改</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="btn btn-danger" href="${pageContext.request.contextPath }/equipment/delete.do?id=${equipment.id}">删&nbsp;除</a>
					</td> <!-- end 操作 -->
				</tr>
			</c:forEach>
		</table>
	</div>
</div> <!-- end row -->
</div>