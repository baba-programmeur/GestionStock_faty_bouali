package sn.faty.gestionstock.exception;

import lombok.Getter;

import java.util.List;

public class InvalidException extends  RuntimeException{

    @Getter
    private  ErrorCodes errorCodes ;
   @Getter
    private List<String> listErrorCodes ;

    public InvalidException(String message )
    {
        super(message);
    }
    public InvalidException(String message ,Throwable cause)
    {
        super(message, cause);
    }

    public  InvalidException(String message ,Throwable cause,ErrorCodes errorCodes)

    {
        super(message, cause);
        this.errorCodes=errorCodes ;
    }

    public InvalidException(String message ,ErrorCodes errorCodes ,List<String> listErrorCodes)
    {
        super(message);
        this.errorCodes=errorCodes ;
        this.listErrorCodes=listErrorCodes ;
    }

    public InvalidException(String message, ErrorCodes savedPhoto) {
        super(message);
        this.errorCodes=savedPhoto ;
    }
}