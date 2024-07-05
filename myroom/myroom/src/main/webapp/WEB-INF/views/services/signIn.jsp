<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

<div>
    <section class="container">
     <!-- title -->
        <article class="pt-5 pb-5">
            <h1>Login</h1>
        </article>

        <!-- 작성 페이지 -->
        <article >
          <form class="was-validated" action="/members/sign-in" method="post" enctype="multipart/form-data">
              <div class="mb-3">
                <label for="username" class="form-label">Title</label>
                <textarea class="form-control" name="username" id="username" placeholder="Required example textarea" required></textarea>
                <div class="invalid-feedback">
                  Please enter a message in the ID.
                </div>
              </div>
            <div class="mb-3" >
              <label for="password" class="form-label" >Textarea</label>
              <textarea style="min-height:15rem" name="password" class="form-control" id="password" placeholder="Required example textarea" required></textarea>
              <div class="invalid-feedback">
                Please enter a message in the password.
              </div>
            </div>


            <div class="mb-3 mt-5 text-end">
              <button class="btn btn-primary " type="submit" >Submit form</button>
            </div>
          </form>
        </article>
        <!-- 작성 끝 -->
    </section>
</div>
</body>
</html>