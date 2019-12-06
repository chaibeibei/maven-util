package com.bw.common.utils;

import java.util.Random;

/**   
* @Title: RandomUtil.java 
* @Package com.bw.common.utils 
* @Description: TODO(随机工具类) 
* @author Mr.Chai  
* @date 2019年12月6日 下午7:24:52 
* @version V1.0   
*/
public class RandomUtil {

	//获得最小数与最大数之间的随机数
	public static int randomNum(int max,int min) {
		Random random = new Random();
		return min+random.nextInt(max-min+1);
	}
	//获得最小数与最大数之间的多个随机数
	public static int[] randomNums(int max,int min,int num) {
		int[] intarr=new int[num];
		for(int i=0;i<num;i++) {
			intarr[i]=randomNum(max, min);
			//System.out.println(intarr[i]);
		}
		return intarr;
	}
	
	//测试
	public static void main(String[] args) {
		/*System.out.println(randomNum(6, 1));*/
		for (int inarr : randomNums(6,1,3)) {
			System.out.println(inarr);
		}

	}
}
