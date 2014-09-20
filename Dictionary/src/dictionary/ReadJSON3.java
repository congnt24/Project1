package dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSON3 {
	public static void main(String[] args) {
		ReadJSON3 main=new ReadJSON3();
		main.read();
	}
	private void read() {
		BufferedReader br;
		BufferedWriter bw;
		File file=new File("C:\\Users\\Cong\\Documents\\Rainmeter\\Skins\\Elementary\\@Resources\\notes.txt");
		try {
			br=new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("Data600.JSON")));
			bw=new BufferedWriter(new FileWriter(file));
			JSONParser parser=new JSONParser();
			String line;
			int l=new Random().nextInt(49)+1;
			while ((line=br.readLine())!=null) {
				JSONObject obj=(JSONObject)parser.parse(line.toString());
				if (((String)obj.get("tag")).contains("L"+l)) {
					bw.write(obj.get("word")+" : "+obj.get("summary")+"\n");
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