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

<div>
    <section class="container">
     <!-- title -->
        <article class="pt-5 pb-5">
            <h1>work</h1>
        </article>

        <!-- 작성 페이지 -->
        <article >
          <form class="was-validated" action="/work/add" method="post" enctype="multipart/form-data">
              <div class="mb-3">
                <label for="title" class="form-label">Title</label>
                <textarea class="form-control" name="title" id="title" placeholder="Required example textarea" required>${blog.title}</textarea>
                <div class="invalid-feedback">
                  Please enter a message in the textarea.
                </div>
              </div>
            <div class="mb-3" >
              <label for="content" class="form-label" >Textarea</label>
              <textarea style="min-height:15rem" name="content" class="form-control" id="content" placeholder="Required example textarea" required>${blog.content}</textarea>
              <div class="invalid-feedback">
                Please enter a message in the textarea.
              </div>
            </div>

            <div class="mb-3">
              <p>${blog.category}</p>
              <div class="invalid-feedback">Example invalid select feedback</div>
            </div>


            <div class="mb-3">

            <p id="img-name">${blog.fileName}</p>
            <img id="blog-img" src="/assets/img/work/${blog.fileName}" style="max-width:50%;">
              <div class="invalid-feedback">Example invalid form file feedback</div>
            </div>

            <div class="mb-3 mt-5 text-end">
              <button class="btn btn-primary " type="submit" >Submit form</button>
            </div>
          </form>
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