<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
</head>
<body onload="load();">
<table id="table" border=1>
<tr><th>name</th> <th><balance></balance></th><th>Edit</th><th>delete</th>
</table>
<script type="text/javascript">
load=function(){
$.ajax({
	url:'list' ,
	type='POST',
	success:function(response)
	{
		data=response.data;
		$('.tr').remove();
		for(i=0;i<response.data.length;i++)
			{
			$("#Table").append("<tr class='tr'> <td>"+response.data[i].name+"</td><td>"+response.data[i].balance+"</td><td>"+edit+"</td><td>"+deletee+"</td><tr>");
			}
		
	}
	
}
		);
}
</script>


</body>
</html>