package com.poi.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload2 {

	public static String upload(HttpServletRequest request, MultipartFile[] file,String path) throws Exception {
		// 得到项目下的fileupload绝对路径,传过来的path = "//fileupload//";  自定义目录
		path = request.getSession().getServletContext().getRealPath(path);
		String fileNameAppend = "";
		
		for (int i = 0; i < file.length; i++) {
			// 获得文件名
			String fileName = file[i].getOriginalFilename();
			// 判断文件是否为空,并且文件名不为空串
			if (!file[i].isEmpty() && !"".equals(fileName)) {
				//格式化日期
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
				// 用UUID来解决同名文件
				fileName = sdf.format(new Date()) + UUID.randomUUID().toString()
						+ file[i].getOriginalFilename().substring(file[i].getOriginalFilename().lastIndexOf("."));
				File newFile = new File(path + fileName);
				// 通过CommonsMultipartFile的方法直接写文件（注意这个时候）
				file[i].transferTo(newFile);
				fileNameAppend += "," + fileName;
			}
		}
		//判断文件名的下标是否越界
		if (fileNameAppend.indexOf(",") != -1) {
			fileNameAppend = fileNameAppend.substring(1);
		}
		//返回文件名
		return fileNameAppend;
	}
}
