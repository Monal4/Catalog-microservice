package com.music.CatalogService.Exceptions;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceException() {
		super();
	}

	public ServiceException(String arg0) {
		super(arg0);
	}
    public ServiceException(String reason, Throwable cause){
        super(reason, cause);
    }
}
