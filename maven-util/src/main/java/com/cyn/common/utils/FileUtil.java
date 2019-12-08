package com.cyn.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**   
* @Title: FileUtil.java 
* @Package com.bw.common.utils 
* @Description: TODO(封装文件的常用方法) 
* @author Mr.Chai  
* @date 2019年12月6日 下午1:42:13 
* @version V1.0   
*/
public class FileUtil {

	//根据文件获取拓展名
	public static String getEndName(String fileName) {
		//如果拓展名为空
		if(fileName == null || "".equals(fileName)) {
			throw new RuntimeException("文件名不能为空");
		}
		//如果没有拓展名
		if(fileName.indexOf(".")<=-1) {
			throw new RuntimeException(fileName+"该文件没有拓展名");
		}
		//获取拓展名
		String endName = fileName.substring(fileName.lastIndexOf("."));
		return endName;
	}
	
	//按行读取文件内容到list集合
	public static List<String> getFileContext(String path) {
		try {
			FileReader fileReader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			List<String> list=new ArrayList<String>();
			String str=null;
			try {
				while((str=bufferedReader.readLine()) !=null) {
					if(str.trim().length()>2) {
						list.add(str);
					}
				}
				return list;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return null;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
		
	}
	 
	//使用递归删除文件
	public static void deleteFile(File file) {
		File[] files=file.listFiles();
		
		if(files !=null && files.length !=0) {
			for(int i=0;i<files.length;i++) {
				deleteFile(files[i]);
			}
		}
		file.delete();
	}
	public static void deleteFile(String filePath) {
		deleteFile(new File(filePath));
	}
	
	//根据文件获取文件大小
	public static String getFileSize(String fileName) {
		File file = new File(fileName);
		long length = file.length();
		double l=length/1024.0;
		return String.format("%.2f", l)+"kb";
	}
	//测试
	public static void main(String[] args) {
		/*System.out.println(getEndName("1.txt"));*/
		/*deleteFile("C:\\Users\\ASUS\\Desktop\\新建文件夹");*/
		/*System.out.println(getFileContext("C:\\Users\\ASUS\\Desktop\\配置文件2\\web.xml"));*/
		System.out.println(getFileSize("C:\\Users\\ASUS\\Desktop\\配置文件2\\web.xml"));
	}
	
}
