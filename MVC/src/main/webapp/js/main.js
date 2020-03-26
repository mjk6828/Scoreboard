

function SearchFunction(){
	
	console.log('검색실행');
	
	$.ajax({
		url: "./search.do",
		type: "post",
		dataType:"json",
		contentType: "application/json",
		success : function(data){
		/*	var result = JSON.parse(data);*/
			console.log('성공'+data);
			console.log(data.length);
			
			
			var html = "";
			for(var j=0; j<item.length; j++){
				html += '<tr>';
				html += '<td>'+item.name+'</td><td>'+item.email+'</td>';
				html +='</tr>';
			}
			$("#list").append(html); 
		},
		error:function(xhr,status,error){
			alert(error);
		}
		
		
	});
};