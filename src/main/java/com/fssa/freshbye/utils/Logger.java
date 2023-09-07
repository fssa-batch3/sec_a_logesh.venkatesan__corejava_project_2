package com.fssa.freshbye.utils;

public class Logger {
public void error(Exception e) {
	e.printStackTrace();
}
public void debug(Object e) {
	System.out.println(e);
}
}
