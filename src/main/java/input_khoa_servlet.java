
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.tomcat.jakartaee.commons.lang3.ObjectUtils.Null;

import beans.Khoa;
import connection.sqlConnection;

/**
 * Servlet implementation class input_khoa_servlet
 */
public class input_khoa_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public input_khoa_servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  String destiString = "";
		  String tenKhoa = request.getParameter("txt_ten_khoa");
		  System.out.println(tenKhoa); 
		  try { Connection conn = sqlConnection.getConnection();
		  		Khoa khoa = new Khoa();
		  		khoa.setTenKhoa(tenKhoa);
		  		boolean isExist = khoa.isExist();
		  		if (!isExist) {
		  			String sqlcmd = "Insert into Khoa (tenkhoa) values (?)";
			  		PreparedStatement pStatement = conn.prepareStatement(sqlcmd);
			  		pStatement.setString(1, tenKhoa);
			  		int rowInsert = pStatement.executeUpdate();		  
				}
		  		destiString = "DanhSachMonHoc.jsp";
		 } 
		 catch (Exception e) 
		 { 
			 // TODO: handle exception 
			 e.printStackTrace();
		 }
		 finally {
			 RequestDispatcher requestDispatcher = request.getRequestDispatcher(destiString);
		  	 requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
