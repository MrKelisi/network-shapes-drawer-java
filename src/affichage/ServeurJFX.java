package affichage;

import exception.CreationSortieException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import serveur.*;

import java.util.concurrent.FutureTask;

public class ServeurJFX extends Application implements GestionnaireSortie {
    private ServeurDessin serveur;

    @Override
    public void start(Stage stage) throws Exception {
        Platform.setImplicitExit(false);

        serveur = new ServeurDessin(this);
        serveur.start();
    }

    @Override
    public Sortie creerSortie() throws CreationSortieException {
        final FutureTask<FenetreJFX> task = new FutureTask<>(() -> new FenetreJFX());
        Platform.runLater(task);

        try {
            return task.get();
        }
        catch (Exception e) {
            throw new CreationSortieException("Impossible de creer une fenetre");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public String toString() {
        return "ServeurJFX{}";
    }
}