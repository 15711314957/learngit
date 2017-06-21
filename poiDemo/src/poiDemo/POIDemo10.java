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
 * @Action 11背景颜色
 * @author 周孟禹
 * @date 2017年6月17日
 */
public class POIDemo10 {

	public static void main(String[] args) throws Exception {
		//创建Excel工作簿
		Workbook wk=new HSSFWorkbook();
		//创建名为第一个的sheet
		Sheet sheet = wk.createSheet("第一个");
		Row row = sheet.createRow(2);//创建第三行
		Cell cell=row.createCell(2);//创建第三个单元格
		//为下标为0的单元格赋值为1
		cell.setCellValue(111);
		CellStyle cellStyle = wk.createCellStyle();
		cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);//白色效果 ---填充
		cellStyle.setFillForegroundColor(HSSFColor.RED.index);//前景色
		
		//设置样式
		cell.setCellStyle(cellStyle);
		FileOutputStream fos=new FileOutputStream("C://Users//周孟禹//Desktop//poi.xls");
		wk.write(fos);
		fos.close();
	}
}
