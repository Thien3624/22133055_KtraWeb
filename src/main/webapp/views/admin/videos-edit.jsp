<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<form action="${pageContext.request.contextPath}/admin/video/update"
	method="post" enctype="multipart/form-data">
	<label for="title">Title:</label><br> 
	<input type="text" id="title" name="title" value="${video.title}"><br> 
	<label for="poster">Poster:</label><br>
	<c:if test="${video.poster.substring(0,5)=='https'}">
		<c:url value="${video.poster }" var="imgUrl"></c:url>
	</c:if>
	<c:if test="${video.poster.substring(0,5)!='https'}">
		<c:url value="/image?fname=${video.poster}" var="imgUrl"></c:url>
	</c:if>
	<img height="150" width="200" src="${imgUrl}" /> <input type="file"
		id="poster" name="poster" value="${video.poster}"><br> 
	<label for="views">Views:</label><br> 
	<input type="text" id="views" name="views" value="${video.views}"><br> 
	
	<label for="description">Description:</label><br> 
	<input type="text" id="description" name="description" value="${video.description}"><br> 
	
	<label>active:</label><br>
	<input type="radio" id="active1" name="active" value="1"
		<c:if test="${video.active == 1}">checked</c:if>> 
		<label for="active1">Active (1)</label>
		<br> <input type="radio" id="active0" name="active" value="0"
		<c:if test="${video.active != 1}">checked</c:if>> 
		<label for="active0">Inactive (0)</label><br> <br> 
	
	<label for="categoryId">CategoryId:</label><br> 
	<input type="text" id="categoryId" name="categoryId" value="${video.categoryId}"><br> 
	
	<input type="submit" value="Submit"> <br> 
	<input type="text" id="videoId" name="videoId" value="${video.videoId}"
	hidden="hidden"><br>
</form>
