package sn.faty.gestionstock.handlers;

import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import sn.faty.gestionstock.exception.EntittyNotFoundException;
import sn.faty.gestionstock.exception.ErrorCodes;
import sn.faty.gestionstock.exception.InvalidException;
import sn.faty.gestionstock.exception.InvalidOperationException;

import java.util.Collections;

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
    @ExceptionHandler(InvalidOperationException.class)
    public ResponseEntity<ErrorDto> handlerExceptionInvalid(InvalidOperationException exception ,WebRequest webRequest)
    {
        ErrorDto.builder()
                .errorCodes(exception.getErrorCodes())
                .httpCode(HttpStatus.NOT_FOUND.value())
                .message(exception.getMessage())
                .build();
        return  new ResponseEntity<>(errorDto,HttpStatus.BAD_REQUEST);
    }
//    @ExceptionHandler(BadCredentialsException.class)
//    public ResponseEntity<ErrorDto> handleException(BadCredentialsException exception, WebRequest webRequest) {
//        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
//
//        final ErrorDto errorDto = ErrorDto.builder()
//               // .code(ErrorCodes.BAD_CREDENTIALS)
//                .httpCode(badRequest.value())
//                .message(exception.getMessage())
//                .message(Collections.singletonList("Login et / ou mot de passe incorrecte").toString())
//                .build();
//
//        return new ResponseEntity<>(errorDto, badRequest);
//    }
}
