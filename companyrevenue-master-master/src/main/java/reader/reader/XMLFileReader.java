package reader.reader;

import java.io.File;
import java.io.IOException;

import businessLogic.Constant.FILETYPE;

public class XMLFileReader extends AbstractFileReader implements IPopulationManager {

	// TODO : Add Implementation
	@Override
	public void readCountryFile(File file) {
		// TODO Auto-generated method stub

	}

	// TODO : Add Implementation
	@Override
	public IPopulationManager readFile(FILETYPE fileType) {
		if (fileType == FILETYPE.CSV) {
			return CommonFileReader.getReaderInstance().readXmlFile();
		}
		return null;
	}

	// TODO : Add Implementation
	@Override
	public void saveFile(File fileName) throws IOException {
		// TODO Auto-generated method stub

	}
	// TODO : Add Implementation
	@Override
	public void displayFileData() {
		// TODO Auto-generated method stub
		
	}

}
