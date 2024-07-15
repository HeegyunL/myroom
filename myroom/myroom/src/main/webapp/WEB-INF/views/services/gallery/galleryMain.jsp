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
<script>
     var msg = "<c:out value='${data}' />"


     alert(msg);
 </script>
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
                 <!--
                 <figure ><img  src="../../../assets/img/건담1.jpeg" onclick="location.href='./'"></figure>
                 <figure ><img  src="../../../assets/img/건담2.jpeg" onclick="location.href='./'"></figure>
                 <figure ><img  src="../../../assets/img/스탠드조명.png" onclick="location.href='./'"></figure>
                 <figure ><img  src="../../../assets/img/책상.png" onclick="location.href='./'"></figure>
                 <figure ><img  src="../../../assets/img/책상.png" onclick="location.href='./'"></figure>
                 -->
                 <c:forEach var="blog" items="${blog}" varStatus="status">
                 <script>


                 </script>
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