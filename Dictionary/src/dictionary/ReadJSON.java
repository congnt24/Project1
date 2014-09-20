package dictionary;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSON {
	
	public static void main(String[] args) {
		ReadJSON main=new ReadJSON();
		main.read();
	}
	private void read() {
		BufferedReader br;
		BufferedWriter bw;
		File file=new File("C:\\Users\\Cong\\Documents\\Rainmeter\\Skins\\Elementary\\@Resources\\notes.txt");
		try {
			br=new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("Database.JSON")));
			bw=new BufferedWriter(new FileWriter(file));
			JSONParser parser=new JSONParser();
			double f=(double)1/300;
			int counter=0;
			String line;
			while ((line=br.readLine())!=null) {
				JSONObject obj=(JSONObject) parser.parse(line);
				if (Math.random()<=f) {
					bw.write(obj.get("words")+" : "+obj.get("type")+"\n\t"+obj.get("summary")+"\n\t"+obj.get("extra")+"\n");
					counter++;
					if (counter==10) {
						break;
					}
				}
			}
			bw.close();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
