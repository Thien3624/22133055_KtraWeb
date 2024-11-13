<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <title>Danh sách Video theo Category</title>
</head>
<body>
    <c:forEach var="category" items="${categories}">
        <h2>Category: ${category.categoryName}</h2>
        <c:forEach var="video" items="${category.videos}">
            <div>
                <h3>${video.title}</h3>
                <img src="${video.poster}" alt="${video.title}" style="width: 200px; height: auto;">
                <p>Views: ${video.views}</p>
                <p>Like: ${video.favorites.size()}</p>
                <p><a href="${pageContext.request.contextPath}/video-detail?videoId=${video.videoId}">Chi tiết</a></p>
            </div>
        </c:forEach>
        <hr/>
    </c:forEach>
</body>
</html>
