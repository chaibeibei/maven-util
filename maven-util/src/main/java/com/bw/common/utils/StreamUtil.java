package com.bw.common.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**   
* @Title: StreamUtil.java 
* @Package com.bw.common.utils 
* @Description: TODO(流工具类) 
* @author Mr.Chai  
* @date 2019年12月6日 下午3:23:35 
* @version V1.0   
*/
public class StreamUtil {

	//批量删除多个打开的流
	public static void closeAll(AutoCloseable... autoCloseables ) {
		if(autoCloseables!=null) {
			for(AutoCloseable autoCloseable:autoCloseables) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	//以流的方式，读取文本文件的内容
	public static String readTextFile(File file) {
		FileInputStream fileInputStream = null;
		try {
			 fileInputStream = new FileInputStream(file);
			byte[] b=new byte[1024];
			String str=null;
			try {
				while(fileInputStream.read(b)!=-1) {
					str+=new String(b);
				}
				return str;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return null;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return null;
		}finally {
			closeAll(fileInputStream);
		}

	}
	public static String readTextFile(String fileName) {
		return readTextFile(new File(fileName));
	}
	//将读取到的内容写入文件
	public static  void writeTextFile(String context,File file,boolean append) {
		//判断要写入的文件夹是否存在
		String parent = file.getParent();
		File file2 = new File(parent);
		//如果不存在则创建
		if(!file2.exists()) {
			file2.mkdirs();
		}
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file,append));
			writer.write(context);
			writer.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(writer);
		}
		
	}
	public static void writeTextFile(String context,String fileName,boolean append) {
		writeTextFile(context,new File(fileName),append);
	}
	
	//测试
	public static void main(String[] args) {
		
	String readTextFile = readTextFile("C:\\Users\\ASUS\\Desktop\\day6d代码\\common-utils\\common-utils\\pom.xml");
	writeTextFile(readTextFile,"C:\\Users\\ASUS\\Desktop\\qq\\aa.txt",true);
	}
}
