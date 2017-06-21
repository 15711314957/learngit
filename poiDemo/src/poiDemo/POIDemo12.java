package poiDemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
/**
 * 
 * @Action 13字体处理
 * @author 周孟禹
 * @date 2017年6月17日
 */

public class POIDemo12 {

	public static void main(String[] args) throws Exception {
		//创建Excel工作簿
		Workbook wk=new HSSFWorkbook();
		//创建名为第一个的sheet
		Sheet sheet = wk.createSheet("第一个");
		Row row = sheet.createRow(1);//创建第二行
		Cell cell=row.createCell(1);//创建第二个单元格
		//为下标为1的单元格赋值
		cell.setCellValue("字体样式");
		//字体样式
		Font font = wk.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体
		font.setFontName("华文琥珀");//字体
		font.setItalic(true);//斜体
		font.setStrikeout(true);
		//单元格样式
		CellStyle cellStyle = wk.createCellStyle();
		//将字体样式设置到单元格
		cellStyle.setFont(font);
		//将单元格样式设置到单元格
		cell.setCellStyle(cellStyle);
		FileOutputStream fos=new FileOutputStream("C://Users//周孟禹//Desktop//poi.xls");
		wk.write(fos);
		fos.close();
	}
}
