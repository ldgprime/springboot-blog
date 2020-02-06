<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container">
	<form>
		<div class="form-group">
			<label for="username">아이디:</label> 
			<input type="text" class="form-control" placeholder="Enter username" id="username"   maxlength="15">
		</div>
		<div class="form-group">
			<label for="password">패스워드:</label> 
			<input type="password" class="form-control" placeholder="Enter password" id="password" maxlength="15">
		</div>
		<!-- 패스워드 확인! 만들어보기 JS eq  -->
		<div class="form-group">
			<label for="email">이메일:</label> 
			<input type="email" class="form-control" placeholder="Enter email" id="email" maxlength="30">
		</div>		
	</form>
	<button id="join--submit" type="button" class="btn btn-primary">회원가입</button>
</div>

<script>
	//리스너-----------------------//핸들러------ function내용 	
	$('#join--submit').on('click',function(){
		var data = {
			username:$('#username').val(),
			password:$('#password').val(),
			email:$('#email').val()
		}

		//함수를 호출할 때 . $==JQuery
		$.ajax({
			//GET 쿼리스트링만 formdata 이런형식 username=ssar&password=1234&email=ssar%40nate.com
			type:'POST',
			url:'/user/join',
			data:JSON.stringify(data),
			contentType:'application/json; chartset=utf-8',
			dataType:'json'					
		}).done(function(r){
			if(r.statusCode == 200){
				alert('회원가입 성공');
				location.href = '/user/login';
			}else{
				if(r.msg == '아이디중복'){
					alert('아이디가 중복되었습니다.')
				}
				alert('회원가입 실패');
			}
		}).fail(function(r){
			alert('회원가입 실패');
		})
		
	})




</script>














<%@include file="../include/footer.jsp"%>