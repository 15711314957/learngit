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
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
/**
 * 
 * @Action 16用户自定义数据格式
 * @author 周孟禹
 * @date 2017年6月17日
 */

public class POIDemo15 {

	public static void main(String[] args) throws Exception {
		//创建Excel工作簿
		Workbook wk=new HSSFWorkbook();
		Sheet sheet = wk.createSheet("数据格式");
		Row row = sheet.createRow(1);//第二行
		Cell cell = row.createCell(1);//第二例
		cell.setCellValue(1234.36);
		//数据格式
		DataFormat format = wk.createDataFormat();
		CellStyle cellStyle = wk.createCellStyle();
		cellStyle.setDataFormat(format.getFormat("0.0"));//保留一位小数，有四舍五入功能
		cell.setCellStyle(cellStyle);//设置数据样式
		FileOutputStream fos=new FileOutputStream("C://Users//周孟禹//Desktop//poi2.xls");
		wk.write(fos);
		fos.close();
	}
}
