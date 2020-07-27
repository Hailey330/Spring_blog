let index = {		
		init: function(){
			// 리스너 등록 
			$("#btn-save").on("click", ()=>{
				this.save();
			});
			
			$("#btn-delete").on("click", ()=>{
				this.deletePost();
			});

			$("#btn-update-mode").on("click", ()=>{
				this.updateMode();
			});

			$("#btn-update").on("click", ()=>{
				this.update();
			});
			
			$("#btn-update").hide();
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
		
		deletePost: function(){
			let data = {
					id: $("#id").val()
			};
			$.ajax({
				type: "DELETE",
				url: "/post/" + data.id,
				dataType: "json"
			}).done(function(resp){
				alert("삭제 성공");
				location.href="/";
			}).fail(function(error){
				alert("삭제 실패")
				console.log(error);
			})
		},

		updateMode: function(){
			$("#btn-update-mode").hide();
			$("#btn-update").show();
			
			$("#title").attr("readOnly", false);
			$("#content").attr("readOnly", false);
		},
		
		update: function(){
			let data = {
					id: $("#id").val(),
					title: $("#title").val(),
					content: $("#content").val()
			}
			
			$.ajax({
				type: "PUT",
				url: "/post/" + data.id,
				data: JSON.stringify(data), 
				contentType: "application/json; charset=utf-8",
				dataType: "json"
			}).done(function(resp){
				alert("수정하기 성공");
				location.href="/post/" + data.id;
			}).fail(function(error){
				alert("수정하기 실패")
				console.log(error);
			})
		}
}

index.init();