package sn.faty.GestionStock.exception;

import lombok.Getter;

public class EntittyNotFoundException extends RuntimeException {

    @Getter
    private ErrorCodes errorCodes ;

    public EntittyNotFoundException(String message)
    {
        super(message);
    }

    public EntittyNotFoundException(String message, Throwable cause)
    {
        super(message,cause);
    }
    public EntittyNotFoundException(String message, ErrorCodes errorCodes)
    {
        super(message);
        this.errorCodes=errorCodes ;
    }


    public EntittyNotFoundException(String message , Throwable cause, ErrorCodes errorCodes)
    {
        super(message, cause);
        this.errorCodes=errorCodes ;
    }
}
