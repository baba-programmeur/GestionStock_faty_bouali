package sn.faty.gestionstock.service.implementation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sn.faty.gestionstock.Repository.ArticleRepository;
import sn.faty.gestionstock.Repository.ClientRepository;
import sn.faty.gestionstock.Repository.CommandeClientRepository;
import sn.faty.gestionstock.Repository.LigneCommandeClientRepository;
import sn.faty.gestionstock.Validators.ArticleValidator;
import sn.faty.gestionstock.Validators.CommandeClientValidator;
import sn.faty.gestionstock.dto.CommandeClientDTO;
import sn.faty.gestionstock.dto.LigneCommandeClientDTO;
import sn.faty.gestionstock.exception.EntittyNotFoundException;
import sn.faty.gestionstock.exception.ErrorCodes;
import sn.faty.gestionstock.exception.InvalidException;
import sn.faty.gestionstock.exception.InvalidOperationException;
import sn.faty.gestionstock.model.*;
import sn.faty.gestionstock.service.Interface.CommandeClientService;
import sn.faty.gestionstock.service.mappeur.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CommandeClientImpl implements CommandeClientService {
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;
    private CommandeClientRepository commandeClientRepository;

    private ClientMappeur clientMappeur = new ClientMappeurImpl();
    private CommandeClientMappeur commandeClientMappeur=new CommandeClientMappeurImpl();
    private LigneCommandeClientMappeur ligneCommandeMappeur;
    private LigneCommandeClientRepository ligneCommandeClientRepository;

    @Autowired
    public CommandeClientImpl(ClientRepository clientRepository, ArticleRepository articleRepository,
                              CommandeClientRepository commandeClientRepository
                              // LigneCommandeMappeur ligneCommandeMappeur,
            , LigneCommandeClientRepository ligneCommandeClientRepository) {
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
        this.commandeClientRepository = commandeClientRepository;
        this.ligneCommandeClientRepository = ligneCommandeClientRepository;
    }
    @Override
    public CommandeClientDTO savecommmandeclient(CommandeClientDTO commandeClientDTO) {

        List<String> listErrors = CommandeClientValidator.ValideCommandeClient(commandeClientDTO);

        if (! listErrors.isEmpty())
        {
            log.debug("Creation commande invalide");

            throw new InvalidException("the commande is not valid", ErrorCodes.COMMANDE_CLIENT_NOT_VALID, listErrors);
        }
        if (commandeClientDTO.isCommandeLivree()) {

            //une commande livree nest pas modifiable
            throw new InvalidOperationException("Cette commande est non modifiable", ErrorCodes.COMMANDE_NON_MODIFIABLE);

        }

//Ici Optional est succeptible de recuperer une valeur null -> dans ce cas on utilise Optional

//        Optional<Client> client = clientRepository.findById(commandeClientDTO.getClient().getId());

//        if (! client.isPresent()) {
//
//            log.debug("The client with id {} is not in the database", commandeClientDTO.getClient().getId());
//
//            throw new EntittyNotFoundException("This client is not in the database", ErrorCodes.CLIENT_NOT_FOUND);
//        }

        //On verifie d'abord si la ligne de commande est dans la base

        List<String> errors = new ArrayList<>();

        if (commandeClientDTO.getLigneCommandeClients() != null) {

            commandeClientDTO.getLigneCommandeClients().forEach(ligneComm -> {

                //On verifie si l'article existe dans la base

                if (ligneComm.getArticle() != null) {

                    Optional<Article> article = articleRepository.findById(ligneComm.getArticle().getId());

                         if (article.isEmpty()) {

                        errors.add("Article with Id {} " + ligneComm.getArticle().getId() + "n'existe pas");

                        //   throw new EntittyNotFoundException("Article is not in the database", ErrorCodes.ARTICLE_NOT_FOUND);
                    }
                } else {
                    errors.add("Impossible d'enregitrer une commande avec un article Null");
                }
            });
        }

        if (! errors.isEmpty()) {
            log.debug("");
            throw new EntittyNotFoundException("Article is not in the database", ErrorCodes.ARTICLE_NOT_FOUND);
        }

        //Todo CommandeClientImpl and CommandFournisseurImpl

        CommandeClient commandeClient = commandeClientRepository.save(commandeClientMappeur.toEntity(commandeClientDTO));

        if (commandeClientDTO.getLigneCommandeClients() != null) {

            commandeClientDTO.getLigneCommandeClients().forEach(ligneCommande -> {

                LigneCommandeClient ligneCommandeClient = ligneCommandeMappeur.toEntity(ligneCommande);

                ligneCommandeClient.setCommandeClient(commandeClient);

                ligneCommandeClientRepository.save(ligneCommandeClient);

            });
        }
        return commandeClientMappeur.toDto(commandeClient);
    }

    @Override
    public List<CommandeClientDTO> findAll() {

        return commandeClientRepository.findAll()
                .stream().map(commandeClientMappeur::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            log.debug("");
        }
        commandeClientRepository.deleteById(id);

        List<LigneCommandeClient> ligneCommandeClients = ligneCommandeClientRepository.findAllByCommandeClientId(id);

        if(!ligneCommandeClients.isEmpty())

        {
            throw new InvalidOperationException("Impossible de supprimer une commande client", ErrorCodes.COMMANDE_CLIENT_DEJA_UTILISE);
        }

    }

    @Override
    public CommandeClientDTO findById(Long id) {

        if (id == null) {
            log.debug("Commande client is Null {}" + id);
            //  throw  new InvalidException()
            return null;
        }
                         return commandeClientRepository.findById(id)
                                 .map(commandeClientMappeur::toDto)
                                 .orElseThrow(() -> {
                                     throw new EntittyNotFoundException("The commande with {}" + id + "is not in the database");
                                 });
    }

    @Override
    public CommandeClientDTO findByCode(String code) {
        if (code == null) {
            log.debug("");
            return null;
        }
        return commandeClientRepository.findCommandeClientByCode(code)
                .map(commandeClientMappeur::toDto)
                .orElseThrow(() -> {
                    throw new EntittyNotFoundException("The commande with {}" + code + "is not in the database");
                });
    }

    @Override
    public CommandeClientDTO updateEtatCommandeClient(Long idCommande, EtatCommande etatCommande) {
        this.checkIdCommandeClient(idCommande);

        if (! StringUtils.hasLength(String.valueOf(etatCommande))) {

            throw new InvalidOperationException("Impossible de modifier un etat non trouve ", ErrorCodes.COMMANDE_NON_MODIFIABLE);
        }
        CommandeClientDTO commandeClientDTO = this.findById(idCommande);

        if (commandeClientDTO.isCommandeLivree()) {

            throw new InvalidOperationException("Impossible de modifier une commande livree", ErrorCodes.COMMANDE_NON_MODIFIABLE);
        }
        commandeClientDTO.setEtatCommande(etatCommande);

        return commandeClientMappeur.toDto(commandeClientRepository.save(commandeClientMappeur.toEntity(commandeClientDTO)));
    }
    @Override
    public CommandeClientDTO updateQuantiteCommandeClient(Long idCommandeClient, Long idLigneCommande, BigDecimal newQuantite) {
        this.checkIdCommandeClient(idCommandeClient);
        this.checkIdLigneCommande(idLigneCommande);

        if (newQuantite == null || newQuantite.compareTo(BigDecimal.ZERO) == 0) {
            throw new InvalidOperationException("Impossible de modifier une quantite null ou une qantite égale à zero", ErrorCodes.COMMANDE_NON_MODIFIABLE);
        }

        //this.getLigneCommandeClient(idLigneCommande);
        //si la commande est livree
        CommandeClientDTO commandeClientDTO = findById(idCommandeClient);

        this.checkIsCommandeLivree(commandeClientDTO);

        LigneCommandeClient ligneCommandeClienttrouve = this.getLigneCommandeClient(idLigneCommande).get();

        ligneCommandeClienttrouve.setQuantite(newQuantite);

        ligneCommandeClientRepository.save(ligneCommandeClienttrouve);

        return commandeClientDTO;
    }
    @Override
    public CommandeClientDTO updateClient(Long idClient, Long idCommandeClient) {
        if (idClient == null) {
            throw new InvalidOperationException("Impossible de modifier un client avec un idClient null", ErrorCodes.COMMANDE_NON_MODIFIABLE);
        }
        this.checkIdCommandeClient(idCommandeClient);

        Optional<Client> client = clientRepository.findById(idClient);
        if (client.isEmpty()) {

            throw new InvalidOperationException("Client non trouve", ErrorCodes.CLIENT_NOT_FOUND);
        }
        CommandeClientDTO commandeClientDTO = findById(idCommandeClient);

        this.checkIsCommandeLivree(commandeClientDTO);

        commandeClientDTO.setClient(clientMappeur.toDto(client.get()));

        return commandeClientMappeur.toDto(commandeClientRepository.save(commandeClientMappeur.toEntity(commandeClientDTO)));
    }

    @Override
    public CommandeClientDTO updateArticle(Long idArticle, Long idLigneCommandeClient, Long idCommandeClient) {
        if (idArticle == null) {

            throw new InvalidOperationException("Impossible de modifier un Article avec un idArticle null", ErrorCodes.COMMANDE_NON_MODIFIABLE);
        }
          this.checkIdCommandeClient(idCommandeClient);

          this.checkIdLigneCommande(idLigneCommandeClient);

        Optional<Article> article = articleRepository.findById(idArticle);

        if (article.isEmpty()) {

            throw new InvalidOperationException("Article non trouvé", ErrorCodes.ARTICLE_NOT_FOUND);
        }

     List<String> errors=ArticleValidator.ValideArticle(ArticleMappeurImpl.toDto(article.get()));

        if(!errors.isEmpty()){

            throw  new InvalidException("Article is not valid",ErrorCodes.ARTICLE_NOT_VALID,errors);
        }

        CommandeClientDTO commandeClientDTO=this.findById(idCommandeClient);

        this.checkIsCommandeLivree(commandeClientDTO);

        Optional<LigneCommandeClient> ligneCommandeClient =this.getLigneCommandeClient(idLigneCommandeClient);

           log.debug("LigneCommande {}",ligneCommandeClient);

        LigneCommandeClient ligneCommandeClientTrouve=ligneCommandeClient.get();
                                          //Article getté apres recuperation depuis la base
        ligneCommandeClientTrouve.setArticle((article.get()));

        ligneCommandeClientRepository.save(ligneCommandeClientTrouve);

        return commandeClientDTO;
    }

    @Override
    public void deleteArticle(Long idLigneCommandeClient, Long idCommandeClient) {
      checkIdLigneCommande(idLigneCommandeClient);

      checkIdCommandeClient(idCommandeClient);

      getLigneCommandeClient(idLigneCommandeClient);


      ligneCommandeClientRepository.deleteById(idLigneCommandeClient);

    }
    @Override
    public List<LigneCommandeClientDTO> findAllLignesCommandeByClient(Long idLigneCommande) {

        return ligneCommandeClientRepository.findAllByCommandeClientId(idLigneCommande).stream().map(ligneCommandeMappeur::toDto).collect(Collectors.toList());
    }

    private Optional<LigneCommandeClient> getLigneCommandeClient(Long idLigneCommandeClient) {

        Optional<LigneCommandeClient> ligneCommandeClient = ligneCommandeClientRepository.findById(idLigneCommandeClient);

        if(ligneCommandeClient.isEmpty()){

            throw  new EntittyNotFoundException("Ligne commande is not here",ErrorCodes.LIGNE_COMMANDE_CLIENT);
        }
        return ligneCommandeClient;
    }
    private void checkIdCommandeClient(Long idCommandeClient) {
        if (idCommandeClient == null) {
            throw new InvalidOperationException("Impossible de modifier une commande avec un id null", ErrorCodes.COMMANDE_NON_MODIFIABLE);
        }
    }
    private void checkIdLigneCommande(Long idLigneCommande) {
        if (idLigneCommande == null) {
            throw new InvalidOperationException("Impossible de modifier une commande avec un idLigneCommmande null", ErrorCodes.COMMANDE_NON_MODIFIABLE);
        }
    }
    private boolean checkIsCommandeLivree(CommandeClientDTO commandeClientDTO) {
        //  CommandeClientDTO commandeClientDTO1= findById()

        if (commandeClientDTO.isCommandeLivree()) {

            throw new InvalidOperationException("Impossible de modifier un client avec une commande livree", ErrorCodes.COMMANDE_NON_MODIFIABLE);
        }
        return false ;
    }
}
