package sn.faty.GestionStock.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Builder
@Data
public class CategoryDTO {
    private Long id ;
    private String codeCategory ;
    private String designation ;
    @JsonIgnore
    private List<ArticleDTO> articles ;

}
