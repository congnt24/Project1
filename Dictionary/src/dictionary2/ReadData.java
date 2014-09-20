package dictionary2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;


public class ReadData{
	File f=new File(getClass().getResource("/essential.txt").getFile());
	BufferedReader br;
	int max	=20000;
	static int amount=10;
	static Hashtable<String, String> hashTable=new Hashtable<String, String>();
	private static BufferedWriter bw;
	public ReadData() {
		System.out.println(f.getAbsolutePath());
		try {
			br=new BufferedReader(new FileReader(f));
			String line;
			for (int i = 0; i < max & (line=br.readLine())!=null; i++) {
				String[] strSplit=line.split("=");
				hashTable.put(strSplit[0], strSplit[1]);
			}
		}catch(IOException e){
			System.out.println("Errors.............");
		}
	}
	public static void main(String[] args) {
		new ReadData();
		File file=new File("C:\\Users\\Cong\\Documents\\Rainmeter\\Skins\\Elementary\\@Resources\\notes.txt");
		Random r=new Random();
		try {
			bw = new BufferedWriter(new FileWriter(file));
			int size=hashTable.size();
			System.out.println(size);
			List<String> key=new ArrayList<String>(hashTable.keySet());
			for (int i = 0; i < amount; i++) {
				int k=r.nextInt(size);
				bw.write(key.get(k)+" : "+hashTable.get(key.get(k))+"\n\n");
			}
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void random(int amount, Hashtable<String, String> hashTable){
		
	}

}
