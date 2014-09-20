package dictionary2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class GetDataFromWeb {
	private static Statement st;

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/english?user=root");
			st = conn.createStatement();
			for (int i = (int)'G'; i <= (int)'Z'; i++) {
				insert("http://toeic.youpla.be/words/"+(char)i);
				System.out.println((char)i);
			}
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL Exception!!");
		}
	}
	public static void insert(String url){
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
//			doc=Jsoup.parse(new File("f.htm"), "UTF-8");
			Elements ele=doc.select(".tablewords tr td");
			for (Element element : ele) {
				Elements t=element.select("b");
				String[] word=t.html().replace(")", "").replace("(", "-").split("-");
				String subString=element.html().substring(t.outerHtml().length());
				String[] summary=subString.split("<br />");
				String extra="";
				if(summary.length==3)
					extra=summary[2];
				st.execute("INSERT INTO vocabulary (words, type, summary, extra) VALUES (\""+word[0].trim()+"\", \""+word[1]+"\", \""+summary[1]+"\", \""+extra+"\");");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
	
