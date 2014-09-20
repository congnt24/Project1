package dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;


public class WriteJSON {

	private static BufferedWriter bw;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			BufferedReader br=new BufferedReader(new FileReader(ClassLoader.getSystemResource("toeic600words.txt").getFile()));
			bw = new BufferedWriter(new FileWriter("Data600.JSON"));
			String line;
			JSONObject obj=new JSONObject();
			int t=0;
			String tag=null;
			while ((line=br.readLine())!=null) {
				if (t==0) {
					tag=line;
					t++;
					continue;
				}
				if (line.trim().equals("")) {
					t=0;
					continue;
				}
				line=line.trim().replaceAll("\\s+", " ");
				String[] s=line.trim().split("\\.", 2);
				obj.put("tag", tag);
				obj.put("word", s[0]);
				obj.put("summary", s[1].trim());
				t++;
				bw.write(obj.toJSONString()+"\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
