package com.order.system.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
	public static String getNowDateTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String formatDateTime = now.format(formatter);
		return formatDateTime;
	}
	
	public static String getNowCurrentDateTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime now = LocalDateTime.now();
		String formatDateTime = now.format(formatter);
		return formatDateTime;
	}
	
}