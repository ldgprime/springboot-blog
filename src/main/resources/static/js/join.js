/**
 * 회원가입 로직 <script> 테그는 필요없다.
 */

//리스너-----------------------//핸들러------ function내용 	
	$('#join--submit').on('click',function(){
		var data = {
			username:$('#username').val(),
			password:$('#password').val(),
			email:$('#email').val()
		}

		//함수를 호출할 때 . $==JQuery
		$.ajax({
			//GET 쿼리스트링만 formdata 이런형식 username=ssar&password=1234&email=ssar%40nate.com
			type:'POST',
			url:'/user/join',
			data:JSON.stringify(data),
			contentType:'application/json; chartset=utf-8',
			dataType:'json'					
		}).done(function(r){
			if(r.statusCode == 200){
				alert('회원가입 성공');
				location.href = '/user/login';
			}else{
				if(r.msg == '아이디중복'){
					alert('아이디가 중복되었습니다.')
				}
				alert('회원가입 실패');
			}
		}).fail(function(r){
			alert('회원가입 실패');
		})
		
	})
