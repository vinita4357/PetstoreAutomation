package api.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class XLUtility {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFCell cell;
	public XSSFRow row;
	public String path;
	public CellStyle style;
	
	
	public XLUtility(String path) {
		this.path=path;
	}
	
	public int getrowcount(String sheetname) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		int row=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return row;
		
	}
	public int getcellcount(String sheetname,int rowcount) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		int cell=sheet.getRow(rowcount).getLastCellNum();
		workbook.close();
		fi.close();
		return cell;
		
	}
	public String getcelldata(String sheetname,int rownum,int columnnum) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		cell=row.getCell(columnnum);
		DataFormatter formatter=new DataFormatter();
		String data;
		data=formatter.formatCellValue(cell);
		workbook.close();
		fi.close();
		return data;
		
	}
	
	

}
