package com.bw.common.utils;
/**   
* @Title: DateUtil.java 
* @Package com.bw.common.utils 
* @Description: TODO(根据年份求年龄) 
* @author Mr.Chai 
* @date 2019年12月5日 下午1:28:41 
* @version V1.0   
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



public class DateUtil {

	 public static int getAge(String birthDate) {
		 //获取日历控件
		 Calendar calendar=Calendar.getInstance();
		 int nowyear = calendar.get(Calendar.YEAR);
		 int nowmoth = calendar.get(Calendar.MONTH);
		 int nowDay =   calendar.get(Calendar.DAY_OF_MONTH);
		 //设置生日
		 
		 calendar.setTime(java.sql.Date.valueOf(birthDate));
		 int birthyear = calendar.get(Calendar.YEAR);
		 int birthmoth = calendar.get(Calendar.MONTH);
		 int birthDay = calendar.get(Calendar.DAY_OF_MONTH);
		 //获取年龄
		 int age=nowyear-birthyear;
		 if((birthmoth==nowmoth && birthDay>nowDay) || birthmoth>nowmoth) {
			 age--;
		 }
		 return age;
	 }
	
	/* public static List<Date> getDayNum(String startDate,String endDate) {
		 SimpleDateFormat sdf = new SimpleDateFormat();
		 Date startDate1=java.sql.Date.valueOf(startDate);
		 Date endDate1=java.sql.Date.valueOf(endDate);
		 List list = new ArrayList();
		 list.add(startDate);
		 Calendar c = Calendar.getInstance();
		 //使用给定的时间设置此calender时间
		 c.setTime(startDate1);
		 Calendar c2 = Calendar.getInstance();
		 c2.setTime(endDate1);
		 //测试此日期是否在指定日期之后
		 while(endDate1.after(c.getTime())) {
			c.add(Calendar.DAY_OF_MONTH,1);
			list.add(c.getTime());
		 }
		 return list;
		 
		 
	 }*/
	 
	//获取开始日期和结束日期之间有多少天  
	 public static int getDayNum(String startDate,String endDate) {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 try {
			Date start = sdf.parse(startDate);
			Date end = sdf.parse(endDate);
			return (int) Math.ceil((end.getTime()-start.getTime())/(24*60*60*1000d));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return 1;
		}
		 
	 }
	 
	 //计算指定日期距离今天，过去了多少天或还有多少天 
	 public static int getDayNum(String date) {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date dat;
			try {
				dat = sdf.parse(date);
				Date date2 = new Date();
				String string = date2.toString();
				//return getDayNum(date, string);
				return (int) Math.abs((dat.getTime()-date2.getTime())/(24*60*60*1000d));

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				return 1;
			}
			
	 }
	 
	 //判断日期是不是今天
	 public static boolean isToday(String date) {
		 //获取当前日期
		 Date date2 = new Date();
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 //对比时间
		 String dat = format.format(date2);
		
		 return dat.equals(date);
	 }
	 //判断日期是不是本周
	 public static boolean isThisWeek(String theDate) {
		 Calendar cal = Calendar.getInstance();
		 int nowYear = cal.get(Calendar.YEAR);
		 int nowWeek = cal.get(Calendar.WEEK_OF_YEAR);
		 java.sql.Date date = java.sql.Date.valueOf(theDate);
		 cal.setTime(date);
		 int theYear = cal.get(Calendar.YEAR);
		 int theWeek = cal.get(Calendar.WEEK_OF_YEAR);
		 return nowYear == theYear && nowWeek == theWeek;
	 }
	 
	//获取指定日期月份的第一天
		 public static String getFirstDayOfMonth(String date) {
			 java.sql.Date date2 = java.sql.Date.valueOf(date);
			 Calendar calendar = Calendar.getInstance();
			 calendar.setTime(date2);
			 //获取末月最小天数
			 int first = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
			 System.out.println(first+"+++");
			 calendar.set(Calendar.DAY_OF_MONTH, first);
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 
			 return sdf.format(calendar.getTime());
			 
		 }
	 
	 //获取指定日期月份的最后一天
	 public static String getEndDayOfMonth(String date) {
		 java.sql.Date date2 = java.sql.Date.valueOf(date);
		 Calendar calendar = Calendar.getInstance();
		 calendar.setTime(date2);
		//获取末月最大天数
		 int last = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		 System.out.println(last+"---");
		 calendar.set(Calendar.DAY_OF_MONTH, last);
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 
		 return sdf.format(calendar.getTime());
		 
	 }
	 
	 //判断输入的两个日期是否相等，大于返回1，等于返回0，小于返回-1
	 public static int comparaTime(String date1,String date2) {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			Date date3 = sdf.parse(date1);
			Date date4 = sdf.parse(date2);
			long time = date3.getTime();
			long time2 = date4.getTime();
			if(time>time2) {
				return 1;
			}
			if(time==time2) {
				return 0;
			}
			
				return -1;
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return 0;
		}
		
	 }
	 //测试
	 public static void main(String[] args) {
		
		 /*System.out.println(getAge("1998-12-12"));*/
		 /*System.out.println(getDayNum("2019-12-01", "2019-12-06"));*/
		 /*System.out.println(getDayNum("2019-12-05"));*/
		/* System.out.println(isToday("2019-12-06")?"是今天":"不是今天");*/
		/* System.out.println(isThisWeek("2019-12-09")?"是本周":"不是本周");*/
		 /*System.out.println("本月第一天："+getFirstDayOfMonth("2019-12-06"));
		 System.out.println("本月最后一天："+getEndDayOfMonth("2019-12-06"));*/
		 System.out.println(comparaTime("2019-12-06 15:20:22", "2019-12-06 15:21:22"));
	 }
	
}
