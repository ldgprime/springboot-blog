<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>id</th>
				<th>title</th>
				<th>userId</th>
				<th>createDate</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="post"  items="${posts }">
		    <tr>
				<td>${post.id }</td>
				<td><a href="/post/detail/${post.id }">${post.title }</a></td>
				<td>${post.username }</td>
				<td>${post.createDate }</td>
			</tr>		
		</c:forEach>
		</tbody>
		
		
		<tr>
			<td id="pagenate" colspan="5" align="center">
				<c:choose>
					<c:when test="${pageMaker.prev }">
						<a href="${pageMaker.startPage-1 }">이전</a>
					</c:when>
					<c:otherwise>
 						 이전
					</c:otherwise>
				</c:choose> 
				<c:forEach begin="${pageMaker.startPage }" end="${ pageMaker.endPage}" var="i">
					<c:choose>
						<c:when test="${pageMaker.criteria.page == i }">
							${i }
						</c:when>
						<c:otherwise>
							<a href="${i }">${i }</a>
						</c:otherwise>
					</c:choose>
				</c:forEach> 
				<c:choose>
					<c:when test="${pageMaker.next }">
						<a href="${pageMaker.endPage+1 }">다음</a>
					</c:when>
					<c:otherwise>
  						다음
					</c:otherwise>
				</c:choose></td>
		</tr>
	</table>
</div>

<br />
	<br />
	
	
	
	<form id="jobForm">
		<input type="hidden" name="page" value="${pageMaker.criteria.page}" />
		<input type="hidden" name="perPageNum" value="${pageMaker.criteria.perPageNum}">		
	</form>

<script>
	var jobForm = $('#jobForm')

	
	$('#pagenate a').on("click",function(event){
		event.preventDefault();
		
		var targetPage=$(this).attr("href");		
		jobForm.find("[name='page']").val(targetPage);
		jobForm.attr("action","/post").attr("method","get");
		jobForm.submit();		
		
	})	

</script>



<%@include file="../include/footer.jsp"%>
