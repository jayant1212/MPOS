/*
'################################################################################################
'Class Name			   : ExcelUtil
'Description           : ExcelUtil
'Author                : Pranali Dharme
'Date Created          : 06/25/2019
'################################################################################################
'            Change History
'Date Changed:        Name:                Reason:
'================================================================================================
'  
'================================================================================================
*/

package fb.mpos.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	private static final String FILE_PATH = "src/test/java/resources/";
	private static final String XLSX_FILE_NAME = "scriptdata.xlsx";

	// DataFormatter to format and get each cell's value as String
	private static DataFormatter dataFormatter = new DataFormatter();
	private static Workbook workbook;

	// Heading row index is 1 for our test data sheet
	private static int HEADING_ROW_NUM = 1;

	static {
		// Creating a Workbook from an Excel file (.xls or .xlsx)
		try {
			workbook = WorkbookFactory.create(new File(FILE_PATH + XLSX_FILE_NAME));
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieve desired sheet in the Workbook
	 * 
	 * @param sheetName
	 * @return
	 * @throws Exception
	 */
	public static Sheet getSheet(String sheetName) throws Exception {
		Sheet sheet = workbook.getSheet(sheetName);
		if (sheet == null) {
			throw (new Exception("Excell does't contains sheet called " + sheetName));
		}

		return sheet;
	}

	/**
	 * This method returns all rows and columns for the given sheet name in the form
	 * of ArrayList
	 * 
	 * @param sheetName
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<Map<String, String>> readSheetData(String sheetName) throws Exception {
		Sheet sheet = getSheet(sheetName);

		return getData(sheet);
	}

	/**
	 * This method returns specific row for the given row number and sheet name
	 * Map<String, String> this map holds column name as a key and cell data as a
	 * value
	 * 
	 * @param sheetName
	 * @param rowNumber
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> readSheetDataByRowNum(String sheetName, int rowNumber) throws Exception {
		Sheet sheet = getSheet(sheetName);
		ArrayList<Map<String, String>> ObjSheetData = getData(sheet);
		if (ObjSheetData == null) {
			return null;
		}
		if (ObjSheetData != null && ObjSheetData.size() < rowNumber) {
			return null;
		}

		return ObjSheetData.get(rowNumber);
	}

	/**
	 * This method returns specific cell data for the given row number and sheet
	 * name
	 * 
	 * @param sheetName
	 * @param rowNumber
	 * @param columnName
	 * @return
	 * @throws Exception
	 */
	public static String readColumnDataByRowNum(String sheetName, int rowNumber, String columnName) throws Exception {
		Sheet sheet = getSheet(sheetName);
		ArrayList<Map<String, String>> ObjSheetData = getData(sheet);
		if (ObjSheetData == null) {
			return null;
		}
		if (ObjSheetData != null && ObjSheetData.size() <= rowNumber) {
			return null;
		}
		Map<String, String> data = ObjSheetData.get(rowNumber);
		if (data == null) {
			return null;
		}
		return data.get(columnName);
	}

	/**
	 * This method returns all cell data for the given column name and sheet name
	 * 
	 * @param sheetName
	 * @param columnName
	 * @return
	 * @throws Exception
	 */
	public static List<String> readColumnDataByColumnName(String sheetName, String columnName) throws Exception {
		List<String> list = new ArrayList<String>();
		Sheet sheet = getSheet(sheetName);
		ArrayList<Map<String, String>> ObjSheetData = getData(sheet);
		if (ObjSheetData == null) {
			return null;
		}
		for (int i = 0; i < ObjSheetData.size(); i++) {
			Map<String, String> row = ObjSheetData.get(i);
			list.add(row.get(columnName));
		}

		return list;
	}

	/**
	 * This method returns cell data for the given sheet name, user id and column
	 * name
	 * 
	 * @param sheetName
	 * @param operatorid
	 * @param columnName
	 * @return
	 * @throws Exception
	 */
	public static String readColumnDataByOperatorid(String sheetName, String operatorid, String columnName)
			throws Exception {
		Sheet sheet = getSheet(sheetName);
		ArrayList<Map<String, String>> ObjSheetData = getData(sheet);
		if (ObjSheetData == null) {
			return null;
		}
		for (int i = 0; i < ObjSheetData.size(); i++) {
			Map<String, String> row = ObjSheetData.get(i);
			if (operatorid.equalsIgnoreCase(row.get("operatorid"))) {
				return row.get(columnName);
			}
		}

		return null;
	}

	// created
	public static String readoperatoridByRowNum(String sheetName, int rowNumber, String operatorid) throws Exception {
		Sheet sheet = getSheet(sheetName);
		ArrayList<Map<String, String>> ObjSheetData = getData(sheet);
		if (ObjSheetData == null) {
			return null;
		}
		if (ObjSheetData != null && ObjSheetData.size() <= rowNumber) {
			return null;
		}
		Map<String, String> data = ObjSheetData.get(rowNumber);
		if (data == null) {
			return null;
		}
		return data.get(operatorid);
	}

	/**
	 * This method returns cell data for the given sheet name, TestcaseName and
	 * column name
	 * 
	 * @param sheetName
	 * @param operatorid
	 * @param columnName
	 * @return
	 * @throws Exception
	 */
	public static String readColumnDataByTestcaseName(String sheetName, String testcaseName, String columnName)
			throws Exception {
		Sheet sheet = getSheet(sheetName);
		ArrayList<Map<String, String>> ObjSheetData = getData(sheet);
		if (ObjSheetData == null) {
			return null;
		}
		for (int i = 0; i < ObjSheetData.size(); i++) {
			Map<String, String> row = ObjSheetData.get(i);
			if (testcaseName.equalsIgnoreCase(row.get("testcase.name"))) {
				return row.get(columnName);
			}
		}

		return null;
	}

	/**
	 * This method returns all rows and columns data in the form of ArrayList for
	 * the given sheet name
	 * 
	 * @param sheet
	 * @return
	 */
	public static ArrayList<Map<String, String>> getData(Sheet sheet) {
		ArrayList<Map<String, String>> ObjSheetData = new ArrayList<Map<String, String>>();
		Map<Integer, String> columnIndex = new LinkedHashMap<Integer, String>();
		Map<String, String> singleRow = null;
		for (Row row : sheet) {
			if (row.getRowNum() == HEADING_ROW_NUM) {
				for (Cell cell : row) {
					columnIndex.put(cell.getColumnIndex(), dataFormatter.formatCellValue(cell));
				}
			} else if (row.getRowNum() > HEADING_ROW_NUM) {
				singleRow = new LinkedHashMap<String, String>();
				for (Cell cell : row) {
					String cellValue = dataFormatter.formatCellValue(cell);
					String key = columnIndex.get(cell.getColumnIndex());
					singleRow.put(key, cellValue);
				}
			}
			if (singleRow != null) {
				ObjSheetData.add(singleRow);
			}
		}

		return ObjSheetData;
	}

	/**
	 * This method returns all rows and columns data in the form of 2 dimensional
	 * array for the given sheet name
	 * 
	 * @param sheetName
	 * @return
	 * @throws Exception
	 */
	public static Object[][] readSheetDataIntoArray(String sheetName) throws Exception {
		Sheet sheet = getSheet(sheetName);
		ArrayList<Map<String, String>> ObjSheetData = getData(sheet);
		Object[][] array = new Object[ObjSheetData.size()][];
		for (int i = 0; i < ObjSheetData.size(); i++) {
			Map<String, String> row = ObjSheetData.get(i);
			array[i] = row.values().toArray();
		}

		return array;
	}

	/**
	 * This method returns all rows and columns data in the form of two-dimensional
	 * array for the given sheet name and column name
	 * 
	 * @param sheetName
	 * @param columnNames
	 * @return
	 * @throws Exception
	 */

	public static Object[][] readSheetDataIntoArray(String sheetName, Set<String> columnNames) throws Exception {
		Sheet sheet = getSheet(sheetName);
		ArrayList<Map<String, String>> ObjSheetData = getData(sheet);
		Object[][] array = new Object[ObjSheetData.size()][];
		for (int i = 0; i < ObjSheetData.size(); i++) {
			Map<String, String> row = ObjSheetData.get(i);
			Iterator<String> it = row.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				if (!columnNames.contains(key)) {
					it.remove();
				}
			}
			array[i] = row.values().toArray();
		}

		return array;
	}

	public static void main(String[] args) {
		ArrayList<Map<String, String>> ObjSheetData = null;
		try {
			ObjSheetData = readSheetData("Data");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=====================");
		try {
			System.out.println(readColumnDataByRowNum("Data", 0, "operatorid"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=====================");
		try {
			Set<String> set = Stream.of("operatorid", "password").collect(Collectors.toCollection(HashSet::new));
			Object[][] arr = readSheetDataIntoArray("Data", set);
			for (int i = 0; i < arr.length; i++)
				System.out.println(Arrays.toString(arr[i]));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=====================");
		try {
			System.out.println(readColumnDataByColumnName("Data", "operatorid"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=====================");
		try {
			System.out.println(readColumnDataByOperatorid("Data", "00052175", "bid.period.open.info"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=====================");
		ObjSheetData.forEach(row -> {
			row.forEach((k, v) -> System.out.print(k + " : " + v + ", "));
			System.out.println("");
		});
	}

}