

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

import beans.SinhVien;
import connection.sqlConnection;

/**
 * Servlet implementation class processing_update_servlet
 */
public class processing_update_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public processing_update_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idSinhVien = request.getParameter("idSinhVien");
		String tenSinhVien = request.getParameter("tenSinhVien");
		float dtb = Float.parseFloat(request.getParameter("dtb"));
		int idKhoa = Integer.parseInt(request.getParameter("idKhoa"));
		String destination ="";
		Connection connection = sqlConnection.getConnection();
		String sqlcmd = "Update SinhVien set tenSinhVien = ?, dtb = ?, idKhoa = ? where idSinhVien = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlcmd);
			preparedStatement.setString(4, idSinhVien);
			preparedStatement.setString(1, tenSinhVien);
			preparedStatement.setFloat(2, dtb);
			preparedStatement.setInt(3, idKhoa);
			preparedStatement.executeUpdate();
			destination = "DanhSachSinhVien.jsp";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
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
