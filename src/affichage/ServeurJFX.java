package affichage;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import serveur.GestionnaireSortie;
import serveur.ServeurDessin;
import serveur.Sortie;

public class ServeurJFX extends Application implements GestionnaireSortie {
    @Override
    public void start(Stage stage) throws Exception {
        ServeurDessin serveur = new ServeurDessin(this);
        serveur.listen();
        Platform.exit();
    }

    @Override
    public Sortie creerSortie() {
        return new FenetreJFX();
    }

    public static void main(String[] args) {
        launch(args);
    }
}