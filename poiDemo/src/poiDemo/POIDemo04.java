package poiDemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
/**
 * 
 * @Action 5日期格式
 * @author 周孟禹
 * @date 2017年6月17日
 */
public class POIDemo04 {

	public static void main(String[] args) throws Exception {
		//创建Excel工作簿
		Workbook wk=new HSSFWorkbook();
		Sheet createSheet = wk.createSheet("0617");//建名为0617sheet页
		Row row = createSheet.createRow(0);//建行
		row.createCell(0).setCellValue(new Date());//42903.9605336806
		
		CreationHelper creationHelper=wk.getCreationHelper();
		//设置单元格样式
		CellStyle createCellStyle = wk.createCellStyle();
		DataFormat createDataFormat = creationHelper.createDataFormat();
		short format = createDataFormat.getFormat("yyyy-MM-dd");//日期格式
		createCellStyle.setDataFormat(format);//单元日期样式为format这个日期格式
		Cell cell = row.createCell(1);//建第二个单元格
		cell.setCellValue(new Date());//为单元格设置日期
		cell.setCellStyle(createCellStyle);//改变此单元格的样式
		
		Cell cell1 = row.createCell(2);//建第二个单元格
		cell1.setCellValue(Calendar.getInstance());//为单元格设置日期
		cell1.setCellStyle(createCellStyle);//改变此单元格的样式
		//创建名为poi.xls到桌面
		FileOutputStream fos=new FileOutputStream("C://Users//周孟禹//Desktop//poi.xls");
		wk.write(fos);
		fos.close();
	}
}
