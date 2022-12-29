package sn.faty.gestionstock.handlers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.faty.gestionstock.exception.ErrorCodes;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorDto {


    private  Integer httpCode ;
    private ErrorCodes errorCodes ;
    private String message ;
    private List <String> listError= new ArrayList<>();


}
