<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/tld/c.tld"%>
    
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<form action="${pageContext.request.contextPath }/equipmenttype/save.do" method="post">
				<input type="hidden" value="${equipmentType.id }" name="id">
				<div class="input-group">
				  <span class="input-group-addon" id="basic-addon3">部门名称</span>
				  <input type="text" class="form-control" id="basic-url" name="typeName"
				  						aria-describedby="basic-addon3" value="${equipmentType.typeName }">
				</div>
				<br/>
				<div class="input-group">
				  <span class="input-group-addon" id="basic-addon3">部门简介</span>
				  <input type="text" class="form-control" id="basic-url" name="remark"
				  						aria-describedby="basic-addon3" value="${equipmentType.remark }">
				</div>
				<br/>
				<button type="button" onclick="javascrip:history.back();" 
							class="btn btn-info">取&nbsp;消</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" class="btn btn-primary" value="保&nbsp;存">
			</form>
		</div>
	</div><!-- end row -->
</div> <!-- end container -->