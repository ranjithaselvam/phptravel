package com.atmecs.dateAndTime;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateAndTime {
	public  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy "
			+ "HH:mm:ss");  
	public Date currentDate = new Date();
	public Calendar calender = Calendar.getInstance();
	
	
	public String dateAndTime()
	{
		 LocalDateTime now = LocalDateTime.now();
		    String format = dtf.format(now);
		    String Str = new String(format); 
		    Calendar c = Calendar.getInstance();
		    String displayName = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
		    return(Str.replace("11",displayName)); 
	   
	
}

}
