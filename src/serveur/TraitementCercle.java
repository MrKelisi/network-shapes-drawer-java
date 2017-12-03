package serveur;

import exception.FormeException;
import exception.ParseException;

class TraitementCercle extends TraitementReseauForme {
    private final static String NOM = "CERCLE";
    private Point origine;
    private Double rayon;

    public TraitementCercle(TraitementReseauCOR next) {
        super(next, NOM);
    }

    @Override
    protected void traiterVariableInterne(String nom, String valeur) {
        switch (nom) {
            case "origine":
                try {
                    origine = Variable.parsePoint(valeur);
                }
                catch (ParseException e) {

                }
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
    protected void afficherInterne(Sortie sortie) throws FormeException {
        if(origine == null || rayon == null) {
            throw new FormeException("L'origine ou le rayon n'ont pas été données.");
        }

        sortie.cercle(origine, rayon);
    }

    @Override
    protected void reset() {
        origine = null;
        rayon = null;
    }

    @Override
    public String toString() {
        return "TraitementCercle{}";
    }
}