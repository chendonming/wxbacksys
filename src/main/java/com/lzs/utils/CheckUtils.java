package com.lzs.utils;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckUtils {
	/** 
	  * 手机号验证 
	  * @return 验证通过返回true 
	  */  
	 public static boolean isMobile(final String str) {  
	     Pattern p = null;  
	     Matcher m = null;  
	     boolean b = false;  
	     p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号  
	     m = p.matcher(str);  
	     b = m.matches();  
	     return b;  
	 }
	 
	 	/**
	     * 身份证号是否基本有效
	     * @return 验证通过返回true 
	     */
	    public static boolean isIdcard(String s) {
	       int[] PARITYBIT = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };
	       int[] POWER_LIST = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10,
	                5, 8, 4, 2 };
	        if (s == null || (s.length() != 15 && s.length() != 18))
	            return false;
	        final char[] cs = s.toUpperCase().toCharArray();
	        // 校验位数
	        int power = 0;
	        for (int i = 0; i < cs.length; i++) {// 循环比正则表达式更快
	            if (i == cs.length - 1 && cs[i] == 'X')
	                break;// 最后一位可以是X或者x
	            if (cs[i] < '0' || cs[i] > '9')
	                return false;
	            if (i < cs.length - 1)
	                power += (cs[i] - '0') * POWER_LIST[i];
	        }
	        // 校验年份
	        String year = s.length() == 15 ? "19" + s.substring(6, 8) : s
	                .substring(6, 10);
	        final int iyear = Integer.parseInt(year);
	        if (iyear < 1900 || iyear > Calendar.getInstance().get(Calendar.YEAR)) {
	            return false;// 1900年的PASS，超过今年的PASS
	        }
	        // 校验月份
	        String month = s.length() == 15 ? s.substring(8, 10) : s.substring(10,
	                12);
	        final int imonth = Integer.parseInt(month);
	        if (imonth < 1 || imonth > 12)
	            return false;
	        // 校验天数
	        String day = s.length() == 15 ? s.substring(10, 12) : s.substring(12,
	                14);
	        final int iday = Integer.parseInt(day);
	        if (iday < 1 || iday > 31)
	            return false;
	        // 校验“校验码”
	        if (s.length() == 15)
	            return true;
	        return cs[cs.length - 1] == PARITYBIT[power % 11];
	    }

	    /**
	     * 判断一个字符串是否都为数字
	     * @return 验证通过返回true 
	     */
	    public static boolean isDigit(String strNum) {  
	        Pattern pattern = Pattern.compile("[0-9]{1,}");  
	        Matcher matcher = pattern.matcher((CharSequence) strNum);  
	        return matcher.matches();  
	    }
}
