<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container">
	<form>
		<div class="form-group">
			<label for="title">제목:</label> 
			<input type="text" class="form-control" placeholder="Enter title" id="title" value="제목입니다">
		</div>
		<div class="form-group">
			<label for="content">내용:</label> 
			<textarea class="form-control" rows="5" placeholder="Enter content" id="content">내용입니다.</textarea>
		</div>	
	</form>
	<button id="update--submit" type="button" class="btn btn-primary">수정</button>
</div>

<%@include file="../include/footer.jsp"%>