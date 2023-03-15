<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADMIN</title>
</head>
<body>
<h3>${name}</h3><br>
<h3>${role}</h3><br>

<h1>Hello ADMIN</h1>
<p>
    <%Date date = new Date();%>
    <%= date %>
</p>
<a href="auth">Вернуться</a>
</body>
</html>

</body>
</html>
