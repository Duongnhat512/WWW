<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<div>
    <div style="display: flex; justify-content: center; gap: 15px; border-bottom: 1px solid black;">
        <a href="${pageContext.request.contextPath}/danhsachtintuc?action=list">Danh sách tin tức</a> |
        <a href="${pageContext.request.contextPath}/danhsachtintuc?action=add">Thêm tin tức mới</a> |
        <a href="${pageContext.request.contextPath}/danhsachtintuc?action=manage">Chức năng quản lý</a>
    </div>
    <div style="border-top: 1px solid black">
        <p>Nguyễn Nhất Dương - 21110291</p>
    </div>
</div>
</body>
</html>