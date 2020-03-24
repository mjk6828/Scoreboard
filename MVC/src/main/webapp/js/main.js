

function SearchFunction(){
	
	console.log('검색실행');
	
	$.ajax({
		url: "./search.do",
		type: "post",
		contentType: "application/json; charset=utf-8;",
		dataType:"json",
		success : function(data){
			console.log('성공'+data);
		},
		error:function(xhr,status,error){
			alert(error);
		}
		
		
	});
};