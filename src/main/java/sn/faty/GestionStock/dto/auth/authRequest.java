package sn.faty.gestionstock.dto.auth;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class authRequest {
    private  String login ;
    private String mdp ;
}
