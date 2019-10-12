package com.zhiyou100.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.csource.common.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.FastDFSUtil;
import com.zhiyou100.model.ResponseObject;

@Controller
public class AjaxController {
	
//	@RequestMapping("/upload")
//	@ResponseBody
//	public ResponseObject ajaxUpload(MultipartFile img, HttpServletRequest request) throws IOException {
//		// 1.获得上传的对象
//		
//		// 2.获得最终上传的目的地路径(上传至服务器中当前项目下)
//		String realPath = request.getServletContext().getRealPath("/upload");
//		System.out.println("上传"+realPath);
//	
//		// 2.1 将最终的目的文件夹创建出来
//		File file = new File(realPath);
//		// 判断该文件是否存在
//		if(file.exists()){
//			// 不存在则创建出
//			file.mkdir();
//		}
//		// 2.2 获得文件名
//		// 文件名重复时不能重复上传文件
//		String fileName = img.getOriginalFilename();
//		
//		// 把文件名封装进对象
//		
//		
//		System.out.println("文件名: "+fileName);
//		// 2.3 确定上传路径
//		File newFile = new File(file,fileName);
//		
//		// 3.上传
//		FileUtils.writeByteArrayToFile(newFile, img.getBytes());
//
//
//		request.setAttribute("path", "/upload/"+fileName);
//		String path = "/upload/"+fileName;
//	
//		return new ResponseObject("200","成功",path);
//	}
	
	@RequestMapping("/FastDFSupload")
	@ResponseBody
	public ResponseObject FastDFSUpload(MultipartFile img) throws IOException, MyException {
		ResponseObject abc = FastDFSUtil.upload(img);
		return abc;
	
	}
	
	@RequestMapping("/download")
	public void ajaxDownload(String fid,HttpServletResponse resp) throws IOException, MyException {
		System.err.println("接收到的fid: "+fid);
		byte[] bytes = FastDFSUtil.download(fid);
		resp.setHeader("Content-disposition", "attachment;filename="+new Date().getTime()+".jpg");
		resp.setContentType("image/jpeg");
		ServletOutputStream outputStream = resp.getOutputStream();
		outputStream.write(bytes);
		outputStream.flush();
		outputStream.close();
	}
	
}
