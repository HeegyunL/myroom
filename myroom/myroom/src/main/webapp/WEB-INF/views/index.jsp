<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

<link href="/assets/css/main.css" rel="stylesheet">
</head>
<body >

<div class="contain">
    <jsp:include page="./common/header.jsp" />

    <section class="main-frame">
        <article class="">
            <textarea class="w-100" placeholder="memo" ></textarea>
        </article>
        <article class="w-100">
           <div class="d-flex justify-content-between text-center">
                <div class="">
                    <img src="/assets/img/work/1.jpeg">
                    <p>123</p>
                </div>
                <div class="">
                  <img src="/assets/img/work/1.jpeg">
                  <p>123</p>
                </div>
                <div class="">
                <img src="/assets/img/work/1.jpeg">
                  <p>123</p>
                </div>
           </div>
        </article>
        <article class="d-flex justify-content-between text-center">
            <div>
                인기리스트
            </div>
            <div>
                기사
            </div>
        </article>
    </section>
    <jsp:include page="./common/footer.jsp" />
</div>
</body>
</html>