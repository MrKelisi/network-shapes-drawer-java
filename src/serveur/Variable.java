package serveur;

import exception.ParseException;

public abstract class Variable {
    /**
     * Lit la valeur d'une variable et renvoie le Point correspondant
     * @param valeur Valeur du point
     * @return Point
     * @throws ParseException si la chaîne ne correspond pas à un point
     */
    public static Point parsePoint(String valeur) throws ParseException {
        if(valeur == null) {
            throw new ParseException("La valeur est null");
        }

        String coordonnees[] = valeur.split(";", 2);

        if(coordonnees.length != 2) {
            throw new ParseException("La valeur est dans un format invalide");
        }

        try {
            return new Point(Double.parseDouble(coordonnees[0]), Double.parseDouble(coordonnees[1]));
        }
        catch (NumberFormatException e) {
            throw new ParseException("La valeur ne contient pas deux nombres réels");
        }
    }
}