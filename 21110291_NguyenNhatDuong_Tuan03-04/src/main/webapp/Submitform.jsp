<%@ page import="com.fit.src.entities.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/9/2024
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Student sv = new Student();
    sv = (Student) request.getAttribute("student");
    out.println("First name:" + sv.getFname()
            + "<br/> Last name: " + sv.getLname()
            + "<br/> Email : " + sv.getEmail()
            + "<br/> Gender: " +sv.getGender()
            + "<br/> Birthday: " + sv.getBirthDate()
    );
    List<String> hobbies = sv.getHobbies();
    out.println("<br/> Hobbies: ");
    for (String hobby : hobbies) {
        out.println(hobby + " ");
    }
%>
</body>
</html>
