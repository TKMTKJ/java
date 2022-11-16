<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>교육용 낚시 게임</title>
		<style>

			#wrap{
				border:10px solid black;	
				width:520px;
				margin : 50px auto;
			}
			
			
		</style>
	</head>
	<body>
		<div id= "wrap" >
			<form method="post" action="start.jsp">
				<img background-image : src="img/angler.jpg" style="width:520px;height:532px;">
				<h1 style="margin-left : 130px;">교육용 낚시 게임</h1>
				<a href=rank.jsp style = "margin :220px; ">랭킹 보기</a><br>
				<input type="text" name="id" style = "margin : 15px auto; margin-left : 165px;"><br>
				<input type="submit" value="게임 시작!" style ="margin : 20px auto; margin-left : 210px">
			</form>
		</div>
	</body>
</html>	