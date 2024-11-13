<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<table>
        <tr>
            <td rowspan="5">
                <img src="${video.poster}" alt="Poster" class="poster"/>
            </td>
            <td>Tiêu đề: ${video.title}</td>
        </tr>
        <tr>
            <td>Mã video: ${video.videoId}</td>
        </tr>
        <tr>
            <td>Category name: ${video.category.categoryName}</td>
        </tr>
        <tr>
            <td>View: ${video.views}</td>
        </tr>
        <tr>
            <td>
                Share(${video.shares.size()}) 
                <br/>
                Like(${video.favorites.size()})
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <strong>Description:</strong>
                <br/>
                ${video.description}
            </td>
        </tr>
    </table>