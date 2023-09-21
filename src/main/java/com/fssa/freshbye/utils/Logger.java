package com.fssa.freshbye.utils;

public class Logger {
public void error(Exception e) {
	e.printStackTrace();//logger.error()
}
public void debug(Object e) {
	System.out.println(e);
}
}
