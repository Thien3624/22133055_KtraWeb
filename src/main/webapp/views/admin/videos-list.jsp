<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<c:url value="/admin/video/add"/>">Add Category</a>
	<br>
	<hr>
	<table border="1" width="100%">
		<tr>
			<th>STT</th>
			<th>Title</th>
			<th>Poster</th>
			<th>Views</th>
			<th>Description</th>
			<th>Active</th>
			<th>CategoryId</th>
		</tr>
		<c:forEach items="${listvideos}" var="video" varStatus="STT">
			<tr>
				<td>${STT.index+1 }</td>
				<td>${video.title }</td>
				<c:if test="${video.poster.substring(0,5)=='https'}">
					<c:url value="${video.poster }" var="imgUrl"></c:url>
				</c:if>
				<c:if test="${video.poster.substring(0,5)!='https'}">
					<c:url value="/image?fname=${video.poster}" var="imgUrl"></c:url>
				</c:if>
				<td><img height="150" width="200" src="${imgUrl}" /></td>
				<td>${video.views }</td>
				<td>${video.description }</td>
				<td><c:if test="${video.active==1 }">
				Hoạt động
				</c:if> <c:if test="${video.active!=1 }">
				Khóa
				</c:if></td>
				<td>${video.categoryId }</td>
				<td><a
					href="<c:url value='/admin/video/edit?id=${video.videoId }'/>">Sửa</a>
					| <a
					href="<c:url value='/admin/video/delete?id=${video.videoId }'/>">Xóa</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>