package reader.reader;

import java.io.File;
import java.io.IOException;

import businessLogic.Constant.FILETYPE;

public class TextFileReader extends AbstractFileReader implements IPopulationManager {

	// TODO : Add Implementation
	@Override
	public void readCountryFile(File file) {
		// TODO Auto-generated method stub
	}

	// TODO : Add Implementation
	@Override
	public IPopulationManager readFile(FILETYPE fileType) {
		if (fileType == FILETYPE.TEXT) {
			return CommonFileReader.getReaderInstance().readTextFile();
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
