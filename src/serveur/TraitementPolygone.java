package serveur;

import java.util.ArrayList;

public class TraitementPolygone extends TraitementReseauForme {
    private final static String NOM = "POLYGONE";
    private ArrayList<Point> points;

    public TraitementPolygone(TraitementReseauCOR next) {
        super(next, NOM);
        points = new ArrayList<>();
    }

    @Override
    protected void traiterVariableInterne(String nom, String valeur) {
        switch (nom) {
            case "point":
                Point point = Variable.parsePoint(valeur); //TODO: mettre une exception pour éviter cette ligne
                if(point != null) {
                    points.add(point);
                }
                break;
        }
    }

    @Override
    protected void afficherInterne(Sortie sortie) {
        if(points.size() < 3) {
            throw new IllegalArgumentException("Le polygone a moins de 3 points"); //TODO: meilleure exception
        }

        sortie.polygone(points);
    }
}