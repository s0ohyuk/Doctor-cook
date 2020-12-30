<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ModifyPwd</title>
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

.complete {
	background-color: #FF6F61;
	color: white;
	border-radius: 5px;
	border: 0;
	padding: 10px 172px;
}
p {
	text-align: center;
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
        	<h5><span>비밀번호 변경</span> 페이지입니다.</h5>
        <hr />
        <form action="login.do" method="post">
            <input type="password" placeholder="새 비밀번호" name="mem_pass" required style="height:30px; width: 380px" /><br />
            <input type="password" placeholder="비밀번호 확인" name="mem_pass" required style="height:30px; width: 380px" /><br />
            <p><a herf="LogIn.jsp"><input type="submit" value="완료" class="complete" /></a></p>
        </form>
        <hr />
    </div>
    <jsp:include page="/WEB-INF/view/footer.jsp" />
</body>
</html>