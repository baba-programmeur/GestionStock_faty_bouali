package sn.faty.GestionStock.service.implementation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.faty.GestionStock.Repository.ArticleRepository;
import sn.faty.GestionStock.Repository.ClientRepository;
import sn.faty.GestionStock.Repository.CommandeClientRepository;
import sn.faty.GestionStock.Repository.LigneCommandeClientRepository;
import sn.faty.GestionStock.Validators.CommandeClientValidator;
import sn.faty.GestionStock.dto.CommandeClientDTO;
import sn.faty.GestionStock.exception.EntittyNotFoundException;
import sn.faty.GestionStock.exception.ErrorCodes;
import sn.faty.GestionStock.exception.InvalidException;
import sn.faty.GestionStock.model.Article;
import sn.faty.GestionStock.model.Client;
import sn.faty.GestionStock.model.CommandeClient;
import sn.faty.GestionStock.model.LigneCommandeClient;
import sn.faty.GestionStock.service.Interface.CommandeClientService;
import sn.faty.GestionStock.service.mappeur.CommandeClientMappeur;
import sn.faty.GestionStock.service.mappeur.LigneCommandeClientMappeur;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CommandeClientImpl implements CommandeClientService {
  private   ClientRepository clientRepository ;
  private   ArticleRepository articleRepository ;
    private CommandeClientRepository commandeClientRepository;
    private CommandeClientMappeur commandeClientMappeur ;
    private LigneCommandeClientMappeur ligneCommandeMappeur ;
    private LigneCommandeClientRepository ligneCommandeClientRepository ;
@Autowired
public  CommandeClientImpl (ClientRepository clientRepository,ArticleRepository articleRepository,
                            CommandeClientRepository commandeClientRepository,
                           // LigneCommandeMappeur ligneCommandeMappeur,
                            LigneCommandeClientRepository ligneCommandeClientRepository)
{
    this.clientRepository=clientRepository ;
    this.articleRepository=articleRepository;
    this.commandeClientRepository=commandeClientRepository;
    this.ligneCommandeClientRepository=ligneCommandeClientRepository;
}
  //  CommandeClientMappeur commandeClientMappeur1=new CommandeClientMappeurImpl();
    @Override
    public CommandeClientDTO savecommmandeclient(CommandeClientDTO commandeClientDTO) {

        List<String> listErrors= CommandeClientValidator.ValideCommandeClient(commandeClientDTO);

        if(!listErrors.isEmpty())
        {
            log.debug("Invalid ");

            throw  new InvalidException("the commande is not valid", ErrorCodes.COMMANDE_CLIENT_NOT_VALID,listErrors);
        }
//Ici Optional est succeptible de recuperer une valeur null -> dans ce cas on utilise Optional

      Optional <Client>  client = clientRepository.findById(commandeClientDTO.getClient().getId());

        if (! client.isPresent())
        {
            log.debug("The client with id {} is not in the database",commandeClientDTO.getClient().getId());

            throw  new EntittyNotFoundException("This client is not in the database",ErrorCodes.CLIENT_NOT_FOUND);
        }

        //On verifie d'abord si la ligne de commande dans la base

       List<String> errors=new ArrayList<>() ;

        if(commandeClientDTO.getLigneCommandeClients()!=null)
        {
            commandeClientDTO.getLigneCommandeClients().forEach(ligneComm ->{

                //On verifie si l'article existe dans la base

                  if(ligneComm.getArticle()!=null) {

                    Optional<Article> article=articleRepository.findById(ligneComm.getArticle().getId());

                       if(article.isEmpty()) {

                        errors.add("Article with Id {} "+ligneComm.getArticle().getId() + "n'existe pas") ;

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

      CommandeClient commandeClient=commandeClientRepository.save(commandeClientMappeur.toEntity(commandeClientDTO));

      if (commandeClientDTO.getLigneCommandeClients()!=null)
      {
          commandeClientDTO.getLigneCommandeClients().forEach(ligneCommande ->{

              LigneCommandeClient ligneCommandeClient=ligneCommandeMappeur.toEntity(ligneCommande);

             ligneCommandeClient.setCommandeClient(commandeClient);

             ligneCommandeClientRepository.save(ligneCommandeClient);

          });
      }
        return  commandeClientMappeur.toDto(commandeClient);
    }

    @Override
    public List<CommandeClientDTO> findAll() {

        return commandeClientRepository.findAll()
                .stream().map(commandeClientMappeur::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
    if(id==null)
    {
        log.debug("");
    }
    commandeClientRepository.deleteById(id);
    }

    @Override
    public CommandeClientDTO findById(Long id) {

        if (id == null) {
            log.debug("Commande client is Null {}" + id);
            //  throw  new InvalidException()
            return null;
        }
               //entity
           return commandeClientRepository.findById(id)
                        .map(commandeClientMappeur::toDto)
                        .orElseThrow(()->{
                            throw  new EntittyNotFoundException("The commande with {}"+id +"is not in the database");
                        });
    }

    @Override
    public CommandeClientDTO findByCode(String code) {
      if(code==null)
      {
          log.debug("");
          return  null ;
      }
        return commandeClientRepository.findCommandeClientByCode(code)
                .map(commandeClientMappeur::toDto)
                .orElseThrow(()->{
                    throw  new EntittyNotFoundException("The commande with {}"+code +"is not in the database");
                });
    }

}
