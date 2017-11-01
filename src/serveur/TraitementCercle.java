package serveur;

class TraitementCercle extends TraitementReseauForme {
    private final static String NOM = "CERCLE";
    private Point origine;
    private Double rayon;

    public TraitementCercle(TraitementReseauCOR next) {
        super(next, NOM);
    }

    @Override
    protected void traiterVariable(String nom, String valeur) {
        switch (nom) {
            case "origine":
                origine = Variable.parsePoint(valeur);
                break;

            case "rayon":
                try {
                    rayon = new Double(valeur);
                }
                catch (NumberFormatException e) {
                    rayon = null;
                }
        }
    }

    @Override
    protected void afficher(Sortie sortie) {
        if(origine == null || rayon == null) {
            throw new NullPointerException("Pas assez de données"); //TODO: meilleure exception
        }

        sortie.cercle(origine, rayon);
    }
}