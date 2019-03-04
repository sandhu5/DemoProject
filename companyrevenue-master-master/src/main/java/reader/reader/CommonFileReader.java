package reader.reader;

import java.io.File;

import businessLogic.Constant.FILETYPE;

public class CommonFileReader {
	/**
	 * 
	 */
	private static CommonFileReader commonFileReader;
	/**
	 * 
	 */
	private static ExcelFileReader excelFileReader;
	/**
	 * 
	 */
	private static XMLFileReader xmlFileReader;
	/**
	 * 
	 */
	private static TextFileReader textFileReader;

	/**
	 * 
	 * @return
	 */
	public static CommonFileReader getReaderInstance() {
		if (null == commonFileReader) {
			synchronized (CommonFileReader.class){
				if (null == commonFileReader) {
					commonFileReader = new CommonFileReader();
					excelFileReader= new ExcelFileReader();
					xmlFileReader = new XMLFileReader();
					textFileReader = new TextFileReader();
				}
			}
		}
		return commonFileReader;
	}

	/**
	 * 
	 * @return
	 */
	public ExcelFileReader readExcelFile(){
		return excelFileReader;
	}

	/**
	 * 
	 * @return
	 */
	public XMLFileReader readXmlFile(){
		return xmlFileReader;
	}

	/**
	 * 
	 * @return
	 */
	public TextFileReader readTextFile(){
		return textFileReader;
	}

	/**
	 * 
	 * @param fileType
	 * @return
	 */
	public IPopulationManager readFile(FILETYPE fileType,File file) {
		switch (fileType) {
		case CSV:
			excelFileReader.readCountryFile(file);
			return excelFileReader;
		case TEXT:
			textFileReader.readCountryFile(file);
			return textFileReader;
		case XML:
			xmlFileReader.readCountryFile(file);
			return xmlFileReader;

		default:
			return null;
		}
	}

	
}
