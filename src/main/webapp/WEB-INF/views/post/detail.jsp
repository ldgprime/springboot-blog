<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>

<div class="container">

	<div class="card">
		<div class="card-header">
			<h4 class="card-title">${post.title }</h4>
			
		</div>
		<div class="card-body">
			<p class="card-text">${post.content }</p>

		</div>
		<div class="card-footer">
			<c:if test="${post.userId eq principal.id}">
			<a href="/post/update/${post.id}" class="btn btn-warning">수정</a>
			<button id="post--delete--submit" value="${post.id }" type="button" class="btn btn-danger">삭제</button>
			</c:if>
			<a href="/" type="button" class="btn btn-primary">목록</a>
		</div>
	</div>

	<br />

	<div class="card">
		<div class="form-group">
			<div class="card-body">
			<p>댓글 등록</p>
			<input type="hidden" id="postId" value="${post.id }"/>
			<input type="hidden" id="userId" value="${principal.id }"/>
				<textarea id="content" rows="2" class="form-control"></textarea>
			</div>
			<div class="card-footer">
				<button id="comment--save--submit"  type="button" class="btn btn-primary">등록</button>

			</div>
		</div>
	</div>

	<br />

	<div class="card">
		<div class="form-group">
			<div class="card-header">
				<h4 class="card-title">댓글리스트</h4>
			</div>
			<div id="comment--items" class="card-body">
			<c:forEach var="comment" items="${comments }">
 				<div id="comment--item--${comment.id }">
					<span class="comment--username">작성자: ${comment.username }</span>
					<span class="comment--content">${comment.content }</span>
					<c:if test="${comment.username eq principal.username }">					 
					<button onclick="commentDelete(${comment.id })">삭제</button>
					</c:if>
					<!-- 뿌리는 값이 문자열이면 ''필요 -->
				</div> 
			</c:forEach>	
			</div>
		</div>
	</div>

</div>

<script src="/js/detail.js">	
	
</script>

<script>

</script>


<%@include file="../include/footer.jsp"%>