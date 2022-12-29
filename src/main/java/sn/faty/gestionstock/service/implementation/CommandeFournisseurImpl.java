package sn.faty.gestionstock.service.implementation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.faty.gestionstock.Repository.ArticleRepository;
import sn.faty.gestionstock.Repository.CommandeFournisseurRepository;
import sn.faty.gestionstock.Repository.FournisseurRepository;
import sn.faty.gestionstock.Repository.LigneCommandeFournisseurRepository;
import sn.faty.gestionstock.Validators.CommandeFournisseurValidator;
import sn.faty.gestionstock.dto.CommandeFournisseurDTO;
import sn.faty.gestionstock.exception.EntittyNotFoundException;
import sn.faty.gestionstock.exception.ErrorCodes;
import sn.faty.gestionstock.exception.InvalidException;
import sn.faty.gestionstock.exception.InvalidOperationException;
import sn.faty.gestionstock.model.*;
import sn.faty.gestionstock.service.Interface.CommandeFournisseurService;
import sn.faty.gestionstock.service.mappeur.CommandeFournisseurImplementation;
import sn.faty.gestionstock.service.mappeur.LigneCommandeFournisseurImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeFournisseurImpl implements CommandeFournisseurService {


    private CommandeFournisseurRepository commandeFournisseurRepository ;

    private FournisseurRepository fournisseurRepository ;

    private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository ;
    private ArticleRepository articleRepository ;
    @Autowired
    public CommandeFournisseurImpl(CommandeFournisseurRepository commandeFournisseurRepository,
                                   ArticleRepository articleRepository,
                                   LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository,
                                   FournisseurRepository fournisseurRepository){
        this.commandeFournisseurRepository=commandeFournisseurRepository;
        this.articleRepository=articleRepository;
         this.ligneCommandeFournisseurRepository=ligneCommandeFournisseurRepository;
         this.fournisseurRepository=fournisseurRepository;
    }

    @Override
    public CommandeFournisseurDTO savecommmandeFournisseur(CommandeFournisseurDTO commandeFournisseurDTO) {

        List<String> errors= CommandeFournisseurValidator.validerCommandeFournisseur(commandeFournisseurDTO);

           if(!errors.isEmpty()){
               log.debug("The commande  is not valid");
               throw new InvalidException("The commande is not valid",ErrorCodes.COMMANDE_FOURNISSEUR_NOT_VALID,errors);

           }
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(commandeFournisseurDTO.getFournisseur().getId());

        if (fournisseur.isEmpty())
        {
            log.debug("The fournisseur with id {} is not in the database",commandeFournisseurDTO.getFournisseur().getId());

            throw  new EntittyNotFoundException("This Fournisseur is not in the database",ErrorCodes.CLIENT_NOT_FOUND);
        }

        //On verifie d'abord si la ligne de commande dans la base


        if(commandeFournisseurDTO.getLigneCommandeFournisseurs()!=null)
        {
            commandeFournisseurDTO.getLigneCommandeFournisseurs().forEach(ligneCommFournisseur ->{

                //On verifie si l'article existe dans la base

                if(ligneCommFournisseur.getArticle()!=null) {

                    Optional<Article> article=articleRepository.findById(ligneCommFournisseur.getArticle().getId());

                    if(article.isEmpty()) {

                        errors.add("Article with Id {} "+ligneCommFournisseur.getArticle().getId() + "n'existe pas") ;

                        //   throw new EntittyNotFoundException("Article is not in the database", ErrorCodes.ARTICLE_NOT_FOUND);

                    }
                }
                else {
                    errors.add("Impossible d'enregitrer une commande avec un article Null");
                }
            });
        }
        if(!errors.isEmpty())
        {
            log.debug("");

            throw new EntittyNotFoundException("Article is not in the database",ErrorCodes.ARTICLE_NOT_FOUND);
        }

        //Todo CommandeClientImpl and CommandFournisseurImpl

        CommandeFournisseur commandeFournisseur=commandeFournisseurRepository.save(CommandeFournisseurImplementation.toEntity(commandeFournisseurDTO));

        if (commandeFournisseurDTO.getLigneCommandeFournisseurs()!=null)
        {
            commandeFournisseurDTO.getLigneCommandeFournisseurs().forEach(ligneCommandeFournisseurDTO ->
            {

          LigneCommandeFournisseur ligneCommandeFournisseur= LigneCommandeFournisseurImpl.toEntity(ligneCommandeFournisseurDTO);

                ligneCommandeFournisseur.setCommandeFournisseur(commandeFournisseur);

                ligneCommandeFournisseurRepository.save(ligneCommandeFournisseur);

            });
        }

        return  CommandeFournisseurImplementation.toDto(commandeFournisseur);
    }

    @Override
    public List<CommandeFournisseurDTO> findAll() {
        return  commandeFournisseurRepository.findAll().stream()
                .map(CommandeFournisseurImplementation::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
           if(id==null)
           {
               log.debug("Id is null");
           }
           commandeFournisseurRepository.deleteById(id);

        List<LigneCommandeFournisseur> ligneCommandeFournisseurs = ligneCommandeFournisseurRepository.findAllByCommandeFournisseurId(id);

        if(!ligneCommandeFournisseurs.isEmpty())

        {
            throw new InvalidOperationException("Impossible de supprimer une commande Fournisseur", ErrorCodes.COMMANDE_FOURNISSEUR_DEJA_UTILISE);
        }

    }
    @Override
    public CommandeFournisseurDTO findById(Long id) {

         if(id==null)
         {
             log.debug("Commande with {} is null"+id);

          //   throw  new EntittyNotFoundException("Commande with {}"+ id , ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND);
         }
                  return    CommandeFournisseurImplementation.toDto(commandeFournisseurRepository.findById(id)
                          .orElseThrow(()-> new EntittyNotFoundException("Commande is not in the database")));
    }
    @Override
    public CommandeFournisseurDTO findByCode(String code) {
        if(code==null)
        {
            log.debug("Commande with code {} is null"+code);

            //   throw  new EntittyNotFoundException("Commande with {}"+ id , ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND);
        }
        return    CommandeFournisseurImplementation.toDto(commandeFournisseurRepository.findCommandeFournisseurByCodeFournisseur(code)
                .orElseThrow(()-> new EntittyNotFoundException("Commande is not in the database")));
    }

}
