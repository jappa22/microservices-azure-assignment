package com.azure.assignment.product.search.service.Exception;

public class InternalServiceException extends Throwable {

    private String errorMessage;
    private String errorCode;

    public InternalServiceException(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
}
