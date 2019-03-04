package reader.reader;

import java.io.File;
import java.io.IOException;

import businessLogic.Constant.FILETYPE;

/**
 * 
 * @author saurabhsharma01
 *
 */
public interface IPopulationManager {

	public void displayFileData();

	public IPopulationManager readFile(FILETYPE fileType);
	
	public void saveFile(File fileName) throws IOException;
	
}
