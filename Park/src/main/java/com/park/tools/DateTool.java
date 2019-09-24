package com.park.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTool {
	public static String getDate() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		String dateStr = dateFormat.format(now);
		return dateStr;
	}
	
	public static String getNowWeekBegin() {
		int mondayPlus;
		Calendar cd = Calendar.getInstance();
		// 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
	    if(dayOfWeek==0){//0代表周日，6代表周六  
	        dayOfWeek += 7;  
	    }  
		if (dayOfWeek == 1) {
		mondayPlus = 0;
		} else {
		mondayPlus = 1 - dayOfWeek;
		}
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus);
		Date monday = currentDate.getTime();

		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);

		return preMonday + " 00:00:00";
	}
	public static String getNowWeekBeginEnd() {
		int mondayPlus;
		Calendar cd = Calendar.getInstance();
		// 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
		if (dayOfWeek == 1) {
		mondayPlus = 0;
		} else {
		mondayPlus = 1 - dayOfWeek;
		}
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus);
		Date monday = currentDate.getTime();

		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);

		return preMonday + " 23:59:59";
	}
	
	public static Date returnDate(String strDate) {
		Date date = null;
		
        //注意：SimpleDateFormat构造函数的样式与strDate的样式必须相符
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //加上时间
        //必须捕获异常
        try {
            date=sDateFormat.parse(strDate);
            System.out.println(date);
        } catch(ParseException px) {
            px.printStackTrace();
        }
		return date;
    }
	public static Date returnDate2(String strDate) {
		Date date = null;
		
        //注意：SimpleDateFormat构造函数的样式与strDate的样式必须相符
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //加上时间
        //必须捕获异常
        try {
            date=simpleDateFormat.parse(strDate);
        } catch(ParseException px) {
            px.printStackTrace();
        }
		return date;
    }
	public static String getStrDate(Date d) {
		SimpleDateFormat s= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = s.format(d);
		return dateStr;
	}
	
	public static String nextStrDate(String strDate) {
		Date d1 = DateTool.returnDate(strDate);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(d1);
		calendar.add(calendar.DATE,1);
		Date d2=calendar.getTime();
		String strDate2 = getStrDate(d2);
		//把日期往后增加一年.整数往后推,负数往前移动    calendar.add(calendar.DAY_OF_MONTH, 1);
		//把日期往后增加一个月.整数往后推,负数往前移动    calendar.add(calendar.DATE,1);
		//把日期往后增加一天.整数往后推,负数往前移动     calendar.add(calendar.WEEK_OF_MONTH, 1);
		//把日期往后增加一个月.整数往后推,负数往前移动    date=calendar.getTime();
		System.out.println(strDate+"\r\n"+strDate2);
		return strDate2;
	}
	public static String lastHalfYear(String strDate) {
		Date d1 = DateTool.returnDate(strDate);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(d1);
		calendar.add(calendar.DATE,-180);
		Date d2=calendar.getTime();
		String strDate2 = getStrDate(d2);
		//把日期往后增加一年.整数往后推,负数往前移动    calendar.add(calendar.DAY_OF_MONTH, 1);
		//把日期往后增加一个月.整数往后推,负数往前移动    calendar.add(calendar.DATE,1);
		//把日期往后增加一天.整数往后推,负数往前移动     calendar.add(calendar.WEEK_OF_MONTH, 1);
		//把日期往后增加一个月.整数往后推,负数往前移动    date=calendar.getTime();
		System.out.println(strDate+"\r\n"+strDate2);
		return strDate2;
	}
	public static String NextMonthDate(String strDate) {
		Date d1 = DateTool.returnDate(strDate);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(d1);
		calendar.add(calendar.DATE,30);
		Date d2=calendar.getTime();
		String strDate2 = getStrDate(d2);
		//把日期往后增加一年.整数往后推,负数往前移动    calendar.add(calendar.DAY_OF_MONTH, 1);
		//把日期往后增加一个月.整数往后推,负数往前移动    calendar.add(calendar.DATE,1);
		//把日期往后增加一天.整数往后推,负数往前移动     calendar.add(calendar.WEEK_OF_MONTH, 1);
		//把日期往后增加一个月.整数往后推,负数往前移动    date=calendar.getTime();
		System.out.println(strDate+"\r\n"+strDate2);
		return strDate2;
	}
	public static String nextWeekDate(String strDate) {
		Date d1 = DateTool.returnDate(strDate);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(d1);
		calendar.add(calendar.DATE,7);
		Date d2=calendar.getTime();
		String strDate2 = getStrDate(d2);
		//把日期往后增加一年.整数往后推,负数往前移动    calendar.add(calendar.DAY_OF_MONTH, 1);
		//把日期往后增加一个月.整数往后推,负数往前移动    calendar.add(calendar.DATE,1);
		//把日期往后增加一天.整数往后推,负数往前移动     calendar.add(calendar.WEEK_OF_MONTH, 1);
		//把日期往后增加一个月.整数往后推,负数往前移动    date=calendar.getTime();
		System.out.println(strDate+"\r\n"+strDate2);
		return strDate2;
	}
	public static int differentDaysByMillisecond(Date date1,Date date2)
    {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days;
    }
	
	public static String getMonthBegin() {
		SimpleDateFormat s= new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();    
	    c.add(Calendar.MONTH, 0);
	    c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
	    String first = s.format(c.getTime());
	    return first + " 00:00:00";
	}
	
	public static String getMonthEnd() {
		 //获取当前月最后一天
		SimpleDateFormat s= new SimpleDateFormat("yyyy-MM-dd");
	    Calendar ca = Calendar.getInstance();    
	    ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));  
	    String last = s.format(ca.getTime());
	    return last + " 23:59:59";
	}
}
