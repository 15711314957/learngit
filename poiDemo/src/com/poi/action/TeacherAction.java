package com.poi.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.poi.bean.Teacher;
import com.poi.service.TeacherService;
import com.poi.util.ExcelUtil;
import com.poi.util.FileUpload2;

@Controller
public class TeacherAction {
@Resource
private TeacherService teacherService;
private ModelAndView modelAndView=new ModelAndView();
@RequestMapping(value="/selectTea")
public ModelAndView getTea(){
	System.out.println("查询");
	List<Teacher> teachers = teacherService.getTeachers();
	modelAndView.addObject("teachers", teachers);
	modelAndView.setViewName("showlist.jsp");
	return modelAndView;
}
@RequestMapping(value="/export")
public String exportEmployee(HttpServletResponse response ) throws Exception{
	
		Workbook wb=new HSSFWorkbook();
		String[] headers={"编号","姓名","性别"};
		List<Teacher> teachers = teacherService.getTeachers();
		ExcelUtil.excelOut(teachers, wb, headers);
		String fileName="导出.xls";//导出生产的工作薄名
		ExcelUtil.export(response, wb, fileName);
	return null;
}

@RequestMapping(value="/export2")
public void exportEmployeeModel(HttpServletResponse response ) throws Exception{
		List<Teacher> teachers = teacherService.getTeachers();
		String fileName="导出.xls";//导出生产的工作薄名
		Workbook wb = ExcelUtil.excelOutModel(teachers, "模板.xls");//模板的名称
		ExcelUtil.export(response, wb, fileName);
}


@RequestMapping(value="/uploadUser")
public ModelAndView upload(@Param("user") MultipartFile  user,HttpServletRequest request)throws Exception{
	System.out.println("=======导入========");
	InputStream fs =null;
	fs = user.getInputStream();
	HSSFWorkbook wb=new HSSFWorkbook(fs);//将流放到工作薄
	HSSFSheet hssfSheet=wb.getSheetAt(0);//获取第一个Sheet页
	Teacher teacher=new Teacher();
	if(hssfSheet!=null){
		//从以开始，第一行是列头所以从第二行读取
		for(int rowNum=1;rowNum<=hssfSheet.getLastRowNum();rowNum++){
			HSSFRow hssfRow=hssfSheet.getRow(rowNum);//获取行
			if(hssfRow==null){
				continue;
			}
			//转型
			teacher.setName(ExcelUtil.formatCell(hssfRow.getCell(0)));
			teacher.setSex(ExcelUtil.formatCell(hssfRow.getCell(1)));
			teacherService.addTeacher(teacher);
		}
	}
	modelAndView.setViewName("selectTea.action");
	fs.close();
	return modelAndView;
}
}
