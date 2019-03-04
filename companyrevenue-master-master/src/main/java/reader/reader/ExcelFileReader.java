package reader.reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

import businessLogic.Constant.FILETYPE;
import businessLogic.CountryInfo;


public class ExcelFileReader extends AbstractFileReader implements IPopulationManager {


	@Override
	public void readCountryFile(File file) {
		
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = "\t";

		try {
			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {
				String[] countryInfoAttributes = line.split(cvsSplitBy);
				CountryInfo countryInfo = getCountryData(countryInfoAttributes); 
				saveCountryInfo(countryInfo);

			}		 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}	

	@Override
	public IPopulationManager readFile(FILETYPE fileType) {
		if(fileType == FILETYPE.CSV){
			return CommonFileReader.getReaderInstance().readExcelFile();
		}
		return null;
	}
	public void displayFileData(){
		Collections.sort(countryInfoList,new CountryInfo());
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println(" Id | company | revanue | year |");
		for (CountryInfo countryInfo : countryInfoList) {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println(countryInfo.getExternalTransactionID()+"\t| "+countryInfo.getCompanyName()+"\t| "+
					countryInfo.getRevanue()+"\t| "+(countryInfo.getYear()));
		}
		System.out.println("--------------------------------------------------------------------------------");
	}
	
	
	@Override
	public void saveFile(File fileName) throws IOException {
		try
		{
			System.out.println("");
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			for(CountryInfo countryInfo : countryInfoList){
					out.write(countryInfo.getExternalTransactionID()+"\t"+countryInfo.getCompanyName()+"\t"+
							countryInfo.getRevanue()+"\t"+(countryInfo.getYear())+"\t");
				out.write("\n");
			}
			System.out.println("File saved Successfully to" + fileName);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
