let index = {		
		init: function(){
			// 리스너 등록 
			$("#btn-save").on("click", ()=>{
				this.save();
			});
		},
		
		save: function(){
			let data = {
					title: $("#title").val(),
					content: $("#content").val(),
					userId: $("#userId").val()
			};
			$.ajax({
				type: "POST",
				url: "/post",
				data: JSON.stringify(data), 
				contentType: "application/json; charset=utf-8",
				dataType: "json"
			}).done(function(resp){
				alert("글쓰기 성공");
				location.href="/";
			}).fail(function(error){
				alert("글쓰기 실패")
				console.log(error);
			})
		},
}

index.init();