package poiDemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
/**
 * 
 * @Action 10边框处理
 * @author 周孟禹
 * @date 2017年6月17日
 */
public class POIDemo09 {

	public static void main(String[] args) throws Exception {
		//创建Excel工作簿
		Workbook wk=new HSSFWorkbook();
		//创建名为第一个的sheet
		Sheet sheet = wk.createSheet("第一个");
		Row row = sheet.createRow(2);//创建第三行
		Cell cell=row.createCell(2);//创建第三个单元格
		//为下标为0的单元格赋值为1
		cell.setCellValue(2222);
		CellStyle cellStyle = wk.createCellStyle();
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);//边框底部细线
		cellStyle.setBottomBorderColor(IndexedColors.BLUE.getIndex());//边框底部颜色索引
		
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);//左边框细线
		cellStyle.setLeftBorderColor(IndexedColors.PINK.getIndex());//左边框颜色索引
		
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);//右边框细线
		cellStyle.setRightBorderColor(IndexedColors.RED.getIndex());//右边框颜色索引
		
		cellStyle.setBorderTop(CellStyle.BORDER_THICK);//边框顶部细线
		cellStyle.setTopBorderColor(HSSFColor.YELLOW.index);//边框顶部颜色索引
		//设置样式
		cell.setCellStyle(cellStyle);
		FileOutputStream fos=new FileOutputStream("C://Users//周孟禹//Desktop//poi.xls");
		wk.write(fos);
		fos.close();
	}
}
