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
				  						aria-describedby="basic-addon3" value="${department.departName }" disabled="disabled">
				</div>
				<br/>
				
				<div class="input-group">
				  <label>
				  	设备名称
				  	<select class="form-control" name="equipmentId">
				  		<c:forEach items="${equipmets }" var="equipment">
				  			<option value="${equipment.id }">${equipment.name }</option>
				  		</c:forEach>
				  	</select>
				  </label>
				</div>
				<br/>
				
				<div class="input-group">
				  <label>
				  	报修人员
				  	<select class="form-control" name="useman">
				  		<c:forEach items="${users }" var="user">
				  			<option value="${user.userName }">${user.userName }</option>
				  		</c:forEach>
				  	</select>
				  </label>
				</div>
				<br/>
				
				<div class="input-group">
				  <label>
				  	维修人员
				  	<select class="form-control" name="repairmen">
				  		<c:forEach items="${rusers }" var="ruser">
				  			<option value="${ruser.userName }">${ruser.userName }</option>
				  		</c:forEach>
				  	</select>
				  </label>
				</div>
				<br/>
				
				<button type="button" onclick="javascrip:history.back();" 
							class="btn btn-info">取&nbsp;消</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" class="btn btn-primary" value="保&nbsp;存">
			</form>
		</div>
	</div><!-- end row -->
</div> <!-- end container -->