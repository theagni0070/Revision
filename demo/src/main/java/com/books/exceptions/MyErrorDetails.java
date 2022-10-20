package com.books.exceptions;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class MyErrorDetails {
	
	private String desc;
	private LocalDate date;
	private String message;
	
}
