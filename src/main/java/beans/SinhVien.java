package beans;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.sqlConnection;

public class SinhVien implements Serializable{
	private int idSinhVien;
	private String tenSinhVien;
	private float dtb;
	private int maKhoa;
	private String tenKhoa;
	
	public SinhVien() {
		// TODO Auto-generated constructor stub
	}
	
	public SinhVien(int idSinhVien, String tenSinhVien, float dtb, int maKhoa, String tenKhoa)
	{
		this.idSinhVien = idSinhVien;
		this.maKhoa = maKhoa;
		this.dtb = dtb;
		this.tenSinhVien = tenSinhVien;
		this.tenKhoa = tenKhoa;
	}
	
	public int getMaKhoa() {
		return maKhoa;
	}
	public void setMaKhoa(int maKhoa) {
		this.maKhoa = maKhoa;
	}
	public float getDtb() {
		return dtb;
	}
	public void setDtb(float dtb) {
		this.dtb = dtb;
	}
	public String getTenSinhVien() {
		return tenSinhVien;
	}
	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}
	public int getIdSinhVien() {
		return idSinhVien;
	}
	public void setIdSinhVien(int idSinhVien) {
		this.idSinhVien = idSinhVien;
	}

	public String getTenKhoa() {
		return tenKhoa;
	}

	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}
	public String getXepLoai()
	{
		if (this.dtb >= 7) {
			return "Khá";
		}
		else if (this.dtb < 7 && this.dtb >= 5) {
			return "Trung bình";
		}
		else {
			return "Cần cải thiện";
		}
	}
	/**
	 * Kiểm tra xem sinh viên có tồn tại trong csdl chưa
	 * @return trả về true false
	 */
	public boolean isExist()
	{
		Connection connection = sqlConnection.getConnection();
		String sqlcmd = "Select * from SinhVien where idSinhVien = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlcmd);
			preparedStatement.setInt(1, this.idSinhVien);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
