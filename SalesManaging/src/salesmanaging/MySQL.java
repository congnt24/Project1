package salesmanaging;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

import javax.naming.spi.DirStateFactory.Result;


public class MySQL {
	Connection conn;
	Date date=new Date(new java.util.Date().getTime());
	public boolean connect(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project1?user=root");
			if (conn!=null) {
				System.out.println("Connection Successfully");
				return true;
			}else {
				System.out.println("Connection failed!!!");
				return false;
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Class.forName Error!!!!");
			return false;
		} catch (SQLException e) {
			System.out.println("SQL Connection Error!!!!");
			return false;
		}
	}
	public void close(){
		try {
			if (!conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Object[][] getHangHoa(){
		Object[][] objHangHoa=new Object[100][4];
		String sql="select * from hang_hoa inner join nhacungcap  on hang_hoa.idnhacungcap = nhacungcap.idnhacungcap;";
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			int i=0;
			while (rs.next()) {
				objHangHoa[i][0]=rs.getInt("mahanghoa");
				objHangHoa[i][1]=rs.getString("tenhanghoa");
				objHangHoa[i][2]=rs.getInt("gia");
				objHangHoa[i][3]=rs.getString("tennhacungcap");
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objHangHoa;
	}
	public Object[][] getKhachHang(){
		Object[][] objHangHoa=new Object[100][3];
		String sql="SELECT * FROM project1.khachhang;";
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			int i=0;
			while (rs.next()) {
				objHangHoa[i][0]=rs.getInt("id");
				objHangHoa[i][1]=rs.getString("ten");
				objHangHoa[i][2]=rs.getString("address");
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objHangHoa;
	}
	public Object[][] getNhaCungCap(){
		Object[][] objHangHoa=new Object[100][2];
		String sql="SELECT * FROM project1.nhacungcap;";
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			int i=0;
			while (rs.next()) {
				objHangHoa[i][0]=rs.getInt("idnhacungcap");
				objHangHoa[i][1]=rs.getString("tennhacungcap");
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objHangHoa;
	}
	public Object[][] getKho(){
		Object[][] objHangHoa=new Object[100][6];
		String sql="SELECT * FROM kho inner join hang_hoa on"
				+ " kho.mahanghoa=hang_hoa.mahanghoa inner join nhacungcap"
				+ " on hang_hoa.idnhacungcap=nhacungcap.idnhacungcap;";
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			int i=0;
			while (rs.next()) {
				objHangHoa[i][0]=rs.getInt("maxuatnhap");
				objHangHoa[i][1]=rs.getInt("soluong");
				objHangHoa[i][2]=rs.getInt("ngaycapnhat");
				objHangHoa[i][3]=rs.getString("tenhanghoa");
				objHangHoa[i][4]=rs.getInt("gia");
				objHangHoa[i][5]=rs.getString("tennhacungcap");
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objHangHoa;
	}
	
	public void insertHangHoa(String name, String gia,
			String soluong, String nhacungcap, String datra) {
		int soLuong=Integer.parseInt(soluong);
		int mahanghoa = 0;
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM nhacungcap WHERE tennhacungcap = \""+nhacungcap+"\";");
			
			if(!rs.next()){//Neu rs null
				st.execute("INSERT INTO nhacungcap (tennhacungcap) VALUES (\""+nhacungcap+"\");");//Insert to nhacungcap
			}
			rs=st.executeQuery("SELECT * FROM nhacungcap WHERE tennhacungcap = \""+nhacungcap+"\";");
			rs.next();
			int id2=rs.getInt("idnhacungcap");
			rs=st.executeQuery("SELECT * FROM hang_hoa WHERE tenhanghoa = \""+name+"\";");
			if (!rs.next()) {
				//Insert vao table hang_hoa	
				st.execute("INSERT INTO hang_hoa (tenhanghoa, gia, idnhacungcap ) VALUES (\""+name+"\", "+Integer.parseInt(gia)+", "+id2+");");
				rs=st.executeQuery("SELECT * FROM hang_hoa WHERE tenhanghoa = \""+name+"\";");
				rs.next();
				mahanghoa=rs.getInt("mahanghoa");
				st.execute("INSERT INTO kho (soluong, ngaycapnhat, mahanghoa) VALUES ("+Integer.parseInt(soluong)+", 2014, "+mahanghoa+")");
			}else {//Update to kho
				mahanghoa=rs.getInt("mahanghoa");
				rs=st.executeQuery("SELECT * FROM kho WHERE mahanghoa="+mahanghoa+";");
				rs.next();
				st.execute("UPDATE kho SET soluong="+(soLuong+rs.getInt("suluong"))+" WHERE mahanghoa="+mahanghoa+";");
			}
			
			st.execute("INSERT INTO hoadonnhap (ngaytra, tongsotien, datra, soluong, mahanghoa) VALUES (\""+date.toString()+"\", "+(soLuong*Integer.parseInt(gia))+", "+Integer.parseInt(datra)+", "+soLuong+", "+mahanghoa+");");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	public String[] getComboboxNhaCungCap() {
		StringBuilder sb=new StringBuilder();
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM nhacungcap;");
			while (rs.next()) {
				sb.append(rs.getString("tennhacungcap")+",");
			}
			sb.append("Other");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb.toString().split(",");
	}
	public ArrayList<String> getTenHangHoa() {
		ArrayList<String> list=new ArrayList<String>();
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM hang_hoa;");
			while (rs.next()) {
				list.add(rs.getString("tenhanghoa"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
