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
	</table>
</div>






<%@include file="../include/footer.jsp"%>
