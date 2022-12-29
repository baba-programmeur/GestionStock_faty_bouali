package sn.faty.gestionstock.exception;

import lombok.Getter;
import lombok.Setter;

public class InvalidOperationException extends RuntimeException {
    @Getter
    ErrorCodes errorCodes ;
    public InvalidOperationException(String message,ErrorCodes errorCodes) {
    }
}
