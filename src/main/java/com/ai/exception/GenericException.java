package com.ai.exception;

import java.io.Serializable;

public class GenericException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    String errorCode;

    String errorMessage;

    public GenericException() {

    }

    /**
     * 构造器.<br>
     * 
     * @param message
     *            异常信息
     * @ServiceMethod
     */
    public GenericException(String message) {
        super(message);
    }

    /**
     * 构造器.<br>
     * 
     * @param oriEx
     *            异常对象
     * @ServiceMethod
     */
    public GenericException(Exception oriEx) {
        super(oriEx);
    }
    
    public GenericException(Throwable oriEx) {
        super(oriEx);
    }

    /**
     * 构造器.<br>
     * 
     * @param message
     * @param oriEx
     * @ServiceMethod
     */
    public GenericException(String message, Exception oriEx) {
        super(message, oriEx);
    }
    
    public GenericException(String message, Throwable oriEx) {
        super(message, oriEx);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
