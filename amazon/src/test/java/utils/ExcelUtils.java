package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static String projectpath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelpath,String sheetnumber) throws Exception
	{
		projectpath=System.getProperty("user.dir");
		workbook=new XSSFWorkbook(projectpath+"/excel/data.xlsx");
		sheet=workbook.getSheet("Sheet1");

	}
		public static int getrowcount() 
	{
		int rowcount=0;
		rowcount=sheet.getPhysicalNumberOfRows();
		//System.out.println("no of rows:"+rowcount);
		return rowcount;
		
	}
	public static int getcolumncount()
	{
		int colcount=0;
		
		colcount=sheet.getRow(0).getPhysicalNumberOfCells();
		//System.out.println("no of columns:"+colcount);
		return colcount;
		
	}
	public static String readstringcelldata(int rownum,int colnum )
	{
		String exceldata=null;
		exceldata=sheet.getRow(rownum).getCell(colnum).getStringCellValue();
		return exceldata;
	}
	/*public static void readnumericalcelldata(int rownum,int colnum )
	{
		double excelnumdata=sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
		System.out.println(excelnumdata);
	}*/
}

