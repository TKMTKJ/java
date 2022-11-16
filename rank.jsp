<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>랭킹</title>
	</head>
	<body>
		<h1>닉네임,토탈 kg</h1>
		<%
			Connection conn=null;
			Statement stmt=null;
			ResultSet rs=null;
			
			
			String url="jdbc:mysql://127.0.0.1:3306/game";
			String db_id="root";
			String db_pw="iotiot";
			
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn=DriverManager.getConnection(url,db_id,db_pw);
				stmt=conn.createStatement();
				String sql="select * from user;";
				rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				String num=rs.getString("num");
				String id=rs.getString("id");
				String kg=rs.getString("kg");
						
			}
			}catch(Exception e)
			{
				out.print("<h1>sql 문중 DB접속중 오류발생 :"+e+"</h1>");
			}finally
			{
				try{
					
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
				}catch(Exception ex)
				{
					out.print("<h1>sql DB종료중 오류발생:"+ex+"</h1>");
				}
			}
		%>	
	</body>
</html>