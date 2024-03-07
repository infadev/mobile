package com.bt.booking.mobile.exception;

public class MobileBookingException extends RuntimeException {

    protected String errDesc;

    public MobileBookingException(String errDesc) {
        super(errDesc);
        this.errDesc = errDesc;
    }

    public MobileBookingException(String message, Throwable cause) {
        super(message, cause);
        this.errDesc = message;
    }

    public String getErrDesc() {
        return errDesc;
    }

}
