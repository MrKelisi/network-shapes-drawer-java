package serveur;

class TraitementSegment extends TraitementReseauForme {
    private static final String NOM = "SEGMENT";
    private Point debut;
    private Point fin;

    public TraitementSegment(TraitementReseauCOR next) {
        super(next, NOM);
    }

    @Override
    protected void traiterVariableInterne(String nom, String valeur) {
        switch (nom) {
            case "debut":
                debut = Variable.parsePoint(valeur);
                break;

            case "fin":
                fin = Variable.parsePoint(valeur);
                break;
        }
    }

    @Override
    protected void afficherInterne(Sortie sortie) {
        if(debut == null || fin == null) {
            throw new NullPointerException("Il manque des valeurs"); //TODO: meilleure exception
        }

        sortie.segment(debut, fin);
    }
}