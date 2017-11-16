package affichage;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import serveur.*;

import java.util.concurrent.FutureTask;

public class ServeurJFX extends Application implements GestionnaireSortie {
    @Override
    public void start(Stage stage) throws Exception {
        ServeurDessin serveur = new ServeurDessin(this);
        serveur.start();
    }

    @Override
    public Sortie creerSortie() {
        final FutureTask<FenetreJFX> task = new FutureTask<>(() -> new FenetreJFX());
        Platform.runLater(task);

        try {
            return task.get();
        }
        catch (Exception e) {
            throw new RuntimeException("Impossible de creer une fenetre"); //TODO: exception
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}