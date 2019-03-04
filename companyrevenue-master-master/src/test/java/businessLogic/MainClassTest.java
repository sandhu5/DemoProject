package businessLogic;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import businessLogic.Constant.FILETYPE;
import reader.reader.CommonFileReader;
import reader.reader.IPopulationManager;

@RunWith(PowerMockRunner.class)
@PrepareForTest({CommonFileReader.class})

public class MainClassTest {
	
	MainClass main = new MainClass();
	CommonFileReader commonFileReader;

	
	
	@Test
    public void testReadFileWithClassLoader2() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/testcsv.csv").getFile());
        assertTrue(file.exists());
    }
	
	@Test
	public void readDataTest() throws FileNotFoundException {
		File resourcesDirectory = new File("src/test/resources");
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("file").getFile());
		System.out.println(file.getAbsolutePath());
		System.out.println(resourcesDirectory.getAbsolutePath());
		assertTrue(file.exists());
	}
	
	@Test
	public void main(){
		try{
			String as[] = {};
			PowerMockito.mockStatic(CommonFileReader.class);
			PowerMockito.doNothing().when(CommonFileReader.class,"getReaderInstance");//.readFile(FILETYPE.CSV, Matchers.any())).thenReturn((IPopulationManager) commonFileReader);
			ClassLoader classLoader = this.getClass().getClassLoader();
			File file = new File(classLoader.getResource("file/testcsv.csv").getFile());
			//PowerMockito.when(MainClass.class);
			String fileName = file.toString();
			main.processFile(fileName);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
