

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.sqlConnection;

/**
 * Servlet implementation class processing_add_servlet
 */
public class processing_add_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public processing_add_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenSinhVien = request.getParameter("tenSinhVien");
		String dtb = request.getParameter("dtb");
		String idKhoa = request.getParameter("idKhoa");
		Connection connection = sqlConnection.getConnection();
		String sqlcmd = "Insert into SinhVien(tenSinhVien, dtb, idKhoa) values (?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlcmd);
			preparedStatement.setString(1, tenSinhVien);
			preparedStatement.setString(2, dtb);
			preparedStatement.setString(3, idKhoa);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("DanhSachSinhVien.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
