package serveur;

import exception.FormeException;
import exception.ParseException;

class TraitementSegment extends TraitementReseauForme {
    private static final String NOM = "SEGMENT";
    private Point debut;
    private Point fin;

    public TraitementSegment(TraitementReseauCOR next) {
        super(next, NOM);
    }

    @Override
    protected void traiterVariableInterne(String nom, String valeur) {
        try {
            switch (nom) {
                case "debut":
                    debut = Variable.parsePoint(valeur);
                    break;

                case "fin":
                    fin = Variable.parsePoint(valeur);
                    break;
            }
        }
        catch (ParseException e) {

        }
    }

    @Override
    protected void afficherInterne(Sortie sortie) throws FormeException {
        if(debut == null || fin == null) {
            throw new FormeException("Le début ou la fin du segment n'a pas été donnée");
        }

        sortie.segment(debut, fin);
    }

    @Override
    protected void reset() {
        debut = null;
        fin = null;
    }

    @Override
    public String toString() {
        return "TraitementSegment{}";
    }
}