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


<script src="/js/join.js">
//컨텍스트 패스를 넣어주여야 한다. 있으면
</script>














<%@include file="../include/footer.jsp"%>