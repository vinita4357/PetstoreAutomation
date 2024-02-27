package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataprovider {
	@DataProvider(name="data")
	public String[][] getalldata() throws IOException{
		
	String path=System.getProperty("user.dir")+"\\testData\\Userdata.xlsx";	
		XLUtility xl=new XLUtility(path);
		int rows=xl.getrowcount("Sheet1");
		int columns=xl.getcellcount("Sheet1", 1);
		String[][] apidata=new String[rows][columns];
		for(int i=1;i<=rows;i++) {
			for(int j=0;j<columns;j++) {
				apidata [i-1][j] =xl.getcelldata("Sheet1", i, j);
		
	}

}
	return apidata	;
	}
	
	@DataProvider(name="UserNames")
	public String[] getUsernames() throws IOException {
		String path=System.getProperty("user.dir")+"\\testData\\Userdata.xlsx";	
		XLUtility xl=new XLUtility(path);
		int rows=xl.getrowcount("Sheet1");
		String[] apidata=new String[rows];
		for(int i=1;i<=rows;i++) {
			
				apidata[i-1]=xl.getcelldata("Sheet1", i, 1);
			}
		
	
		return apidata;
}
}
