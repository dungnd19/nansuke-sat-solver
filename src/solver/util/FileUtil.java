package solver.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
	private static final String FILE_NAME="data.txt";
	
	public static void writerFile(String s){
		
		try {
			File file=new File(FILE_NAME);
			FileWriter fw=new FileWriter(file,true);
			BufferedWriter bufferedWriter=new BufferedWriter(fw);
			bufferedWriter.write(s);
			bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch bclock
			e.printStackTrace();
			System.out.print(e.toString());
		}
	}
	
	public static void clearFile(){
		File file=new File(FILE_NAME);
		file.delete();
	}
	
}
