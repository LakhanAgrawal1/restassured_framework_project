package common_method;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	public static ArrayList<String> getDataExcel(String testSheetName, String tesCaseName) throws IOException {
		ArrayList<String> arrayData = new ArrayList<String>();
		// step 1 to locate the file, by creating the object of fileinputstream
		FileInputStream fis = new FileInputStream("C:\\Users\\PC\\Desktop\\testdata.xlsx");

		try (// step 2 create to object of XSSFWorkbook to open the file
		XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
			// step 3 access the desired sheet
			// step 3.1 fetch the count of sheet available in the excel file
			int countOfSheet = workbook.getNumberOfSheets();

			// step 3.2 fetch the name of sheet and comapre against desired sheet name
			for (int i = 0; i < countOfSheet; i++) {
				String sheetName = workbook.getSheetName(i);
				// System.out.println(sheetName);
				if (sheetName.equalsIgnoreCase(testSheetName)) {
					// System.out.println(sheetName);
					// step 4 access the sheet and iterate throw rows to fetch the
					// column in which test case name coloumn is found
					XSSFSheet sheet = workbook.getSheetAt(i);

					// Step 4.1 Create iterator for rows-
					Iterator<Row> Rows = sheet.iterator();
					Row firstrow = Rows.next();

					// Step 4.2 Create iterator for Cells
					Iterator<Cell> Cell = firstrow.cellIterator();

					int j = 0;
					int tc_column = 0;

					// step 4.3 read the cell values of row no 1 to compare against the test case
					// name
					while (Cell.hasNext()) {
						Cell cellvalue = Cell.next();
						if (cellvalue.getStringCellValue().equalsIgnoreCase("tc_name")) {
							tc_column = j;

							System.out.println(cellvalue);

						}
						j++;
					}
					// step 5 fetch the data for designated test case
					while (Rows.hasNext()) {
						Row datarow = Rows.next();
						if (datarow.getCell(tc_column).getStringCellValue().equalsIgnoreCase(tesCaseName)) {
							Iterator<Cell> datacellvalue = datarow.cellIterator();

							while (datacellvalue.hasNext()) {
								Cell dataofcell = datacellvalue.next();


								// method 1 extract cell value by using try and catch method
								try {
									String testdata = dataofcell.getStringCellValue();

									arrayData.add(testdata);
								} 
								catch (IllegalStateException e) 
								{
									int inttestData = (int) dataofcell.getNumericCellValue();
									String stringtestData = Integer.toString(inttestData);

									arrayData.add(stringtestData);

								}
//							CellType datatype=dataofcell.getCellType();
								// method 2 extract cell value by using if and else
//													
//							if (datatype.toString() == "NUMERIC")
//								
//							{
//								int inttestData=(int) dataofcell.getNumericCellValue();
//																
//							System.out.println(inttestData);
//											
//							}
//							
//							else if (datatype.toString()=="STRING")
//							{
//								String testdata=dataofcell.getStringCellValue();
								//arrayData.add(stringtestData);							
//							}

								//method 3 -extract the data by converting into string first

								//String testData=datacellvalue.next().toString().replaceAll("\\.\\d+$", "");
								//System.out.println(testData);

								//method 4 --extract the data by dataformmter

//							DataFormatter format =new DataFormatter();
//							String testData=format.formatCellValue(datacellvalue.next());
//							System.out.println(testData);
							}
						}

					}
				}

			}
		}

		return arrayData;
	}

}