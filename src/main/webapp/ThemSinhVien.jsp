<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function validateInput() {
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
	<h1>Nhập sinh viên</h1>
	<form action="processing_add_servlet" onsubmit="return validateInput();">
		<div class="container" style="display: block; margin: 4px;">
			<label>Tên sinh viên: </label>
			<input type = "text" name = "tenSinhVien">
		</div>
		<div class="container" style="display: block; margin: 4px;">
			<label>Điểm trung bình: </label>
			<input type = "number" name = "dtb">
		</div>
		<div class="container" style="display: block; margin: 4px;">
			<label>ID Khoa: </label>
			<input type = "number" name = "idKhoa">
		</div>
		<button type="submit" style="margin: 4px;">
			Xác nhận
		</button>
	</form>
</body>
</html>