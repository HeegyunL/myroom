<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ page import="org.json.JSONArray" %>
 <%@ page import="org.json.JSONObject" %>
 <%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="/assets/css/news.css" rel="stylesheet">
</head>
<body>
<!-- header start-->
<jsp:include page="../../common/header.jsp" />
<!-- header end-->

<div class="bg-light">
    <section class=" container frame-bg ">
        <article class="pt-5 pb-5">
            <h1>news</h1>
        </article>



        <article>
            <div class="container">
                <ul style="list-style:none;">
                <c:forEach items="${data}" var="data" begin="26" end="33">
                    <li class="mb-3">
                        <div id="news-card-frame" class=" d-flex post" style="">
                            <div id="news-card-image" style="width:25%;background-image:url('${data.displayUrl}');" class=" bg-secondary"></div>
                            <div style="width:75%;" class="p-3">
                                <p>${data.caption}</p>
                            </div>
                        </div>
                    </li>
                </c:forEach>
                    <li>
                        <div id="news-card-frame" class=" d-flex" style="">
                            <div id="news-card-image" style="width:25%;background-image:url('../../../assets/img/건담2.jpeg') " class=" bg-secondary"></div>
                            <div style="width:75%;" class="p-3">
                                <p><속보>핑크피카츄 생겨버림</p>
                                <p>핑크 피카츄가 생겼어요<br>
                                 많관부</p>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </article>
    </section>
</div>

<!-- footer start-->
<jsp:include page="../../common/footer.jsp" />
<!-- footer end-->
</body>
</html>