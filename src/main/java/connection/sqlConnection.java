package connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class sqlConnection {
	public static Connection getConnection()  {
		String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://MEOWWW\\DAT:1305";
		String dbName = "SinhVien1";
		String dbUsername = "sa";
		String dbPassword = "123";
		String connectionURL = dbURL + ";databaseName=" + dbName +";trustServerCertificate=true";
		Connection conn = null;
		
		try {
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(connectionURL, dbUsername, dbPassword);
			System.out.println("connect successfully!");
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			System.out.println(connectionURL);
			System.out.println("Lỗi không tìm thấy Driver!");
		}
		return conn;
	}
	
}