/*
'################################################################################################
'Class Name			   : PropertyFileReader
'Description           : PropertyFileReader
'Author                : Pranali Dharme
'Date Created          : 07/03/2019
'################################################################################################
'            Change History
'Date Changed:        Name:                Reason:
'================================================================================================
'  
'================================================================================================
*/

package fb.mpos.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

	private final String filePath = "src/test/java/resources/testdata.properties";
	private Properties prop;
	private FileInputStream fs;

	public PropertyFileReader() {
		//Creating object of Properties class
		prop = new Properties();
		//Creating object of FileInputStream class and providing the properties file path to the object
		try {
			fs = new FileInputStream(filePath);
			prop.load(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getProperty(String key) {
		return prop.getProperty(key);
	}
}