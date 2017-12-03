package serveur;

import exception.FormeException;
import exception.ParseException;

public class TraitementTriangle extends TraitementReseauForme {
    private final static String NOM = "TRIANGLE";
    private Point p1;
    private Point p2;
    private Point p3;

    public TraitementTriangle(TraitementReseauCOR next) {
        super(next, NOM);
    }

    @Override
    protected void traiterVariableInterne(String nom, String valeur) {
        try {
            switch (nom) {
                case "p1":
                    p1 = Variable.parsePoint(valeur);
                    break;

                case "p2":
                    p2 = Variable.parsePoint(valeur);
                    break;

                case "p3":
                    p3 = Variable.parsePoint(valeur);
                    break;
            }
        }
        catch (ParseException e) {

        }
    }

    @Override
    protected void afficherInterne(Sortie sortie) throws FormeException {
        if(p1 == null || p2 == null || p3 == null) {
            throw new FormeException("Le triangle doit avoir 3 points définis");
        }

        sortie.triangle(p1, p2, p3);
    }

    @Override
    protected void reset() {
        p1 = null;
        p2 = null;
        p3 = null;
    }

    @Override
    public String toString() {
        return "TraitementTriangle{}";
    }
}