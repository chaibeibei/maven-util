package com.bw.common.utils;

import java.util.Random;

/**   
* @Title: StringUtil.java 
* @Package com.bw.common.utils 
* @Description: TODO(判断字符串是否为空) 
* @author Mr.Chai  
* @date 2019年12月5日 下午2:09:23 
* @version V1.0   
*/
public class StringUtil {

	//判断字符串是否为空
	public static boolean isBlank(String str) {
		if(str==null) {
			return false;
		}
		//去空格
		str = str.trim();
		if(str.length()==0) {
			return false;
		}
		
		return true;
	}
	
	//判断字符串是否不为空
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}
	
	//验证字符串是否是手机号
	public static boolean isPhoneNum(String str) {
		String num="1[35678]\\d{9}";
		return str.matches(num);
	}
	
	//验证邮箱
	public static boolean isEmail(String str) {
		String email="\\w+@\\w+\\.\\w+";
		return str.matches(email);
	}
	
	//验证身份证号
	public static boolean isIdCardNum(String str) {
		String IdCardNum="\\d{17}(\\d|X)";
		return str.matches(IdCardNum);
	}
	//获取随机字符
	public static char getRandChar() {
		Random random = new Random();
		//开始字符在acsii码
		int startChar='a'+0;
		char newChar=(char) (startChar+random.nextInt(26));
		return newChar;
	}
	
	//获取随机数字字符
	public static char getRandomnum() {
		Random random = new Random();
		int startChar='0'+0;
		char newChar=(char) (startChar+random.nextInt(10));
		return newChar;
	}
	//获取随机字符串
	public static String getRandomLett(int num) {
		StringBuffer stringBuffer = new StringBuffer();
		for(int i=0;i<num;i++) {
			char randChar = getRandChar();
			stringBuffer.append(randChar);
		}
		return stringBuffer.toString();
	}
	
	//获取随机字符串包括数字
	public static String getRandom(int num) {
		StringBuffer stringBuffer = new StringBuffer();
		Random random = new Random();
		for(int i=0;i<num;i++) {
			if(random.nextInt(36)>10) {
				stringBuffer.append(getRandChar());
			}else {
				stringBuffer.append(getRandomnum());
			}
		}
		return stringBuffer.toString();
	}
	//验证
	public static void main(String[] args) {
		
		/*System.out.println(isPhoneNum("12245635823"));*/
		/*System.out.println(isEmail("1204093998@qq.com"));*/
		/*System.out.println(isIdCardNum("12345245632147852X"));*/
		/*System.out.println(getRandChar());*/
		/*System.out.println(getRandomnum());*/
		/*System.out.println(getRandomLett(4));*/
		System.out.println(getRandom(4));
	}
	
}
