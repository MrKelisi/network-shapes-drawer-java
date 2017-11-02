package serveur;

public class Traitement { //TODO: j'avais vraiment aucune idée pour cette classe
    private static Traitement instance = new Traitement();
    private TraitementReseauCOR traitement;

    private Traitement() {
        traitement = new TraitementCercle(traitement);
        traitement = new TraitementPolygone(traitement);
        traitement = new TraitementSegment(traitement);
        traitement = new TraitementTriangle(traitement);
    }

    public static Traitement instance() {
        return instance;
    }

    public TraitementReseauCOR traitement() {
        return traitement;
    }
}