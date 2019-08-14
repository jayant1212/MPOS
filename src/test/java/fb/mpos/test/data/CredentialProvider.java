/*
'################################################################################################
'Class Name			   : CredentialProvider
'Description           : CredentialProvider
'Author                : Pranali Dharme
'Date Created          : 6/25/2019
'################################################################################################
'            Change History
'Date Changed:        Name:                Reason:
'================================================================================================
'  
'================================================================================================
*/

package fb.mpos.test.data;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.DataProvider;

import fb.mpos.utility.ExcelUtil;

public class CredentialProvider {

	@DataProvider(name = "credentialData")

	public static Object[][] getCredentialData() {

		Set<String> set = Stream.of("operatorid", "password").collect(Collectors.toCollection(HashSet::new));
		Object[][] arr = null;
		try {
			arr = ExcelUtil.readSheetDataIntoArray("Data", set);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
}