let index = {
		init: function(){
			//let _this = this;
			$("#btn-save").on("click", ()=>{
				this.save(); 
			});
		},
		
		save: function(){
			// ajax 요청
			let data = {
					username: $("#username").val(),
					password: $("#password").val(),
					email: $("#email").val()
			};
			// jquery or fetch
			$.ajax({
				type: "POST",
				url: "/auth/joinProc",
				data: JSON.stringify(data), 
				// javascript → json 데이터로 변경해주는 함수 
				contentType: "application/json; charset=utf-8",
				// 스프링한테 JSON 타입(contentType)임을 알려줘야 확인 후 컨버터 실행함
				dataType: "json"
				// dataType : 서버로부터 응답 받을 때 타입 지정  
			}).done(function(resp){
				if(resp.statusCode == 1) {
					alert("회원가입을 축하합니다!");
					location.href="/";
				}
				console.log(resp);
				// console.log(JSON.parse(resp)); 
				// dataType을 "text"로 설정했을 경우 : json → javascript 데이터로 변경해주는 함수 
			}).fail(function(error){
				alert("회원가입에 실패했습니다.")
				console.log(error);
			})
		}
}

index.init();