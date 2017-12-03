package serveur;

import exception.FormeException;
import exception.ParseException;

import java.util.ArrayList;

public class TraitementPolygone extends TraitementReseauForme {
    private final static String NOM = "POLYGONE";
    private ArrayList<Point> points;

    public TraitementPolygone(TraitementReseauCOR next) {
        super(next, NOM);
    }

    @Override
    protected void traiterVariableInterne(String nom, String valeur) {
        switch (nom) {
            case "point":
                try {
                    points.add(Variable.parsePoint(valeur));
                }
                catch (ParseException e) {

                }
                break;
        }
    }

    @Override
    protected void afficherInterne(Sortie sortie) throws FormeException {
        if(points.size() < 3) {
            throw new FormeException("Le polygone a moins de 3 points");
        }

        sortie.polygone(points);
    }

    @Override
    protected void reset() {
        points = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "TraitementPolygone{}";
    }
}