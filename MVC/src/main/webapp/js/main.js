

function SearchFunction(){
	
	console.log('검색실행');
	
	$.ajax({
		url: "./search.do",
		type: "GET",
		datatype: "text",
		success : function(data){
			console.log('성공');
			console.log(data);
		},
		error:function(xhr,status,error){
			alert(error);
		}
		
		
	});
};