<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
function validateForm() {
    var tenKhoa = document.forms["input_khoa"]["txt_ten_khoa"].value;
    if (tenKhoa === "") {
        alert("Vui lòng điền đầy đủ thông tin.");
        return false; 
    }
    return true; 
}
</script>
</head>
<body>
	<form action = "input_khoa_servlet" method="post" name = "input_khoa" onsubmit="return validateForm()">
		<label>Nhap ten khoa</label>
		<input type = "text" name="txt_ten_khoa"> <br>
		<input type = "submit" />
	</form>
</body>
</html>