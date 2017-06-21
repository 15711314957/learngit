package poiDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DateFormat;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
/**
 * 
 * @Action 7遍历---所谓读取
 * @author 周孟禹
 * @date 2017年6月17日
 */
public class POIDemo06 {

	public static void main(String[] args) throws Exception {
		//读取一个xls
		InputStream is=new FileInputStream("C://Users//周孟禹//Desktop//poi.xls");
		//文件系统来读到这个文件流
		POIFSFileSystem fileSystem=new POIFSFileSystem(is);
		//创建一个工作薄   HSSFWorkbook是workbook的一个实现类
		HSSFWorkbook wb=new HSSFWorkbook(fileSystem);
		HSSFSheet hs=wb.getSheetAt(0);//获取第一个sheet页
		if (hs!=null) {
			//遍历行    getLastRowNum()获取所有行
			for (int i = 0; i <= hs.getLastRowNum(); i++) {
				HSSFRow row = hs.getRow(i);//具体的每行
				if (row==null) {
					continue;
				}
				//遍历列（行包括多个列所以在行内执行遍历）    getLastCellNum()获取所有列
				for (int j = 0; j < row.getLastCellNum(); j++) {
					HSSFCell cell = row.getCell(j);//具体每列
					if (cell==null) {
						continue;
					}
					//根据不同的类型转换成String
					cell.setCellType(Cell.CELL_TYPE_STRING);
					System.out.println(cell);//打印
				}
			}
		}
	}
}
