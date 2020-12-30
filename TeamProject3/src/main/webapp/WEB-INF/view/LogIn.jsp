<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>LogIn</title>
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

.login {
	background-color: #FF6F61;
	color: white;
	border-radius: 5px;
	border: 0;
	padding: 3px 160px;
}

#signup {
	background-color: white;
	color: #FF6F61;
	border: 0;
	font-size: 17px;
}
#findPwd {
	background-color: white;
	color: #FF6F61;
	border: 0;
	font-size: 17px;
}

p {
	text-align: center;
}

input {
	border: 1px solid lightgray;
	border-radius: 3px;
}
a {
	color:#FF6F61;
	text-decoration:none;
}
</style>
</head>

<body>
	<jsp:include page="/WEB-INF/view/header.jsp" />	
	<div class="wrap">
        	</a><h5><span>로그인</span> 페이지입니다.</h5>
        <hr />
         <form action="LogIn.do" method="post">
            <input type="text" placeholder="아이디" maxlength="20" name="mem_id" required style="height:30px; width: 380px" /><br />
            <input type="password" placeholder="비밀번호" name="mem_pass" required style="height:30px; width: 380px" /><br />
            <input type="submit" value="로그인" class="login" />
        </form>
        <hr />       
        	<a href="agreeSignUp.do">회원가입</a> &nbsp;&nbsp; <a href="FindPwd.jsp">비밀번호찾기</a>
    </div>
	<jsp:include page="/WEB-INF/view/footer.jsp" />
</body>
</html>