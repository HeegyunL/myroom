<%@ page import="org.json.JSONArray" %>
<%@ page import="org.json.JSONObject" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Instagram Data</title>
</head>
<body>
    <h1>Instagram Posts</h1>
 <script>
     var msg = "<c:out value='${data}' />"


     alert(msg);
 </script>
<c:forEach items="${data}" var="data">
        <div>
            <h2>${data.ownerUsername}</h2>
            <h2><img src="${data.displayUrl}" style="width:max-width:5rem"></h2>
        </div>
    </c:forEach>
</body>
</html>
