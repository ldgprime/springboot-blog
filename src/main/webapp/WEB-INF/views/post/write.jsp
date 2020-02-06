<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container">
	<form>
		<div class="form-group">
			<label for="title">제목:</label> 
			<input type="text" class="form-control" placeholder="Enter title" id="title">
		</div>
		<div class="form-group">
			<label for="content">내용:</label> 
			<textarea class="form-control" rows="5" placeholder="Enter content" id="content"></textarea>
		</div>	
	</form>
	<button id="write--submit" type="button" class="btn btn-primary">등록</button>
</div>

<%@include file="../include/footer.jsp"%>