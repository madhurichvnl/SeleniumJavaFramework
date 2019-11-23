package utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelReadTest {
		@Test(dataProvider="tdata")
	public void testngclass(String email,String password)
	{
		System.out.println(email+"  l  "+password);
			
	}
	@DataProvider(name="tdata")
	public Object[][] getdata() throws Exception
	{
		String excelpath="C:\\Users\\madhuri\\amazon\\excel\\data.xlsx";
		Object data[][]=testdata(excelpath, "Sheet1");
		return data;
	}
	public static Object[][] testdata(String excelpath,String sheetnumber) throws Exception
	{
		ExcelUtils funobj=new ExcelUtils(excelpath, sheetnumber);
		int rownum=funobj.getrowcount();
		int colnum=funobj.getcolumncount();
		Object data[][]=new Object[rownum][colnum];
		for(int i=1;i<rownum;i++)
		{
			for(int j=0;j<colnum;j++)
			{
				String celldata=funobj.readstringcelldata(i, j);
				System.out.print(celldata+"  |  ");
				data[i][j]=celldata;
			}
		}
		return data;
	}
	

}
