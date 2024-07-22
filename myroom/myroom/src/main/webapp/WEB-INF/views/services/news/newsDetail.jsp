<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<!-- header start-->
<jsp:include page="../../common/header.jsp" />
<!-- header end-->

<div class="bg-light">
    <section class="container">
     <!-- title -->
        <article class="pt-5 pb-5">
            <h1>news</h1>
        </article>

        <!-- 작성 페이지 -->
        <article >
              <div class="mb-3 w-50">
                <img style="height:30vh;width:auto;" src="${data.displayUrl}" />
              </div>
            <div class="mb-3 p-3" style="border:1px solid #cecece;border-radius:5px">
              <p  class="text-end" >작성일 : ${date}</p>
              <p style="min-height:15rem">${data.caption}</p>
              <div class="invalid-feedback">
              </div>
            </div>

            <div class="mb-3">
              <p>${blog.category}</p>
              <div class="invalid-feedback">Example invalid select feedback</div>
            </div>


            <div class="mb-3">

            <p id="img-name">${blog.fileName}</p>
            <img id="blog-img" src="${blog.fileUrl}" style="max-width:50%;">
              <div class="invalid-feedback">Example invalid form file feedback</div>
            </div>

            <div class="mb-3 mt-5 text-end">
              <button class="btn btn-primary " type="button" onclick="location.href='/news'" >리스트</button>
            </div>
        </article>
        <!-- 작성 끝 -->
    </section>
</div>

<!-- footer start-->
<jsp:include page="../../common/footer.jsp" />
<!-- footer end-->

 <script type="text/javascript">
   </script>
</body>
</html>