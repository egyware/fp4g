package com.egysoft.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public final class StringUtils 
{
	private StringUtils()
	{		
	}
	
	private static Pattern pattern = Pattern.compile("\\{(\\d)\\}"); 
	public static String format(String format, Object ...args)
	{
		StringBuilder sb = new StringBuilder(format);
		Matcher matcher = pattern.matcher(format);
		
		while(matcher.find())
		{
			int index = Integer.valueOf(matcher.group(1));
			sb.replace(matcher.start(), matcher.end(), args[index].toString());			
		}
		
		return sb.toString();		
	}

}
