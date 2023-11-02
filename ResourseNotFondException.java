package com.bms.exception;

import javax.print.DocFlavor.STRING;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourseNotFondException extends RuntimeException {
	private static final long serialVersionUID = 1L;	
private static String resourseName;
private String fieldName;
private Object fieldValue;



public ResourseNotFondException(String reresourseName,String fieldName,Object fieldValue) {
	super(String.format("%snot found with%s:'%s'", resourseName, fieldName,fieldValue));
	this.resourseName=resourseName;
	this.fieldName=fieldName;
	this.fieldValue=fieldValue;
}
	
}
