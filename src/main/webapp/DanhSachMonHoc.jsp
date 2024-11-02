<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
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
<h1>Danh sách môn học</h1>
<% 
    try (Connection conn = sqlConnection.getConnection()) {
        String sqlcmd = "SELECT * FROM Khoa";
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sqlcmd);
%>
    <!-- Tạo bảng HTML để hiển thị dữ liệu -->
    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>Tên Khoa</th>
        </tr>

    <%
        // Duyệt qua từng dòng dữ liệu và hiển thị ra bảng HTML
        while (rs.next()) {
    %>
        <tr>
            <td><%= rs.getInt("idKhoa") %></td>
            <td><%= rs.getString("tenKhoa") %></td>
        </tr>
    <%
        } // Kết thúc vòng lặp while
    %>
    </table> <!-- Đóng bảng HTML -->

<%
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

</body>
</html>