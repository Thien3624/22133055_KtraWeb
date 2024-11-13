<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<form action="${pageContext.request.contextPath}/admin/category/insert" method="post" enctype="multipart/form-data">
	<label for="title">Tile:</label><br> 
	<input type="text" id="title" name="title"><br> 
	
	<label for="poster">Poster:</label><br> 
	<input type="file" id="poster" name="poster"><br>
	
	<label for="active">active:</label><br> 
	<input type="radio" id="active1" name="active" value="1" required>
	<label for="active1">Active (1)</label><br>
	<input type="radio" id="active0" name="active" value="0" required>
	<label for="active0">Inactive (0)</label><br>
	
	<label for="views">Views:</label><br> 
	<input type="text" id="views" name="views"><br> 
	
	<label for="description">Description:</label><br> 
	<input type="text" id="description" name="description"><br> 
	
	<label for="categoryId">CategoryId:</label><br> 
	<input type="text" id="categoryId" name="categoryId"><br> 
	
	<br> <input type="submit" value="Submit">
</form>
