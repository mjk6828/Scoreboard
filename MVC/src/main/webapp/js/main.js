

function SearchFunction(){
	
	console.log('검색실행');
	
	$.ajax({
		url: "./boardsearch.do",
		type: "get",
		dataType:"json",
		contentType: "application/json",
		success : function(data){
		/*	var result = JSON.parse(data);*/
			console.log(data);
			
			var html = "";
			for(var j=0; j<item.length; j++){
				var item = data[i];
				html += '<tr>';
				html += '<td>'+item.num+'</td><td>'+item.writer+'</td>'+'<td>'+item.subject+'</td>';
				html +='</tr>';
			}
			$("#list").append(html); 
		},
		error:function(xhr,status,error){
			alert(error);
		}
		
		
	});
};