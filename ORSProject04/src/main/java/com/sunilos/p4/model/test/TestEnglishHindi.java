package com.sunilos.p4.model.test;

import java.util.Locale;
import java.util.ResourceBundle;


public class TestEnglishHindi {
	public static void main(String[] args) {
		
		ResourceBundle rb = ResourceBundle.getBundle("message", new Locale("hi"));
		
		System.out.println(rb.getString("button.save"));
	}

}
