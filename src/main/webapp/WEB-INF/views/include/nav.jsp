<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!-- isAuthenticated() 있으면 true 세션값을 변수 principal 넣음 값을 principal 넣음 -->
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal" />
</sec:authorize>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- viewport 화면에따라 달라짐 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<!-- 나만의 css -->
<link rel="stylesheet" href="/css/style.css">

<title>블로그</title>
</head>
<body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	

	<nav class="navbar navbar-expand-md mynav__color navbar-dark">
		<a class="navbar-brand" href="/">Navbar</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">

				<c:choose>
					<c:when test="${not empty principal}">
						<li class="nav-item"><a class="nav-link" href="/post/write">글쓰기</a></li>
						<li class="nav-item"><a class="nav-link" href="/user/profile/${principal.id}">회원정보수정</a></li>
						<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="/user/join">회원가입</a></li>
						<li class="nav-item"><a class="nav-link" href="/user/login">로그인</a></li>
					</c:otherwise>
				</c:choose>
				
			</ul>
			<img src="/media/${principal.profile }" class = "rounded-circle my__img ml-auto" 
			width="30px" height="30px" onerror="javascript:this.src = '/images/unknown.jpg'"/>
		</div>
	</nav>

	<br />