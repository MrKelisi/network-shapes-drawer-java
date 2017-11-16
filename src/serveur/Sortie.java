package serveur;

import java.util.ArrayList;

public interface Sortie {
    /**
     * Affiche la fenêtre à la fin du dessin
     */
    void afficher();


    /**
     * Définit la couleur de la prochaine forme
     * @param couleur Couleur de la prochaine forme
     */
    void setCouleur(String couleur);

    /**
     * Trace un segment
     * @param debut Début du segment
     * @param fin Fin du segment
     */
    void segment(Point debut, Point fin);

    /**
     * Trace un cercle
     * @param centre Centre du cercle
     * @param rayon Rayon du cercle
     */
    void cercle(Point centre, double rayon);

    /**
     * Trace un triangle
     * @param p1 Point 1
     * @param p2 Point 2
     * @param p3 Point 3
     */
    void triangle(Point p1, Point p2, Point p3);

    /**
     * Trace un polygone
     * @param points Points du polygone
     */
    void polygone(ArrayList<Point> points);
}