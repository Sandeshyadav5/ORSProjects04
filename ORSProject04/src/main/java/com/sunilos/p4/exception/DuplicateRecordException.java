package com.sunilos.p4.exception;

/**
 * DuplicateRecordException thrown when a duplicate record occurred
 * 
 * @author  Durgesh Lohiya
 * @version 1.0
 * Copyright (c) Rays EdTech
 * 
 */

public class DuplicateRecordException extends RuntimeException {

	/**
	 * @param msg error message
	 */
	public DuplicateRecordException(String msg) {
		super(msg);
	}

}
