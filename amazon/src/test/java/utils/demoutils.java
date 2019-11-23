package utils;

public class demoutils {
	public static void main(String[] args) throws Exception {
		String projectpath=System.getProperty("user.dir");
		ExcelUtils obj=new ExcelUtils(projectpath+"/excel/data.xlsx","Sheet1");
		obj.getrowcount();
		obj.getcolumncount();
		obj.readstringcelldata(1, 1);
	}

}
