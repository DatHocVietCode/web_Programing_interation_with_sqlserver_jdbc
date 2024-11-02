

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.sqlConnection;

/**
 * Servlet implementation class chinh_sua_thong_tin_servlet
 */
public class chinh_sua_thong_tin_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chinh_sua_thong_tin_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private void Delete(int idSinhVien) {
		Connection conn = sqlConnection.getConnection();
		String sqlcmd = "Delete from SinhVien where idSinhVien = ?";
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sqlcmd);
			preparedStatement.setString(1, String.valueOf(idSinhVien));
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String destination = "";
		if ("delete".equals(action))
		{
			System.out.println("Xóa");
			Delete(Integer.valueOf(request.getParameter("idSinhVien")));
			destination = "DanhSachSinhVien.jsp";
		}
		else {
			System.out.println("Sửa");
			destination = "ChinhSuaSinhVien.jsp";
			HttpSession session = request.getSession();
			String idSinhVien = request.getParameter("idSinhVien");
			session.setAttribute("idSinhVien", idSinhVien);
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
