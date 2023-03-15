<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>USER</title>
</head>
<body>
<h1>Hello USER</h1>
<h3>${result}</h3><br>
<h3>${count}</h3><br>

<p>
<%Date date = new Date();%>
<%= date %>
</p>
<a href="auth">Вернуться</a>
</body>
</html>

</body>
</html>
