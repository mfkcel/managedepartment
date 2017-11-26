<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/tld/c.tld"%>
    
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<form action="${pageContext.request.contextPath }/equipment/save.do" method="post">
				<input type="hidden" value="${equipment.id }" name="id">
				<div class="input-group">
				  <span class="input-group-addon" id="basic-addon3">设备编号</span>
				  <input type="text" class="form-control" id="basic-url" name="no"
				  						aria-describedby="basic-addon3" value="${equipment.no }" disabled="disabled">
				</div>
				<br/>
				<div class="input-group">
				  <span class="input-group-addon" id="basic-addon3">设备名称</span>
				  <input type="text" class="form-control" id="basic-url" name="name"
				  						aria-describedby="basic-addon3" value="${equipment.name }">
				</div>
				<br/>
				<div class="input-group">
				  <span class="input-group-addon" id="basic-addon3">设备简介</span>
				  <input type="text" class="form-control" id="basic-url" name="remark"
				  						aria-describedby="basic-addon3" value="${equipment.remark }">
				</div>
				<br/>
				
				<div>
					<select class="form-control" name="typeId">
					  <c:forEach items="equipmentTypes" var="equipmentType">
					  	<option value="${equipmentType.id }">${equipmentType.name } </option>
					  </c:forEach>
					</select>
				</div> <!-- end equipmentType -->
				<br/>
				
				<div>
					<label class="radio-inline">
					  <c:if test="${equipment.state == 1 }">
					   	<input type="radio" name="state" id="state1" value="1" checked="checked"> 正常
					  </c:if>
					  <input type="radio" name="state" id="state1" value="1" > 正常
					</label>
					
					<label class="radio-inline">
					<c:if test="${equipment.state == 2 }">
					   	<input type="radio" name="state" id="state1" value="2" checked="checked"> 设备维修中...
					  </c:if>
					  <input type="radio" name="state" id="state2" value="2"> 设备维修中...
					</label>
					
					<label class="radio-inline">
					<c:if test="${equipment.state == 3 }">
					   	<input type="radio" name="state" id="state1" value="3" checked="checked"> 报废
					  </c:if>
					  <input type="radio" name="state" id="state3" value="3"> 报废
					</label>
				</div> <!-- ens equipmentState -->
				<br/>
				
				<button type="button" onclick="javascrip:history.back();" 
							class="btn btn-info">取&nbsp;消</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" class="btn btn-primary" value="保&nbsp;存">
			</form>
		</div>
	</div><!-- end row -->
</div> <!-- end container -->