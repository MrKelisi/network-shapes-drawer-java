package serveur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//TODO: mettre des timeouts

public class ServeurDessin {
    private final static int PORT = 1952;
    private GestionnaireSortie gestionnaireSortie;

    public ServeurDessin(GestionnaireSortie gestionnaire) {
        if(gestionnaire == null) {
            throw new NullPointerException("Le gestionnaire de sorties ne peut pas être null");
        }

        gestionnaireSortie = gestionnaire;
    }

    public void listen() throws IOException {
        ServerSocket serveur = new ServerSocket(PORT);

        System.out.println("Serveur démarré " + serveur);

        while(true) {
            Socket client = serveur.accept();

            GestionnaireClient gestionnaire = new GestionnaireClient(client, gestionnaireSortie.creerSortie());
            gestionnaire.run();
        }
    }
}