package businessLogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import businessLogic.Constant.FILETYPE;
import reader.reader.IPopulationManager;
import reader.reader.CommonFileReader;


public class MainClass {
	private static BufferedReader in;
	
	public static void main(String[] args){
		String fileName = "";
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			if (args.length<1){
				System.out.println("Enter path to .CSV file: ");
				fileName = in.readLine();
			} else
			{
				fileName = args[0];
			}
			if (null == fileName || fileName.trim().isEmpty()) {
				throw new Exception();
			}else {
				new MainClass().processFile(fileName);
			}
		}catch(Exception e) {
			System.out.println("File doesn't exist");
		}
	}

	public  void processFile(String fileName) throws Exception, IOException {
		File file = new File(fileName);	
		File exportedFile = new File(file.getName(),  fileName.substring(0, fileName.lastIndexOf("."))+".csv");
		IPopulationManager manager = CommonFileReader.getReaderInstance().readFile(FILETYPE.CSV,file);	
		if (manager == null) {
			throw new Exception();
		}else {
			manager.displayFileData();
			manager.saveFile(exportedFile);
		}
	}
}
