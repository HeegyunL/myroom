<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<!-- header start-->
<jsp:include page="../common/header.jsp" />
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
                <textarea class="form-control" name="title" id="title" placeholder="Required example textarea" required></textarea>
                <div class="invalid-feedback">
                  Please enter a message in the textarea.
                </div>
              </div>
            <div class="mb-3" >
              <label for="content" class="form-label" >Textarea</label>
              <textarea style="min-height:15rem" name="content" class="form-control" id="content" placeholder="Required example textarea" required></textarea>
              <div class="invalid-feedback">
                Please enter a message in the textarea.
              </div>
            </div>

            <div class="mb-3">
              <select class="form-select" required aria-label="select example" name="category">
                <option value="">종류를 선택해주세요.</option>
                <option value="bandai">Bandai</option>
                <option value="lego">Lego</option>
              </select>
              <div class="invalid-feedback">Example invalid select feedback</div>
            </div>

<!--
            <div class="mb-3">
            <input type="text" name="fileName" class="form-control" aria-label="file example" required>
              <input type="file" name="file" class="form-control" aria-label="file example" required>
              <div class="invalid-feedback">Example invalid form file feedback</div>
            </div>
-->
            <div class="mb-3 mt-5 text-end">
              <button class="btn btn-primary " type="submit" >Submit form</button>
            </div>
          </form>
        </article>
        <!-- 작성 끝 -->
    </section>
</div>

<!-- footer start-->
<jsp:include page="../common/footer.jsp" />
<!-- footer end-->
</body>
</html>