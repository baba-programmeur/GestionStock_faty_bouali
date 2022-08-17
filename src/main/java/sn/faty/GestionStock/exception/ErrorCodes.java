package sn.faty.GestionStock.exception;

public enum ErrorCodes {

    ARTICLE_NOT_FOUND(1000),
   ARTICLE_NOT_VALID(1001),
    CATEGORY_NOT_FOUND(2000),

   CLIENT_NOT_FOUND(3000),

    COMMANDE_CLIENT_NOT_FOUND(4000),
    COMMANDE_CLIENT_NOT_VALID(4001),

    COMMANDE_FOURNISSEUR_NOT_FOUND(5000),

    COMMANDE_FOURNISSEUR_NOT_VALID(5001),

    ENTREPRISE_NOT_FOUND(6000),

    FOURNISSEUR_NOT_FOUND(7000),

    LIGNE_COMMANDE_CLIENT(8000),

    LIGNE_COMMANDE_FOURNISSEUR(9000),

    LIGNE_VENTE_FOURNISSEUR(10000),

    MOUVEMENT_STOCK(110000),

    ROLES(12000),

    UTILISATEUR(13000),

    VENTES_NOT_FOUND(14000)

    ;
    private  int code ;
    ErrorCodes(int code) {
        this.code=code ;
    }
    public int getCode() {
        return code;
    }
}
