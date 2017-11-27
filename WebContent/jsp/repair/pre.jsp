<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/tld/c.tld"%>
    
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<form action="${pageContext.request.contextPath }/repair/save.do" method="post">
				<div class="input-group">
				  <span class="input-group-addon" id="basic-addon3">维修处理编号</span>
				  <input type="text" class="form-control" id="basic-url" name="id"
				  						aria-describedby="basic-addon3" value="${repair.id }" disabled="disabled">
				</div>
				<br/>
				
				<div class="input-group">
				  	<span class="input-group-addon" id="basic-addon3">设备名称</span>
				  	<select class="form-control" name="equipmentId" aria-describedby="basic-addon3">
				  		<c:forEach items="${equipments }" var="equipment">
				  			<c:choose>
					  			<c:when test="${repair.equipmentId == equipment.id }">
					  				<option value="${equipment.id }" selected="selected">${equipment.name }</option>
					  			</c:when>
					  			<c:otherwise>
					  				<option value="${equipment.id }">${equipment.name }</option>
					  			</c:otherwise>
				  			</c:choose>
				  		</c:forEach>
				  	</select>
				</div>
				<br/>
				
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon3">报修人员</span>
				  	
				  	<select class="form-control" name="userman" aria-describedby="basic-addon3">
				  		<c:forEach items="${users }" var="user">
				  			
				  			<c:choose>
				  				<c:when test="${repair.userman == user.userName}">
				  					<option value="${user.userName }" selected="selected">${user.userName }</option>
				  				</c:when>
				  				<c:otherwise>
				  					<option value="${user.userName }" >${user.userName }</option>
				  				</c:otherwise>
				  			</c:choose>
				  		</c:forEach>
				  	</select>
				</div>
				<br/>
				
				<div class="input-group">
				  <span class="input-group-addon" id="basic-addon3">维修人员</span>
				  	
				  	<select class="form-control" name="repairmen" aria-describedby="basic-addon3">
				  		<c:forEach items="${rusers }" var="ruser">
				  			
				  			<c:choose>
				  				<c:when test="${repair.repairmen == ruser.userName}">
				  					<option value="${ruser.userName }" selected="selected">${ruser.userName }</option>
				  				</c:when>
				  				
				  				<c:otherwise>
				  					<option value="${ruser.userName }">${ruser.userName }</option>
				  				</c:otherwise>
				  			</c:choose>
				  		</c:forEach>
				  	</select>
				</div>
				<br/>
				
				<button type="button" onclick="javascrip:history.back();" 
							class="btn btn-info">取&nbsp;消</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" class="btn btn-primary" value="保&nbsp;存">
			</form>
		</div>
	</div><!-- end row -->
</div> <!-- end container -->