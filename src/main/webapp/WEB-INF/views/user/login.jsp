<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container">
	<form>
		<div class="form-group">
			<label for="username">아이디:</label> 
			<input type="text" class="form-control" placeholder="Enter username" id="username">
		</div>
		<div class="form-group">
			<label for="password">패스워드:</label> 
			<input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>	
	</form>
	<button id="login--submit" type="button" class="btn btn-primary">로그인</button>
</div>



<script>
	// function 용어 생략 가능
								//클릭된 놈에 대한 이벤트를 가질 수 있다. function(e) {e.priventDefault()}; 막기!
	$('#login--submit').on('click',function(){
//		e.priventDefault()
		var data = {
			username:$('#username').val(),
			password:$('#password').val()
		}

		$.ajax({
			type:'POST',
			url:'/user/login',
			data:JSON.stringify(data),
			contentType:'application/json; chartset=utf-8',
			dataType:'json'			
		}).done(function(r){
			console.log("로그인 성공");
//			console.log(r);
			location.href='/';		
		}).fail(function(r){
			console.log("로그인 실패");
//			console.log(r);
			
		})

		
	})
	
	



</script>




<%@include file="../include/footer.jsp"%>