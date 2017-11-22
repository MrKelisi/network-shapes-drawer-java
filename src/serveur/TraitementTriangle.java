package serveur;

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

    @Override
    protected void afficherInterne(Sortie sortie) {
        if(p1 == null || p2 == null || p3 == null) {
            throw new NullPointerException("Le triangle doit avoir 3 points définis"); //TODO: meilleure exception
        }

        sortie.triangle(p1, p2, p3);
    }

    @Override
    public String toString() {
        return "TraitementTriangle{}";
    }
}