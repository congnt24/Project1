package dictionary2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class GetDataFromDB {
	static Statement st;
	static BufferedWriter bw;
	static File file=new File("C:\\Users\\Cong\\Documents\\Rainmeter\\Skins\\Elementary\\@Resources\\notes.txt");

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/english?user=root");
			st=conn.createStatement();
			
			bw=new BufferedWriter(new FileWriter(file));
			Random r=new Random();
			for (int i = 0; i < 8; i++) {
				ResultSet rss = st.executeQuery("SELECT * FROM vocabulary WHERE id="+(r.nextInt(3418)+1)+";");
				rss.next();
				bw.write(rss.getString("words")+" : "+rss.getString("type")+"\n\t"+rss.getString("summary")+"\n\t"+rss.getString("extra")+"\n");
			}
			bw.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
