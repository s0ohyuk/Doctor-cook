<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<style>
.container {
            width: 500px;
            margin: 40px auto;
            line-height: 16px;
            position: relative;
        }
        h5 {
            text-align: center;
        }
        h5 span {
            color: #FF6F61;
        }
        .n {
            font-size: 13px;
        }
        #modify {
            background-color:#FF6F61;
            color: white;
            border: 0;
            border-radius: 5px;
            padding: 10px 224px;
        }
        .bottom input {
            background-color: white;
            border: 0;
            color: teal;
            font-size: 16px;
        }
        input {
            border: 1px solid lightgray;
            border-radius: 3px;
        }
        .f1{
        	text-align:center;
        }
        .ipt1{
        	margin-right:290px;
        }
        .ipt2{
        	margin-right:176px;
        }

</style>
</head>

<body>
	<jsp:include page="/WEB-INF/view/header.jsp" />	
	<div class="container">						
		<h5><span>회원 정보 수정</span> 페이지입니다.</h5>		
		<hr /><br />		
			<div class="f1">
        	<form action="UpdateUser.do" method="post" >
            	<input type="text" placeholder="아이디" name="mem_id" class="ipt1" value="${member.mem_id}"  readonly="readonly" required style="height:30px; width: 200px" /><br /><br />
            	<input type="text" placeholder="이름" name="mem_name" value="${member.mem_name}" required style="height:30px; width: 495px" /><br /><br />
            	<input type="email" placeholder="이메일 주소" name="mem_email" value="${member.mem_email}" required style="height:30px; width: 495px" /><br /><br />
            	<input type="password" placeholder="비밀번호" name="mem_pass" value="${member.mem_pass}" readonly="readonly"required style="height:30px; width: 495px" /><br /><br />
            	<input type="text" name="mem_born" value="${member.mem_born}" required style="height:30px; width: 495px" /><br /><br />
            	<input type="text" placeholder="우편번호" name="mem_zipcode" value="${member.mem_zipcode}" required style="height:30px; width: 200px" /> <input type="button" value="우편번호 찾기" class="ipt2"><br /><br />
            	<input type="text" placeholder="주소" name="mem_addr1" value="${member.mem_addr1}" required style="height:30px; width: 495px" /><br /><br />
            	<input type="text" placeholder="상세주소" name="mem_addr2" value="${member.mem_addr2}" required style="height:30px; width: 495px" /><br /><br />
            	<input type="tel" placeholder="전화번호( - 빼고 입력해주세요.)" name="mem_phone" value="${member.mem_phone}" required style="height:30px; width: 495px" /><br /><br />
            <p>
            	<a href=CompleteModify><input type="submit" value="수정완료" id="modify" /></a><br /><br />
            </p>
        </form>
        </div>
		<hr />
	</div>
	<jsp:include page="/WEB-INF/view/footer.jsp" />
</body>
</html>