<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CompleteSignUp</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <style>
.wrap {
	width: 385px;
	line-height: 50px;
	margin: 40px auto;
	text-align: center;
}

h5 {
	text-align: center;
}

h5 span {
	color: #FF6F61;
}

.caca {
	background-color: #FF6F61;
	color: white;
	border-radius: 5px;
	border: 0;
	padding: 10px 172px;
	white-space:nowrap;
	text-decoration:none;
	font-size:13px;
}

input {
	border: 1px solid lightgray;
	border-radius: 3px;
}
</style>
</head>

<body>
<jsp:include page="/WEB-INF/view/header.jsp" />		
	<div class="wrap">
        	<h5><span>회원가입</span>이 완료되었습니다.</h5>
        <hr />
            <a href="SignIn.do" class="caca">로그인</a><br />
            <a href="home.do" class="caca">HOME</a>
        <hr />
    </div>
    	<jsp:include page="/WEB-INF/view/footer.jsp" />
</body>
</html>