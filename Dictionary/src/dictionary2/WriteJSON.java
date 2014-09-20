package dictionary2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONObject;

public class WriteJSON {
	static BufferedWriter bw;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/english?user=root");
			Statement st=conn.createStatement();
			JSONObject obj=new JSONObject();
			bw=new BufferedWriter(new FileWriter(new File("Database.JSON")));
			ResultSet rs=st.executeQuery("SELECT * FROM vocabulary");
			while (rs.next()) {
				obj.put("extra", rs.getString("extra"));
				obj.put("summary", rs.getString("summary"));
				obj.put("type", rs.getString("type"));
				obj.put("words", rs.getString("words"));
				obj.put("id", rs.getInt("id"));
				bw.write(obj.toJSONString()+"\n");
			}
			bw.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
