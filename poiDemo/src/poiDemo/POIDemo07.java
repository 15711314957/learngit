package poiDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
/**
 * 
 * @Action 8文本提取
 * @author 周孟禹
 * @date 2017年6月17日
 */
public class POIDemo07 {

	public static void main(String[] args) throws Exception {
		//读取一个xls
		InputStream is=new FileInputStream("C://Users//周孟禹//Desktop//poi.xls");
		//创建一个工作薄读取文件流
		HSSFWorkbook wb=new HSSFWorkbook(is);
		//将读取到的文件抽取
		ExcelExtractor ex=new ExcelExtractor(wb);
		//ex.setIncludeSheetNames(false);//不打印sheet页的名字
		//打印文本
		System.out.println(ex.getText());
	}
}
