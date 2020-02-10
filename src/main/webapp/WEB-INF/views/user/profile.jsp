<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>


<div class="container">
								<!-- form:form 방식도 존재! 테그라이브러리, filter 추가!-->
                                   <!-- 기존 form put이 안됨 -->                                  
	<form:form action="/user/profile" method="PUT" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${sessionScope.principal.id }"/>
		<div class="form-group">
			<label for="username">아이디:</label> 
			<input type="text" class="form-control" placeholder="Enter username"  readonly="readonly" value="${sessionScope.principal.username }"/>
		</div>
		<div class="form-group">
			<label for="password">패스워드:</label> 
			<input type="password" class="form-control" placeholder="Enter password" name="password" value="" required="required"/>
		</div>	
		<!-- 이메일인증  -->
		<div class="form-group">
			<label for="email">이메일:</label> 
			<input type="email" class="form-control" placeholder="Enter email"  value="${sessionScope.principal.email }" readonly="readonly"/>
		</div>			
		<!-- file 이기 때문에 contentType json x mutipart? 따라서 form 사용 -->
		<div class="form-group">
			<label for="profile">사진:</label> 
			<input type="file" class="form-control" name="profile" readonly="readonly"/>
			<p class="my__profile">${sessionScope.principal.profile }</p>
		</div>	
		<button class="btn btn-primary">수정</button>
	</form:form>
	
</div>

<%@include file="../include/footer.jsp"%>