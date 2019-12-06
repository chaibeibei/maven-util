package com.bw.common.utils;
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
}
