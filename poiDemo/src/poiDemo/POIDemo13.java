package poiDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
/**
 * 
 * @Action 14读写和重写工作薄
 * @author 周孟禹
 * @date 2017年6月17日
 */

public class POIDemo13 {

	public static void main(String[] args) throws Exception {
		//io流读取
		InputStream is=new FileInputStream("C://Users//周孟禹//Desktop//poi.xls");
		//POI文件系统类  读到内存里
		POIFSFileSystem ps=new POIFSFileSystem(is);
		//创建Excel工作簿
		Workbook wk=new HSSFWorkbook(ps);
		//获取第一个的sheet
		Sheet sheet = wk.getSheetAt(0);
		//获取行
		Row row = sheet.getRow(0);
			//获取列
			Cell cell= row.getCell(0);
			if (cell==null) {
				cell=row.createCell(3);
			}
			cell.setCellValue("读取和重写");
			System.out.println(cell);
		FileOutputStream fos=new FileOutputStream("C://Users//周孟禹//Desktop//poi2.xls");
		wk.write(fos);
		fos.close();
	}
}
