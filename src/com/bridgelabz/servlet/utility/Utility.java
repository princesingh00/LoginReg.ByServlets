package com.bridgelabz.servlet.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utility {

	public String date() {
		
		LocalDate myobj = LocalDate.now();
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String date = myobj.format(myFormat);
		return date;
	}
	
}
