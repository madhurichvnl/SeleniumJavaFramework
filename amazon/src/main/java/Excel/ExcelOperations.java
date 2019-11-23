package Excel;

public class ExcelOperations {
	Program to Read the data from the Excel file

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelRead {

		public static void main(String[] args) throws IOException {
		FileInputStreamfile=new FileInputStream("C:\\Users\\mmotupalli\\Desktop\\excellRead.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(file);
		XSSFSheet ws = wb.getSheet("Sheet1");
		int rowcount=ws.getLastRowNum();
		System.out.println(rowcount);
		for (int i=0;i<=rowcount;i++)
		{
		Row r=ws.getRow(i);
		int cellcount=r.getLastCellNum();
		for (int j=0;j<cellcount;j++)
			{
			Cell c=r.getCell(j);
			System.out.println(c.getStringCellValue()+"      ");
			}
			}
		
		}
		}

	Program to Write the data into the Excel file


	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelWrite {

			public static void main(String[] args) throws IOException {
		FileInputStream file=new FileInputStream("C:\\Users\\mmotupalli\\Desktop\\ExcellRead.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(file);
			XSSFSheet ws=wb.getSheet("sheet1");
			//to modify an existing cell
			Row r=ws.getRow(0);
			Cell c=r.getCell(1);
			c.setCellValue("abc");
			
			//to write into a blank cell in an existing  row
			r=ws.getRow(1);
			c=r.createCell(2);
			c.setCellValue("Xyz");
			
			//to write into a blank row and blank cell
			r=ws.createRow(3);
			c=r.createCell(0);
			c.setCellValue("AAA");
			
		FileOutputStream f=new FileOutputStream("C:\\Users\\mmotupalli\\Desktop\\ExcellRead.xlsx");
			wb.write(f);
			
		}

	}
	Program to Capture all the data in dynamic web table

	TestCase_ID	Test Step 	Step Description
	TC_35	Step 1	Launch  firefox  
	TC_35	Step 2	Naivgate to http://www.timeanddate.com/worldclock/
	TC_35	Step 3	Capture first column info from static webtable


	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.List;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class CaptureAllDataTOExcellfile {

		FirefoxDriver driver;
		@BeforeTest
		public void setUp()
		{
			driver=new FirefoxDriver();
			driver.get("https://www.timeanddate.com/worldclock/");
			driver.manage().window().maximize();
		}
		@Test
		public void webTableTest() throws IOException
		{
	FileInputStream file=new FileInputStream ("C:\\Users\\mmotupalli\\Desktop\\ExcellRead.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(file);
			XSSFSheet ws=wb.getSheet("Sheet1");
			Row r=null;
			WebElement table=driver.findElement(By.xpath("html/body/div[1]/div[7]/section[2]/div[1]/table"));
			List<WebElement> rows=table.findElements(By.tagName("tr"));
			for(int i=0;i<rows.size();i++)
			{
				r=ws.createRow(i);
				List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
				for(int j=0;j<cols.size();j++)
				{
					r.createCell(j).setCellValue(cols.get(j).getText());
				}
				
			}
			
		FileOutputStream f=new FileOutputStream("C:\\Users\\mmotupalli\\Desktop\\ExcellRead.xlsx");
			wb.write(f);
						
		}

	}



}
