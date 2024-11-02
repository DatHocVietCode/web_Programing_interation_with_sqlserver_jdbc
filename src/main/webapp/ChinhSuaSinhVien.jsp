<%@page import="beans.SinhVien"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="connection.sqlConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function validateInput() {
		var idSinhVien = document.forms["inputSinhVien"]["idSinhVien"].value;
		var tenSinhVien = document.forms["inputSinhVien"]["tenSinhVien"].value;
		var dtbSinhVien = document.forms["inputSinhVien"]["dtb"].value;
		var khoaSinhVien = document.forms["inputSinhVien"]["idKhoa"].value;
		if (idSinhVien === "" || tenSinhVien === "" || dtbSinhVien === "" || khoaSinhVien === "") {
			alert("Vui lòng điền đầy đủ thông tin!");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<%
		String idSinhVien = session.getAttribute("idSinhVien").toString();
		Connection connection = sqlConnection.getConnection();
		String sqlcmd = "select * from SinhVien where idSinhVien = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sqlcmd);
		preparedStatement.setString(1, idSinhVien);
		ResultSet rs = preparedStatement.executeQuery();
		SinhVien modifySinhVien = new SinhVien();
		while (rs.next())
		{
			Integer idSV = rs.getInt("idSinhVien");
			String tenSV = rs.getString("tenSinhVien");
			float dtb = rs.getFloat("dtb");
			int idKhoa = rs.getInt("idKhoa");
			modifySinhVien.setIdSinhVien(idSV);
			modifySinhVien.setTenSinhVien(tenSV);
			modifySinhVien.setDtb(dtb);
			modifySinhVien.setMaKhoa(idKhoa);
		}
	%>
	<h1>Chỉnh sửa sinh viên</h1>
	<form action="processing_update_servlet" name = "inputSinhVien" onsubmit="return validateInput();" method="post">
		<div class="container" style="display: block; margin: 4px;">
			<label>ID sinh viên: </label>
			<input type = "text" name = "idSinhVien" value="<%= modifySinhVien.getIdSinhVien() %>">
		</div>
		<div class="container" style="display: block; margin: 4px;">
			<label>Tên sinh viên: </label>
			<input type = "text" name = "tenSinhVien" value="<%= modifySinhVien.getTenSinhVien()%>">
		</div>
		<div class="container" style="display: block; margin: 4px;">
			<label>Điểm trung bình: </label>
			<input type = "number" name = "dtb" value="<%= modifySinhVien.getDtb() %>">
		</div>
		<div class="container" style="display: block; margin: 4px;">
			<label>ID Khoa: </label>
			<input type = "number" name = "idKhoa" value="<%= modifySinhVien.getMaKhoa()%>">
		</div>
		<button type="submit" style="margin: 4px;">
			Xác nhận
		</button>
	</form>
</body>
</html>