<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>SignUp</title>
 	<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous" ></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
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
        #signup {
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
        	margin-right:196px;
        }
        .ipt2{
        	margin-right:176px;
        }
        /* 중복아이디 존재하지 않는경우 */
		.id_input_re_1{
			color : green;
			display : none;
		}
		/* 중복아이디 존재하는 경우 */
		.id_input_re_2{
			color : red;
			display : none;
		}
    </style>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp" />
    <div class="container">
        <h5><span>회원 가입</span> 페이지입니다.</h5>
        <hr /><br />
        <div class="f1">
        <form action="join.do" method="post" >
            <input type="text" placeholder="아이디" id="mem_id" name="mem_id" class="id_input" required style="height:30px; width: 200px" /> 
            <input type="button" value="ID중복확인" class="ipt1" onClick="idchecker();">
            	<span class="id_input_re_1">사용 가능한 아이디입니다.</span>
				<span class="id_input_re_2">아이디가 이미 존재합니다.</span> <br /><br />
            <input type="text" placeholder="이름" name="mem_name" required style="height:30px; width: 495px" /><br /><br />
            <input type="email" placeholder="이메일 주소" name="mem_email" required style="height:30px; width: 495px" /><br /><br />
            <input type="password" placeholder="비밀번호" name="mem_pass" required style="height:30px; width: 495px" /><br /><br />
            <input type="text" placeholder="생년월일6자리" name="mem_born" required style="height:30px; width: 495px" /><br /><br />            
            <input type="text" placeholder="우편번호" id="mem_zipcode" name="mem_zipcode" required style="height:30px; width: 200px" /> 
            <button type="button" onclick="execDaumPostcode();" class="ipt2">우편번호 찾기</button><br /><br />
            <input type="text" placeholder="주소" id="mem_addr1" name="mem_addr1" required style="height:30px; width: 495px" /><br /><br />
            <input type="text" placeholder="상세주소" id="mem_addr2" name="mem_addr2" required style="height:30px; width: 495px" /><br /><br />            
            <input type="tel" placeholder="전화번호( - 빼고 입력해주세요.)" name="mem_phone" required style="height:30px; width: 495px" /><br /><br />
            <p>
            <a href="CompleteSignUp"><input type="submit" value="가입하기" id="signup" /></a><br /><br />
            </p>
        </form>
        </div>
        <hr />
    </div>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>

	//아이디 중복검사
	$('.id_input').on("propertychange change keyup paste input", function(){

		console.log("keyup 테스트");	

	});// function 종료
</script>

<script>
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
               
                var addr = ''; 
                var extraAddr = '';

                if (data.userSelectedType === 'R') {
                    addr = data.roadAddress;
                } else {
                    addr = data.jibunAddress;
                }
                if(data.userSelectedType === 'R'){
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    document.getElementById("mem_addr2").value = extraAddr;
                
                } else {
                    document.getElementById("mem_addr2").value = '';
                }

                document.getElementById('mem_zipcode').value = data.zonecode;
                document.getElementById("mem_addr1").value = addr;
                document.getElementById("mem_addr2").focus();
            }
        }).open();
    }
	
</script>
	<jsp:include page="/WEB-INF/view/footer.jsp" />
</body>
</html>