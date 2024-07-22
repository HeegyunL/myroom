<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

<link href="/assets/css/gallery.css" rel="stylesheet">
<style>



</style>
</head>
<body>
<!-- header start-->
<jsp:include page="../../common/header.jsp" />
<!-- header end-->

<div class="bg-light">
    <section class=" container frame-bg ">
        <article class="pt-5 pb-5">
            <h1>gallery</h1>
        </article>
        <article class=" ">
            <div id="columns" >
                 <c:forEach var="blog" items="${blog}" varStatus="status">
                 <figure ><img  src="${blog.fileUrl}" onclick="location.href='/work/${blog.id}'"></figure>
                 </c:forEach>
            </div>
        </article>
    </section>
</div>

<!-- footer start-->
<jsp:include page="../../common/footer.jsp" />
<!-- footer end-->


</body>
</html>