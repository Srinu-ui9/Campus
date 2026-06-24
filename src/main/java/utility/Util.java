package utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Util {
	public static String DataFetchFromExcel(String Sheetname, int Rowvalue, int Colvalue) throws Exception {
		String path = "src//main//resources//Excel//TestData.xlsx";

		FileInputStream file = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(file);

		Sheet sheet = book.getSheet(Sheetname);

		String data = sheet.getRow(Rowvalue).getCell(Colvalue).getStringCellValue();

		return data;

	}

	public static void main(String args[]) throws Exception {

		System.out.println(Util.DataFetchFromExcel("Login", 1, 0));
		System.out.println(Util.DataFetchFromExcel("Login", 1, 1));

		Util.DataFetchFromExcel("TGI_Workflow", 1, 0);
		Util.DataFetchFromExcel("TGI_Workflow", 1, 1);

	}

	public static void waitinseconds(int secs) throws InterruptedException {
		Thread.sleep(secs * 1000);
	}

}
