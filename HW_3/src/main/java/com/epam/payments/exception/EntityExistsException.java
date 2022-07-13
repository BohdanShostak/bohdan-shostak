package com.epam.payments.exception;

import com.epam.payments.service.model.enums.ErrorType;

public class EntityExistsException extends ServiceException {

    public EntityExistsException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.PROCESSING_ERROR_TYPE;
    }

}
