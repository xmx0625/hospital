package com.zhiyou100;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.model.ResponseObject;

/**
 * @author WangJun
 * @date   2019年9月23日
 * @desc   测试FastDFS的javaAPI
 * 上传:
 * 下载:
 * 删除:
 */
public class FastDFSUtil {
	/*
	 * 1.依赖/jar
	 * FastDFS配置文件:
	 * 3.javaapi
	 * 		加载配置文件
	 * 		创建Tracker客户端
	 * 		通过Tracker客户端得到Tracker对象
	 *		通过Tracker得到Storage对象
	 *创建文件属性存储对象
	 *通过客户端
	 */
	public static ResponseObject upload(MultipartFile img) throws IOException, MyException {
		String fileName = img.getOriginalFilename();
		String[] split = fileName.split("\\.");
		String suffix = split[1];

		// 1. 加载配置文件
		ClientGlobal.init("D:\\JavaWorkSpace\\hospital\\src\\test\\resources\\fastdfs-client.properties");
		// 2. 创建管理端对象
		TrackerClient trackerClient = new TrackerClient();
		// 3. 通过管理端对象获取连接
		TrackerServer connection = trackerClient.getConnection();
		// 4. 创建存储端对象
		StorageClient1 storageClient1 = new StorageClient1(connection, null);

		// 创建文件属性信息对象数组
		NameValuePair[] list = new NameValuePair[1];
		list[0] = new NameValuePair("fileName",fileName);
		// 5. 上传文件
		/*
		 * 参数1:要上传的文件地址
		 * 参数2:要上传的文件类型
		 * 参数3:文件属性信息对象数组
		 * 返回值 : 存储在Storage中的地址
		 */

		String fid = storageClient1.upload_file1(img.getBytes(),suffix,list);
				
		System.out.println("上传成功: "+fid);
		String path = "http://java2101:80/"+fid;
		Map<String,String> map = new HashMap<>();
		map.put("path", path);
		map.put("fid", fid);
		return new ResponseObject("200","成功",map);		
			
	}
	
	public static byte[] download(String fid) throws IOException, MyException {
		// 1. 加载配置文件
				ClientGlobal.init("D:\\JavaWorkSpace\\hospital\\src\\test\\resources\\fastdfs-client.properties");
				// 2. 创建管理端对象
				TrackerClient trackerClient = new TrackerClient();
				// 3. 通过管理端对象获取连接
				TrackerServer connection = trackerClient.getConnection();
				// 4. 创建存储端对象
				StorageClient1 storageClient1 = new StorageClient1(connection, null);
				
				byte[] bytes = storageClient1.download_file1(fid);
				
				return bytes;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
