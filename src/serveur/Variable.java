package serveur;

public class Variable {
    /**
     * Lit la valeur d'une variable et renvoie le Point correspondant
     * @param valeur Valeur du point
     * @return Point
     */
    public static Point parsePoint(String valeur) {
        if(valeur == null) {
            throw new NullPointerException("La valeur est null");
        }

        String coordonnees[] = valeur.split(";", 2);

        if(coordonnees.length != 2) {
            return null;
        }

        try {
            return new Point(Double.parseDouble(coordonnees[0]), Double.parseDouble(coordonnees[1]));
        }
        catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Retourne la couleur correspondante à la chaine donnée
     * @param couleur Nom de la couleur
     * @return Couleur ou null si elle n'a pas été trouvée
     */
    public static Couleur parseCouleur(String couleur) {
        if(couleur == null) {
            throw new NullPointerException("La couleur ne peut pas être null");
        }

        try {
            return Couleur.valueOf(couleur.toUpperCase());
        }
        catch (IllegalArgumentException e) {
            return null;
        }
    }
}