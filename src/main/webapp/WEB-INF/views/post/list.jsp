<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>

<div class="container">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>id</th>
				<th>title</th>
				<th>userId</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="post"  items="${posts }">
		    <tr>
				<td>${post.id }</td>
				<td><button type="button" onclick="postdetail(${post.id})">${post.title }</button></td>
				<td>${post.userId }</td>
			</tr>		
		</c:forEach>
			<tr>
				<td>John</td>
				<td>Doe</td>
				<td>john@example.com</td>
			</tr>
			<tr>
				<td>Mary</td>
				<td>Moe</td>
				<td>mary@example.com</td>
			</tr>
			<tr>
				<td>July</td>
				<td>Dooley</td>
				<td>july@example.com</td>
			</tr>
		</tbody>
	</table>
</div>

<script>

	
	
	function postdetail(postid){
		
		location.href = '/post/detail/'+postid
		
	}


</script>




<%@include file="../include/footer.jsp"%>
