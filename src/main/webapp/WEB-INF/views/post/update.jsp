<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container">
	<form>
		<div class="form-group">
			<input id="userId" type="hidden" value="${post.userId }"/>
			<input id="postId" type="hidden" value="${post.id }"/>
			<label for="title">제목:</label> 
			<input type="text" class="form-control" placeholder="Enter title" id="title" value="${post.title }">
		</div>
		<div class="form-group">
			<label for="content">내용:</label> 
			<textarea class="form-control" rows="5" placeholder="Enter content" id="content">${post.content }</textarea>
		</div>	
	</form>
	<button id="update--submit" type="button" class="btn btn-primary">수정</button>
</div>

<script>

$('#update--submit').on('click',function(){
	



	var data = {
			
		title: $('#title').val(),
		content: $('#content').val(),
		id: $('#postId').val()
			
	}


	$.ajax({
		type:'PUT',
		url:'/post/update', 
		data:JSON.stringify(data),
		contentType:'application/json; chartset=utf-8',
		dataType:'json'
	}).done(function(r){
		alert('글수정에 성공했습니다!')
		location.href = '/'
	
	
	}).fail(function(r){
	
		alert('글수정에 실패했습니다!')
	
		
	})
	
	
})	

</script>



<%@include file="../include/footer.jsp"%>