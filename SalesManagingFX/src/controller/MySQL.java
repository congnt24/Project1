package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Customer;
import model.Producer;
import model.Sales;
import controller.QLController.QLKItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import javafx.scene.control.Label;


public class MySQL {
	Date d=new Date();
	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	Connection conn;
	static Statement st;
	Date date=new Date(new java.util.Date().getTime());
	public boolean connect(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/salemanaging?user=root");
			if (conn!=null) {
				System.out.println("Connection Successfully");
				st=conn.createStatement();
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
	
	public ObservableList<String> getHangHoaFX(ObservableList<Sales> obsList){
		obsList.removeAll(obsList);
		ObservableList<String> nameList=FXCollections.observableArrayList();
		String sql="select * from hang_hoa;";
		try {
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()) {
				obsList.add(new Sales(rs.getInt("mahanghoa"), rs.getString("tenhanghoa"), rs.getInt("gia"), rs.getString("hangsanxuat")));
				nameList.add(rs.getString("tenhanghoa"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nameList;
	}
	
	
	
	public void getNhaCungCapFX(ObservableList<Producer> list){
		list.removeAll(list);
		try {
			ResultSet rs=st.executeQuery("SELECT * FROM nhacungcap;");
			while (rs.next()) {
				list.add(new Producer(rs.getInt("idnhacungcap"), rs.getString("tennhacungcap")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void getKhoFX(ObservableList<QLKItem> list){
		String sql="SELECT * FROM kho, hang_hoa WHERE kho.mahanghoa=hang_hoa.mahanghoa ;";
		try {
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()) {
				list.add(new QLKItem(rs.getInt("mahanghoa"), rs.getInt("soluong"), rs.getInt("gia"),
						rs.getString("ngaycapnhat"), rs.getString("tenhanghoa"), rs.getString("hangsanxuat")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getHoaDonXuat(ObservableList<QLKItem> list){
		String sql="SELECT * FROM kho inner join hang_hoa on"
				+ " kho.mahanghoa=hang_hoa.mahanghoa inner join nhacungcap"
				+ " on hang_hoa.idnhacungcap=nhacungcap.idnhacungcap;";
		try {
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()) {
				list.add(new QLKItem(rs.getInt("maxuatnhap"), rs.getInt("soluong"), rs.getInt("gia"),
						rs.getString("ngaycapnhat"), rs.getString("tenhanghoa"), rs.getString("tennhacungcap")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	/*@SuppressWarnings("resource")
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
	}*/
	public ObservableList<String> getComboboxNhaCungCap() {
		ObservableList<String> list=FXCollections.observableArrayList();
		try {
			ResultSet rs=st.executeQuery("SELECT * FROM nhacungcap;");
			list.add("Other");
			while (rs.next()) {
				list.add(rs.getString("tennhacungcap"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public ObservableList<Integer> getIDSaleFX(String name) {
		ObservableList<Integer> list=FXCollections.observableArrayList();
		for (Sales sale : QLController.list) {
			if (sale.getName().equals(name)) {
				list.add(sale.getId());
			}
		}
		return list;
	}
	public String storageSale(int id, int amount,String ncc, int sum, int datra) throws SQLException {
		int idncc=0;
		ResultSet rs=st.executeQuery("SELECT idnhacungcap FROM nhacungcap WHERE tennhacungcap=\""+ncc+"\"");
		if (rs.next()) {
			idncc=rs.getInt("idnhacungcap");
		}
		String dt=dateFormat.format(d);
		String sql="INSERT INTO hoadonnhap (ngaytra, tongsotien, datra, soluong, mahanghoa, idnhacungcap) VALUES (\""+dt+"\", "+sum+", "+datra+", "+amount+", "+id+", "+idncc+")";
		try {
			st.execute(sql);
			return "1";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error Insert to mysql!!!!";
		}
	}
	public int getSaleFX(Label pricesale, Label producersale, int selectedItem) {
		int price=0;
		for (Sales sale : QLController.list) {
			if (sale.getId()==selectedItem) {
				price=sale.getPrice();
				pricesale.setText(price+"");
				producersale.setText(""+sale.getProducer());
				break;
			}
		}
		return 0;
	}
	
	public String addSale(String text, int parseInt, String selectedItem) {
		
		String sql="INSERT INTO hang_hoa (hang_hoa.tenhanghoa, hang_hoa.gia, hang_hoa.hangsanxuat) VALUES (\""+text+"\", "+parseInt+", \""+selectedItem+"\");";
		try {
			st.execute(sql);
			sql="SELECT mahanghoa FROM hang_hoa ORDER BY mahanghoa DESC LIMIT 0,1";
			ResultSet rs=st.executeQuery(sql);
			if (rs.next()) {
				sql="INSERT INTO kho (mahanghoa, soluong, ngaycapnhat) VALUES ("+rs.getInt("mahanghoa")+", 0, 2014)";
				st.execute(sql);
			}
		} catch (SQLException e) {
			return "Error insert to mysql!!!!";
		}
		return "1";
	}
	
	public boolean deleteSale(int id){
		String sql="DELETE FROM hang_hoa WHERE mahanghoa="+id;
		try {
			st.execute(sql);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	public String updateSale(int id, String name, int prices, String producer){
		
		String sql="UPDATE hang_hoa SET tenhanghoa=\""+name+"\", gia="+prices+", hangsanxuat=\""+producer+"\" WHERE mahanghoa="+id+";";
		try {
			st.execute(sql);
			return "1";
		} catch (SQLException e) {
			return "Error update to mysql!!!!";
		}
	}
	
	public String insertXuat(int idkh, int idhh,int sl, int tong,  int datra) throws SQLException{
		String sql="INSERT INTO hoadonxuat (ngaytra, sotienconlai, sotiendatra, soluong, mahanghoa, id) VALUES (\""+dateFormat.format(d)+"\", "+tong+", "+datra+", "+sl+", "+idhh+", "+idkh+")";
		try {
			st.execute(sql);
			return "1";
		} catch (SQLException e) {
			System.out.println("error");
			return "Error Insert to mysql!!!!";
		}
	}
	
	//Custommer
	public String addCustomer(String name, String address){
		String sql="INSERT INTO khachhang (ten, address) VALUES (\""+name+"\", \""+address+"\");";
		try{
			st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error insert to mysql";
		}
		return "1";
	}
	public ObservableList<String> getKhachHangFX(ObservableList<Customer> obsList){
		obsList.removeAll(obsList);
		ObservableList<String> list=FXCollections.observableArrayList();
		String sql="SELECT * FROM khachhang;";
		try {
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()) {
				obsList.add(new Customer(rs.getInt("id"), rs.getString("ten"), rs.getString("address")));
				list.add(rs.getString("ten"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public ObservableList<Integer> getIDCustomerFX(String name) {
		ObservableList<Integer> list=FXCollections.observableArrayList();
		for (Customer customer : QLController.qlkhList) {
			if (customer.getName().equals(name)) {
				list.add(customer.getId());
			}
		}
		return list;
	}
	public String getCustomerFX(int value) {
		for (Customer item : QLController.qlkhList) {
			if (item.getId()==value) {
				return item.getAddress();
			}
		}
		return "";
	}
	public String updateCustomer(int id, String name, String add) {
		String sql="UPDATE khachhang SET ten=\""+name+"\", address=\""+add+"\"  WHERE id="+id+";";
		System.out.println(sql);
		try {
			st.execute(sql);
			return "1";
		} catch (SQLException e) {
			return "Error update Customer to mysql!!!!";
		}
	}
	public boolean deleteCustomer(int id) {
		String sql="DELETE FROM khachhang WHERE id="+id;
		try {
			st.execute(sql);
			return true;
		} catch (SQLException e) {
			System.out.println("Forein Key");
			return false;
		}
		
	}
	public String addProducer(String name) {
		String sql="INSERT INTO nhacungcap (tennhacungcap) VALUES (\""+name+"\");";
		try{
			st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error insert to mysql";
		}
		return "1";
	}
	public String updateProducer(int id, String name) {
		String sql="UPDATE nhacungcap SET tennhacungcap=\""+name+"\" WHERE idnhacungcap="+id+";";
		System.out.println(sql);
		try {
			st.execute(sql);
			return "1";
		} catch (SQLException e) {
			return "Error update Producer to mysql!!!!";
		}
	}
}
