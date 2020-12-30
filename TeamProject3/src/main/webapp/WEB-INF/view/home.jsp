<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
	integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/home.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp" />
	<div class="container">
	<!-- carousel 시작 -->
		<div class="row">
			<div class="col-md-12">
				<div id="carouselExampleIndicators" class="carousel slide"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="img/b1.jpg" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="img/b2.jpg" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="img/b3.jpg" class="d-block w-100" alt="...">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</div>
		<!-- carousel 종료 클래스 시작 -->
		<div class="container bootstrap snippets bootdey">
    <h1 class="text-left">클래스</h1>
    <hr class="divider-title">
    <div class="row">
    <c:forEach var="clcl" items="${cl}">
    <div class="col-ms-10 col-md-4">
        <div class="project">
            <figure class="img-responsive">
                <img src="img/${clcl.class_img}.jpg" width="400" height="300">
                <figcaption>
                    <span class="project-details">${clcl.class_name}</span>
                    <span class="project-price"><strong><fmt:formatNumber type="number" maxFractionDigits="3" value="${clcl.class_price}" /></strong></span>
                    <span class="project-creator">${clcl.class_intro}</span>
                </figcaption>
                <span class="actions">
                        <button class="btn btn-warning bnt-action" type="submit" onClick="location.href='class_watch.do?class_num=${clcl.class_num}'">자세히 보기 </button>
                </span>
            </figure>
        </div>
    </div>
    </c:forEach>
    </div>
</div>  
<!-- 클래스 종료 선생님 시작 --> 
<div class="container bootstrap snippets bootdey">
    <h1 class="text-left">선생님</h1>
    <hr class="divider-title">
    <div class="row">
    <c:forEach var="tltl" items="${tl}">
    <div class="col-ms-10 col-md-4">
        <div class="project">
            <figure class="img-responsive">
                <img src="img/${tltl.teach_img}.jpg" width="400" height="300">
                <figcaption>
                    <span class="project-details">${tltl.teach_name}</span>
                    <span class="project-creator">${tltl.teach_intro}</span>
                </figcaption>
                <span class="actions">
                        <button class="btn btn-warning bnt-action" type="submit">자세히 보기 </button>
                </span>
            </figure>
        </div>
    </div>
    </c:forEach>
    </div>
</div>  
<!-- 선생님 종료 --> 
	</div>
	<jsp:include page="/WEB-INF/view/footer.jsp" />
</body>
</html>