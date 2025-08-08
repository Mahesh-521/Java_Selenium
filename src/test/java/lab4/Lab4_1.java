package lab4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lab4_1 {

	public static void main(String[] args) {
		
		try {
			FileReader fr=new FileReader("sample.txt");
			
			StringBuffer sb=new StringBuffer();
			int ch;
			while((ch=fr.read())!=-1) {
				sb.append((char)ch);
			}
			fr.close();
			
			String revContent=sb.reverse().toString();
			
			FileWriter fw=new FileWriter("sample.txt");
			fw.write(revContent);
			fw.close();
			
			System.out.println("File content reversed");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
