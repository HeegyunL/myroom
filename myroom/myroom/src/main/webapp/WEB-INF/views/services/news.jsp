<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="/assets/css/news.css" rel="stylesheet">
</head>
<body>
<!-- header start-->
<jsp:include page="../common/header.jsp" />
<!-- header end-->

<div class="bg-light">
    <section class=" container frame-bg ">
        <article class="pt-5 pb-5">
            <h1>news</h1>
        </article>

        <article>
            <div class="container">
                <ul style="list-style:none;">
                    <li class="mb-3">
                        <div id="news-card-frame" class=" d-flex" style="">
                            <div id="news-card-image" style="width:25%;background-image:url('../../../assets/img/건담1.jpeg'); ba" class=" bg-secondary"></div>
                            <div style="width:75%;" class="p-3">
                                <p>안녕하세요</p>
                                <p>2027년을 기준으로 새로운 건담이 출시됩니다. </p>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div id="news-card-frame" class=" d-flex" style="">
                            <div id="news-card-image" style="width:25%;background-image:url('../../../assets/img/건담2.jpeg'); ba" class=" bg-secondary"></div>
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
<jsp:include page="../common/footer.jsp" />
<!-- footer end-->
</body>
</html>