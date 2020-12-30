function idchecker(){
		var mem_id = $("#mem_id").val()
		
		if(mem_id.length == 0){
			alert('아이디를 입력해주세요')
			return
		}
		
		 $.ajax({
	       
	        type:"get",
	        url:'idcheck/'+mem_id,
	        headers: {  'Access-Control-Allow-Origin': '*' },
	    	dataType:'text',
	        success: function(res){
		console.log(res)
	          if(res.trim() == 'true'){
					alert("사용 가능한 아이디입니다.")
				}else{
					alert("사용 불가능한 아이디입니다.")
				}
	        },
	        error: function(req){
	            console.log("fail")
	        }
	    })
	}