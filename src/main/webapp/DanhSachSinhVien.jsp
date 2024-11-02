<%@page import="java.sql.PreparedStatement"%>
<%@page import="beans.SinhVien"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="connection.sqlConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Danh sách sinh viên</h1>
	<table border="1" cellpadding = "5" cellspacing = "5">
					<tr>
						<th>ID Sinh viên</th>
						<th>Tên sinh viên</th>
						<th>Tên khoa</th>
						<th>Điểm trung bình</th>
						<th>Xếp loại</th>
						<th>Xóa</th>
						<th>Sửa</th>
					</tr>
					
			
	<%
		Connection conn = sqlConnection.getConnection();
		String sqlcmd = "Select * from SinhVien order by idSinhVien";
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(sqlcmd);
		while (rs.next())
		{
			SinhVien sv = new SinhVien();
			sv.setIdSinhVien(rs.getInt("idSinhVien"));
			sv.setDtb(rs.getFloat("dtb"));
			sv.setTenSinhVien(rs.getString("tenSinhVien"));
			sv.setMaKhoa(rs.getInt("idKhoa"));
			String tenkhoa = "";
			sqlcmd = "Select tenKhoa from Khoa where idKhoa = ?";
			PreparedStatement pStatement = conn.prepareStatement(sqlcmd);
			pStatement.setString(1, String.valueOf(sv.getMaKhoa()));
			ResultSet temp_rs = pStatement.executeQuery();
			while (temp_rs.next())
				tenkhoa = temp_rs.getNString("tenKhoa");
			sv.setTenKhoa(tenkhoa);
			%>
				<tr>
				<form action="chinh_sua_thong_tin_servlet" method="post" name = "record">		
					<td><%= sv.getIdSinhVien() %></td>
					 <input type="hidden" name="idSinhVien" value="<%= sv.getIdSinhVien() %>">
					<td><%= sv.getTenSinhVien() %></td>
					<td><%= sv.getTenKhoa() %></td>
					<td><%= sv.getDtb() %></td>
					<td><%= sv.getXepLoai() %></td>
					<td>
						<button type = "submit" name = "action" value="delete">
							Xóa
						</button>
					</td>
					<td>
						<button type = "submit" name = "action" value="modify">
							Sửa
						</button>
					</td>
				</form>
					
				</tr>
				
			<%
		}
		
	%>
		</table>
		<form action="them_sinh_vien_servlet" method = "post">
			<button type = "submit" name="btn_add" value="add" style="margin-top: 20px;">Thêm sinh viên</button>
		</form>
</body>
</html>