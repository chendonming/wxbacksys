package com.lzs.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lzs.utils.ProUtil;
import com.lzs.utils.ReturnResult;


@Controller
@RequestMapping("/file")
public class FileController {
	
	private static final Logger logger = Logger.getLogger(FileController.class);
	
	private static final Map<String, String> extMap = new HashMap<String, String>();
	static{
		extMap.put("images", "gif,jpg,jpeg,png,bmp");
	}
	
//	@Resource
//	private FileService fileService;
	
	/**
	 * 上传文件
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public ReturnResult upload(@RequestParam(value = "file") MultipartFile[] uploadFiles) {
		String str = commonFileUpload(uploadFiles);
		return ReturnResult.success(str);
	}
	
	public String commonFileUpload(MultipartFile[] myfiles) {
		System.out.println(myfiles.length);
		//可以在上传文件的同时接收其它参数
        Map<String, String> map = new  HashMap<String,String>();
        
        String originalFilename = null;
        
        StringBuffer photoSrc = new StringBuffer();//StringBuffer用来存放上传文件的所有地址
        for(MultipartFile myfile : myfiles){
        	
            if(myfile.isEmpty()){
                map.put("result", "请选择文件后上传");
                map.put("success", "false");
                break;
            }
            
            String fileExt = myfile.getOriginalFilename().substring(myfile.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            
            if (!Arrays.<String> asList(extMap.get("images").split(",")).contains(fileExt)) {// 检查扩展名
	        	return "";
			}
            
            try {
	            BufferedImage bi = ImageIO.read(myfile.getInputStream());
            }catch(Exception ex) {
            	
            }
            
                originalFilename = String.valueOf(new DateTime().getMillis())+ myfile.getOriginalFilename().substring( myfile.getOriginalFilename().indexOf("."));
               try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					logger.error("",e1);
				}                
                try {
            		String realPath = ProUtil.getValue("file.path", "comm.properties") + "/";
            		//这里不必处理IO流关闭的问题,因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
            		//此处也可以使用Spring提供的MultipartFile.transferTo(File dest)方法实现文件的上传
            		FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, originalFilename));
            		//上传成功的时候将图片的地址给已经准备好的Stringbuffer
            		String imgUrl = ProUtil.getValue("imgUrl", "comm.properties");
            		photoSrc.append(imgUrl  + originalFilename + ",");
                } catch (IOException e) {
                   logger.error("上传失败:", e);    
                }
            }
        return photoSrc.toString().substring(0, photoSrc.toString().length()-1);
	}
}
