<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/9/2024
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload files</title>
</head>
<body>
<form action="/upload-files" method="post" enctype="multipart/form-data">
    <div>
        <span>File #1:</span>
        <input type="file" name="file" />
    </div>
    <div>
        <span>File #2:</span>
        <input type="file" name="file2" />
    </div>
    <div>
        <span>File #3:</span>
        <input type="file" name="file3" />
    </div>
    <div>
        <span>File #4:</span>
        <input type="file" name="file4" />
    </div>
    <div>
        <span>File #5:</span>
        <input type="file" name="file5" />
    </div>
    <div>
        <button type="submit" value="Upload">Upload</button>
        <button type="button">Reset</button>
    </div>
</form>
</body>
</html>
