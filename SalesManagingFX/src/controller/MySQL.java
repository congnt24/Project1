package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import model.Customer;
import model.Producer;
import model.Sales;
import controller.QLController.QLKItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import javafx.scene.control.Label;


public class MySQL {
	Connection conn;
	static Statement st;
	Date date=new Date(new java.util.Date().getTime());
	public boolean connect(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project1?user=root");
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
		String sql="select * from hang_hoa inner join nhacungcap on hang_hoa.idnhacungcap = nhacungcap.idnhacungcap;";
		try {
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()) {
				obsList.add(new Sales(rs.getInt("mahanghoa"), rs.getString("tenhanghoa"), rs.getInt("gia"), rs.getString("tennhacungcap")));
				nameList.add(rs.getString("tenhanghoa"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nameList;
	}
	
	public ObservableList<String> getHangHoaFX2(ObservableList<Sales> obsList){
		obsList.removeAll(obsList);
		ObservableList<String> nameList=FXCollections.observableArrayList();
		String sql="select * from hang_hoa inner join nhacungcap on hang_hoa.idnhacungcap = nhacungcap.idnhacungcap;";
		try {
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()) {
				obsList.add(new Sales(rs.getInt("mahanghoa"), rs.getString("tenhanghoa"), rs.getInt("gia"), rs.getString("tennhacungcap")));
				nameList.add(rs.getString("tenhanghoa"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nameList;
	}
	
	
	public ObservableList<String> getKhachHangFX(ObservableList<Customer> obsList){
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
	public void getNhaCungCapFX(ObservableList<Producer> list){
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
	
	@SuppressWarnings("resource")
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
	public void storageSale(String id, String amount, String sum, int datra) {
		
	}
	public int getSaleFX(Label pricesale, Label producersale, int selectedItem) {
		int price=0;
		for (Sales sale : QLController.list) {
			if (sale.getId()==selectedItem) {
				price=sale.getPrice();
				pricesale.setText(price+"");
				producersale.setText(sale.getProducer());
				break;
			}
		}
		return 0;
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
	public String addSale(String text, int parseInt, String selectedItem) {
		int id=0;
		for (Producer pro : QLController.qlnccList) {
			if (pro.getName().equals(selectedItem)) {
				id=pro.getId();
			}
		}
		String sql="INSERT INTO hang_hoa (tenhanghoa, gia, idnhacungcap) VALUES (\""+text+"\", "+parseInt+", "+id+");";
		try {
			st.execute(sql);
		} catch (SQLException e) {
			return "Error insert to mysql!!!!";
		}
		return "1";
	}
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
}
