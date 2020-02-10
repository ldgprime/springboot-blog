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
	<input type="hidden" id="userId" value="${ sessionScope.principal.id}"/>
	<button id="write--submit" type="button" class="btn btn-primary">등록</button>
</div>

<script>	
	$('#write--submit').on('click',function(){
		var data = {
			title:$('#title').val(),
			content:$('#content').val(),
			userId:$('#userId').val()
		}


	$.ajax({
		type:'POST',
		url:'/post/write', 
		data:JSON.stringify(data),
		contentType:'application/json; chartset=utf-8',
		dataType:'json'
	}).done(function(r){		
		if(r.statusCode == 200){
			alert('글쓰기에 성공했습니다!');
			location.href = '/';
			
	    }else{
	    	alert('글쓰기에 실패했습니다!');
	    	
		}
		
		

	}).fail(function(r){
		alert('글쓰기에 실패했습니다!');

		
	})

				
	
	
})




		
  






</script>







<%@include file="../include/footer.jsp"%>