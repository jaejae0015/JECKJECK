<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sum10</title>
</head>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#btnHello").click(function(){
			console.log("@#@#@@@@@");
			$.ajax({
				url: "/com/login.do",
				type: "get",
				async:false,
				success:function(){
					
				},
				error:function(xhr,status,error){
					
				},
				complete: function(xhr,status){
					
				}
			})
		});
	});
</script>
<body>

<% 
    int total = 0;
    for(int i = 1; i <= 10; i++){
        total = total + i;
    }
%>

1부터 10까지의 합 : <%=total %>

<button id="btnHello">hello</button>
</body>
</html>