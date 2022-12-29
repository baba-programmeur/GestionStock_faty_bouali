package sn.faty.gestionstock.service.implementation;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sn.faty.gestionstock.dto.ArticleDTO;
import sn.faty.gestionstock.dto.CategoryDTO;
import sn.faty.gestionstock.dto.ClientDTO;
import sn.faty.gestionstock.exception.EntittyNotFoundException;
import sn.faty.gestionstock.exception.ErrorCodes;
import sn.faty.gestionstock.exception.InvalidException;
import sn.faty.gestionstock.service.Interface.ArticleService;
import sn.faty.gestionstock.service.Interface.CategoryService;
import sn.faty.gestionstock.service.Interface.ClientService;
import sn.faty.gestionstock.service.Interface.UtilisateurService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryImplTest {

      @Autowired
    private CategoryService categoryService ;

      @Autowired
      private ArticleService articleService ;

      @Autowired
      private ClientService clientService ;

      @Autowired
      private UtilisateurService utilisateurService ;


     @Test
      public  void testCategorySaved(){

   CategoryDTO categoryDTO= CategoryDTO.builder()
                 .codeCategory("category1")
                 .designation("tres joli")
                 .idEntreprise((long) 2)
                  .id((long) 1.0)
                 .build();
   CategoryDTO categoryExpected=categoryService.saveCategory(categoryDTO);
   //On verfie si categoryExpected est null et verfier si les identifiants sont non nuls

         Assertions.assertNotNull(categoryExpected);
         Assertions.assertNotNull(categoryExpected.getId());
         Assertions.assertEquals(categoryExpected.getCodeCategory(),categoryDTO.getCodeCategory());
         Assertions.assertEquals(categoryExpected.getDesignation(),categoryDTO.getDesignation());

      }

    @Test
      public  void TestInvalidException(){
        CategoryDTO categoryDTOExpected= CategoryDTO.builder().build();

     InvalidException exception=assertThrows(InvalidException.class, ()-> categoryService.saveCategory(categoryDTOExpected));

     assertEquals(ErrorCodes.CATEGORY_NOT_VALID,exception.getErrorCodes());

    }
    @Test
    public  void TestNotFoundException(){

         EntittyNotFoundException exception=assertThrows(EntittyNotFoundException.class, ()-> categoryService.findById(124L));

        assertEquals(ErrorCodes.CATEGORY_NOT_FOUND,exception.getErrorCodes());
    }
    @Test
    public  void testArticleSaved(){

        ArticleDTO articleDTO= ArticleDTO.builder()
                  .prixUnitaire(1300)
                  .codeArticle("article bon")
                .designation("joli trouble shouting")
                .build();
        ArticleDTO articleDTOExcepted=articleService.saveArticle(articleDTO);
        //On verfie si lobjet est null et verfier si les identifiants sont non nuls

        assertNotNull(articleDTOExcepted);
        assertNotNull(articleDTOExcepted.getId());
        Assertions.assertEquals(articleDTOExcepted.getDesignation(),articleDTO.getDesignation());
       // Assertions.assertEquals(articleService.getDesignation(),categoryDTO.getDesignation());

       /* private String codeArticle ;
        private  String designation ;
        private BigDecimal prixUnitaireHt ;
        private BigDecimal prixUnitaireTtc ;
        private BigDecimal tauxTva ;
        */

    }

    @Test
    public  void testClientSaved(){

       ClientDTO clientDTO= ClientDTO.builder()
                 .nom("FATY")
               .numTel("77 167 12 73")
               .mail("laminefaty5261@gmail.com")
               .prenom("Lamine")
               //.adresse()
                .build();
        ClientDTO clientDTORetourne=clientService.saveClient(clientDTO);

        //On verfie si lobjet est null et verfier si les identifiants sont non nuls
        assertNotNull(clientDTORetourne);
     //   assertNotNull(clientDTORetourne.getId());category
        Assertions.assertEquals(clientDTO.getNom(),clientDTORetourne.getNom());

    }
    @Test(expected = EntittyNotFoundException.class)

    public  void testCategoryNotFound(){
         categoryService.findById(12L);
    }
}