package serveur;

import exception.CreationSortieException;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurDessin extends Thread {
    private final static int PORT = 1952;
    private GestionnaireSortie gestionnaireSortie;
    private ServerSocket serveur;

    public ServeurDessin(GestionnaireSortie gestionnaire) {
        if(gestionnaire == null) {
            throw new NullPointerException("Le gestionnaire de sorties ne peut pas être null");
        }

        gestionnaireSortie = gestionnaire;

        try {
            serveur = new ServerSocket(PORT);
        }
        catch (IOException e) {
            throw new RuntimeException("Impossible de démarrer le serveur " + e);
        }
    }

    @Override
    public void run() {
        super.run();

        try {
            System.out.println("Serveur démarré " + serveur);

            while(true) {
                Socket client = serveur.accept();

                try {
                    GestionnaireClient gestionnaire = new GestionnaireClient(client, gestionnaireSortie.creerSortie());
                    gestionnaire.start();
                }
                catch (CreationSortieException e) {
                    System.out.println("Erreur de création de sortie: " + e.getMessage());
                    client.close();
                }
            }
        }
        catch (Exception e) {
            System.out.println("Le serveur a été arrêté: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "ServeurDessin{" +
                "PORT=" + PORT + ", " +
                "IP=" + serveur.getInetAddress() +
                '}';
    }
}