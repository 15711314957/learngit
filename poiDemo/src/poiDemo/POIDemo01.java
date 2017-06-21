package poiDemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
/**
 * 
 * @Action 建工作薄
 * @author 周孟禹
 * @date 2017年6月17日
 */
public class POIDemo01 {

	public static void main(String[] args) throws Exception {
		//创建Excel工作簿
		Workbook wk=new HSSFWorkbook();
		//创建名为poi.xls到桌面
		FileOutputStream fos=new FileOutputStream("C://Users//周孟禹//Desktop//poi.xls");
		wk.write(fos);
		fos.close();
	}
}
