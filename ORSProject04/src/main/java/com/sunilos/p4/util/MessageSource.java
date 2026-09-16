package com.sunilos.p4.util;

import java.util.Locale;
import java.util.ResourceBundle;

public final class MessageSource {

	public static String ENGLISH_LANG_CODE = "en"; //  3 single tone bana ya hai
	public static String HINDI_LANG_CODE = "hi";
	public static String DEFAULT_LANGUAGE = ENGLISH_LANG_CODE ;
	
	private static MessageSource ms = null; 
	
	private static ResourceBundle rb = null;
	
	private MessageSource() {
		this(DEFAULT_LANGUAGE);
	}
	
	private MessageSource(String lang) {
		rb = ResourceBundle.getBundle("message", new Locale(lang)); // internall chalege gai or load hoga
	}
	
	private MessageSource(Locale locale) {
		this(locale.getLanguage()); /// internally call hoga
	}
	
	public static MessageSource getInstance() {
		return getInstance(DEFAULT_LANGUAGE); 
	}
	
	public static MessageSource getInstance(String languageCode) {
		
		if(ms == null) {
			ms = new MessageSource(languageCode);
		}
		return ms;
		
	}
	
	public void setLocale(String lang) {
		rb = ResourceBundle.getBundle("message", new Locale(lang)); // lang change karta ha
		
	}
	
	public String getLanguage() {
		return rb.getLocale().getLanguage(); // current lang nikalata ha
		
	}
	
	public String get(String key) {
		String val = "";
		
		try {
			val = rb.getString(key);
		}
			catch(Exception e) {
				e.printStackTrace();
			}
		return val; // method me key ke accound val nikalta ha
		
	}
	
	public static void main(String[] args) {
		
		MessageSource ms = MessageSource.getInstance("hi");
		String val = ms.get("login.userid");
		System.out.println("login id " + val);
	}

}
