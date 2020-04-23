

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

/*function excelupload(){
		console.log('excelupload')
		var form = $('#excelForm')[0];
		var data = new FormData(form);
		
		data.append("fileObj",$('#excelFile')[0].files[0]);
		console.log(data);
		$.ajax({
			enctype:"multipart/form-data",
			method:"post",
			url:"./ExcelUpload.do",
			processData:false,
			cache:false,
			data:data,
			dataType:"json",
			contentType: "application/json",
			success:function(result){
				alert('업로드 성공');
			},
			error: function(xhr,status,error){
				alert(error);
			}
		});
}*/

$(function(){
	$('#excelup').click(function(){
		var formData = new FormData();
		formData.append("excelFile",$('input[name=excelFile]')[0].files[0]);
		
		$.ajax({
			url : "./ExcelUpload.do",
			data : formData,
			processData : false,
			contentType : false,
			dataType : "json",
			type : "POST",
			success : function(data){
				console.log('업로드성공');
				var table = document.getElementById("table");
				table.innerHTML = "";
				for(var i=0; i<data.length; i++){
					var item = data[i];
					console.log(data.length);
					console.log(item)
					console.log(item.length);
					var dataa = JSON.stringify(data);
					var row = table.insertRow(0);
						for(var j=0; j<data[i].length; j++){
							
							var cell = row.insertCell(j);
							cell.innerHTML = dataa[i][j].value;
						}
				}
			},error : function(xhr, status, error){
				console.log(error);
			}
		});
	});
});

