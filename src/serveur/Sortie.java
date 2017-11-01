package serveur;

import java.util.ArrayList;

public interface Sortie {
    void afficher();

    void setCouleur(Couleur couleur);
    void segment(Point debut, Point fin);
    void cercle(Point centre, double rayon);
    void triangle(Point p1, Point p2, Point p3);
    void polygone(ArrayList<Point> points);
}