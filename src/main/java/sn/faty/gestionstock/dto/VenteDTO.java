package sn.faty.gestionstock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

/**
 *
 *
 *
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class VenteDTO {
    private Long id ;
    private  String code;
    private Instant dtVente ;
    private  String commentaire ;
    private List<LigneVenteDTO> ligneVentes ;
}
