package sn.faty.GestionStock.handlers;

import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import sn.faty.GestionStock.exception.EntittyNotFoundException;
import sn.faty.GestionStock.exception.InvalidException;

@Builder
//@RestControllerAdvice
public class RestExceptionHandler  extends ResponseEntityExceptionHandler {
    ErrorDto errorDto=new ErrorDto();

    /**
     * @param exception
     * @param webRequest
     * @return
     */
    @ExceptionHandler(EntittyNotFoundException.class)

    public ResponseEntity<ErrorDto> handlerExceptionEntityNotFound(EntittyNotFoundException exception,WebRequest webRequest)
    {
      ErrorDto.builder()
                .httpCode(HttpStatus.NOT_FOUND.value())
                .message(exception.getMessage())
                .errorCodes(exception.getErrorCodes())
                .build();

        return  new ResponseEntity<>(errorDto,HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(InvalidException.class)
   public ResponseEntity<ErrorDto> handlerExceptionInvalid(InvalidException exception ,WebRequest webRequest)
   {
         ErrorDto.builder()
                 .errorCodes(exception.getErrorCodes())
                 .httpCode(HttpStatus.NOT_FOUND.value())
                 .message(exception.getMessage())
                 .build();
         return  new ResponseEntity<>(errorDto,HttpStatus.NOT_FOUND);
   }
}
