<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container">
<!-- put이 안됨 -->
	<form action="user/profile" method="POST" enctype="multipart/form-data">
		<div class="form-group">
			<label for="username">아이디:</label> 
			<input type="text" class="form-control" placeholder="Enter username" name="username" readonly="readonly" value="ssar"/>
		</div>
		<div class="form-group">
			<label for="password">패스워드:</label> 
			<input type="password" class="form-control" placeholder="Enter password" name="password" value="1234"/>
		</div>	
		<!-- 이메일인증  -->
		<div class="form-group">
			<label for="email">이메일:</label> 
			<input type="email" class="form-control" placeholder="Enter email" name="email" value="ssar@nate.com" readonly="readonly"/>
		</div>			
		<!-- file 이기 때문에 contentType json x mutipart? 따라서 form 사용 -->
		<div class="form-group">
			<label for="profile">이메일:</label> 
			<input type="file" class="form-control" name="profile" value="my.ing" readonly="readonly"/>
		</div>	
		<button type="summit" class="btn btn-primary">수정</button>
	</form>
	
</div>

<%@include file="../include/footer.jsp"%>