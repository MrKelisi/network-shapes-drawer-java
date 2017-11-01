package serveur;

public class TraitementForme extends TraitementReseauForme {
    private final static String NOM = "FORME";
    private Couleur couleur;

    public TraitementForme(TraitementReseauCOR next) {
        super(next, NOM);
    }

    @Override
    protected void traiterVariable(String nom, String valeur) {
        switch (nom) {
            case "couleur":
                couleur = Variable.parseCouleur(valeur);
                break;
        }
    }

    @Override
    protected void afficher(Sortie sortie) {
        if(couleur == null) {
            throw new NullPointerException("Toutes les valeurs n'ont pas été données"); //TODO: meilleure exception
        }

        sortie.setCouleur(couleur);
    }
}