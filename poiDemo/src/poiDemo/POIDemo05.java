package poiDemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
/**
 * 
 * @Action 6不同内容格式
 * @author 周孟禹
 * @date 2017年6月17日
 */
public class POIDemo05 {

	public static void main(String[] args) throws Exception {
		//创建Excel工作簿
		Workbook wk=new HSSFWorkbook();
		Sheet createSheet = wk.createSheet();
		Row row = createSheet.createRow(0);
		row.createCell(1).setCellValue(false);//为下标为1的单元格赋值boolean为false
		int i = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);//指定当前星期
		
		Calendar calendar = Calendar.getInstance();
		/*calendar.setTime(new Date());
	    String format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS").format(calendar.getTime());*/
	    row.createCell(7).setCellValue(i);
		row.createCell(2).setCellValue(i);//为下标为2的单元格赋值当前日期
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String format = sdf.format(new Date());//日期转换
		row.createCell(3).setCellValue(format);//为下标为3的单元格赋值当前日期
		row.createCell(4).setCellValue(2.3);//为下标为4的单元格赋值double为POI
		row.createCell(5).setCellValue("POI");//为下标为5的单元格赋值字符串POI
		HSSFRichTextString hrts=new HSSFRichTextString("1111");
		row.createCell(6).setCellValue(hrts);
		FileOutputStream fos=new FileOutputStream("C://Users//周孟禹//Desktop//poi.xls");
		wk.write(fos);
		fos.close();
	}
}
