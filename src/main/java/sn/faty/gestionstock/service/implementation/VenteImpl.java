package sn.faty.gestionstock.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sn.faty.gestionstock.Repository.ArticleRepository;
import sn.faty.gestionstock.Repository.LigneVenteRepository;
import sn.faty.gestionstock.Repository.VenteRepository;
import sn.faty.gestionstock.Validators.VenteValidator;
import sn.faty.gestionstock.dto.VenteDTO;
import sn.faty.gestionstock.exception.EntittyNotFoundException;
import sn.faty.gestionstock.exception.ErrorCodes;
import sn.faty.gestionstock.exception.InvalidException;
import sn.faty.gestionstock.exception.InvalidOperationException;
import sn.faty.gestionstock.model.Article;
import sn.faty.gestionstock.model.LigneVente;
import sn.faty.gestionstock.model.Ventes;
import sn.faty.gestionstock.service.Interface.VenteService;
import sn.faty.gestionstock.service.mappeur.LigneVenteImpl;
import sn.faty.gestionstock.service.mappeur.VenteMappeur;
import sn.faty.gestionstock.service.mappeur.VenteMappeurImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class VenteImpl implements VenteService {
    private VenteRepository venteRepository ;
    private ArticleRepository articleRepository ;
    private LigneVenteRepository ligneVenteRepository ;
    private VenteMappeur venteMappeur =new VenteMappeurImpl();

  @Autowired
    public VenteImpl(VenteRepository venteRepository,ArticleRepository articleRepository, LigneVenteRepository ligneVenteRepository) {
        this.venteRepository = venteRepository;
        this.articleRepository=articleRepository;
        this.ligneVenteRepository=ligneVenteRepository;
    }

    @Override
    public VenteDTO saveVente(VenteDTO venteDTO) {

        List<String> listErrors=VenteValidator.validerVente(venteDTO);

       if(! listErrors.isEmpty())
       {
           log.debug("");
           throw  new InvalidException("vente {} is not valid"+ venteDTO);
       }
          List<String> tabErrors=new ArrayList<>();

//         if (venteDTO.getLigneVentes()!=null) {
//             venteDTO.getLigneVentes().forEach(ligneVenteDTO ->
//             {
//                 Optional<Article> article = articleRepository.findById(ligneVenteDTO.getArticle().getId());
//                 if (article.isEmpty()) {
//                     tabErrors.add("Article with id {} is not in the database" + ligneVenteDTO.getArticle().getId());
//
//                 }
//             });
//         }

//            if (!tabErrors.isEmpty())
//             {
//                 throw new EntittyNotFoundException("",ErrorCodes.ARTICLE_NOT_FOUND);
//             }

           Ventes vente= venteRepository.save(venteMappeur.toEntity(venteDTO));

//               if(venteDTO.getLigneVentes()!=null)
//               {
//                   venteDTO.getLigneVentes().forEach(ligneVenteDTO -> {
//
//                       LigneVente ligneVente= LigneVenteImpl.toEntity(ligneVenteDTO);
//
//                        ligneVente.setVente(vente);
//                        ligneVenteRepository.save(ligneVente);
//                   });
//               }
         return  venteMappeur.toDto(vente);
    }
    @Override
    public List<VenteDTO> findAll() {
        return  venteRepository.findAll().stream()
                .map(venteMappeur::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        if(id==null)
        {
            log.debug("Your id is null");

            throw new EntittyNotFoundException("lid nexiste pas dans la base",ErrorCodes.VENTES_NOT_FOUND);
        }
        List<LigneVente> ligneVentes= ligneVenteRepository.findAllByVenteId(id);

        if (!ligneVentes.isEmpty()){

            throw  new InvalidOperationException("",ErrorCodes.Vente_DEJA_EFFECTUE);
        }
        else {
            venteRepository.deleteById(id);
        }
    }
    @Override
    public VenteDTO findById(Long id) {
        if(id==null)
        {
            log.debug("Your id is null");
        }
        return venteMappeur.toDto(venteRepository.findById(id)
                .orElseThrow(()->new EntittyNotFoundException("This Entreprise  is not in the database")));
    }

    @Override
    public VenteDTO findByCode(String code) {
        if(!StringUtils.hasText(code))
        {
            log.debug("Veuiller donner un nom à rechercher");
            throw  new InvalidException("Veuiller donner un nom à rechercher");
        }
        return venteRepository.findByCode(code).map(venteMappeur::toDto)
                .orElseThrow(()->new EntittyNotFoundException("This vente is not in the databse",ErrorCodes.VENTES_NOT_FOUND)) ;
    }
}
