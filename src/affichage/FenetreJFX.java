package affichage;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import serveur.Point;
import serveur.Sortie;

import java.util.ArrayList;

public class FenetreJFX implements Sortie {
    private Stage fenetre;
    private String couleur;
    private Group root;

    public FenetreJFX() {
        fenetre = new Stage();
        root = new Group();

        Scene scene = new Scene(root, 800, 600);
        fenetre.setScene(scene);
    }

    /**
     * Affiche la forme avec les bonnes propriétés
     * @param forme Forme à afficher
     */
    private void afficher(Shape forme) {
        if(couleur != null) {
            forme.setFill(Color.valueOf(couleur));
        }

        root.getChildren().add(forme);

        couleur = null;
    }

    @Override
    public void afficher() {
        Platform.runLater(() -> fenetre.showAndWait());
    }

    @Override
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public void segment(Point debut, Point fin) {
        if(debut == null || fin == null) {
            throw new NullPointerException("Le début et la fin ne peuvent pas être null");
        }

        Line segment = new Line(debut.x(), debut.y(), fin.x(), fin.y());
        afficher(segment);
    }

    @Override
    public void cercle(Point centre, double rayon) {
        if(centre == null) {
            throw new NullPointerException("Le centre ne peut pas être null");
        }

        Circle cercle = new Circle(centre.x(), centre.y(), rayon);
        afficher(cercle);
    }

    @Override
    public void triangle(Point p1, Point p2, Point p3) {
        if(p1 == null || p2 == null || p3 == null) {
            throw new NullPointerException("Les points du triangle ne peuvent pas être null");
        }

        Polygon triangle = new Polygon(p1.x(), p1.y(), p2.x(), p2.y(), p3.x(), p3.y());
        afficher(triangle);
    }

    @Override
    public void polygone(ArrayList<Point> points) {
        if (points == null) {
            throw new NullPointerException("La liste de point ne peut pas être null");
        }

        Polygon polygone = new Polygon();

        for(Point p : points) {
            polygone.getPoints().addAll(p.x(), p.y());
        }

        afficher(polygone);
    }
}