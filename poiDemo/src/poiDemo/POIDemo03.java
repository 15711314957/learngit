package poiDemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
/**
 * 
 * @Action 4创建单元格
 * @author 周孟禹
 * @date 2017年6月17日
 */
public class POIDemo03 {

	public static void main(String[] args) throws Exception {
		//创建Excel工作簿
		Workbook wk=new HSSFWorkbook();
		//创建名为第一个的sheet
		Sheet sheet = wk.createSheet("第一个");
		//创建行   从0开始
		Row row = sheet.createRow(0);
		//创建单元格   从0开始
		Cell cell=row.createCell(0);
		//为下标为0的单元格赋值为1
		cell.setCellValue(1);
		FileOutputStream fos=new FileOutputStream("C://Users//周孟禹//Desktop//poi.xls");
		wk.write(fos);
		fos.close();
	}
}
