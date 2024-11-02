package beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.sqlConnection;

public class Khoa implements Serializable{
	private int idKhoa;
	private String tenKhoa;
	
	public Khoa() {
		// TODO Auto-generated constructor stub
	}
	
	public Khoa(int idKhoa, String tenKhoa)
	{
		this.idKhoa = idKhoa;
		this.tenKhoa = tenKhoa;
	}
	
	public String getTenKhoa() {
		return tenKhoa;
	}
	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}
	public int getIdKhoa() {
		return idKhoa;
	}
	public void setIdKhoa(int idKhoa) {
		this.idKhoa = idKhoa;
	}
	/**
	 * isExist sẽ kiểm tra tên khoa hiện tại xem có tồn tại trong CSDL không
	 * @return trả về true false
	 */
	public boolean isExist()
	{
		Connection connection = sqlConnection.getConnection();
		String sqlcmd = "Select * from Khoa where tenKhoa = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlcmd);
			preparedStatement.setString(1, this.tenKhoa);
			ResultSet rowAffected = preparedStatement.executeQuery();
			if (rowAffected.next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
