

function SearchFunction(){
	
	console.log('검색실행');
	var cinema = $('#cinema').val();
	var location = $('#location').val();
	var theater = $('#theater').val();
	var division = $('#division').val();
	var film = $('#film').val();
	$.ajax({
		url: "./boardsearch.do",
		type: "get",
		data: "cinema="+cinema+"&location="+location+"&theater="+theater+"&division="+division+"&film="+film,
		dataType:"json",
		contentType: "application/json",
		success : function(data){
		/*	var result = JSON.parse(data);*/
			console.log(data.result);
			console.log(data.count);
			var items = data.result;
			var html = "";
				html += '<thead>';
				html += '<tr><th>번호</th><th>제목</th><th>작성자</th></tr>';
				html += '</thead>';
				html += '<tbody>';
			for(var i=0; i<items.length; i++){
				var item = items[i];
				html += '<tr>';
				html += '<td>'+item.num+'</td><td>'+item.subject+'</td>'+'<td>'+item.writer+'</td>';
				html +='</tr>';
			}
				html += '</tbody>';
			$("#list").append(html); 
		},
		error:function(xhr,status,error){
			alert(error);
		}
		
		
	});
};

$(document).ready(function(){
	$('#file').change(function(){
		alert('엑셀 start');
		var form = $('#excelForm')[0];
		var data = new FormData(form);
		
		$.ajax({
			enctype:"multipart/form-data",
			method:"post",
			url:"./excelUpload.do",
			processData:false,
			cache:false,
			data:data,
			success:function(result){
				alert('업로드 성공');
			}
		});
		
	});
});