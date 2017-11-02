package serveur;

public class Traitement { //TODO: j'avais vraiment aucune idée pour cette classe
    private static Traitement instance = new Traitement();
    private TraitementReseauCOR traitement;

    private Traitement() {
        traitement = new TraitementCercle(null);
    }

    public static Traitement instance() {
        return instance;
    }

    public TraitementReseauCOR traitement() {
        return traitement;
    }
}