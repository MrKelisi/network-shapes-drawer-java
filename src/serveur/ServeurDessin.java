package serveur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//TODO: mettre des timeouts

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
            e.printStackTrace();
            throw new RuntimeException("Impossible de démarrer le serveur " + e); //TODO: exception
        }
    }

    @Override
    public void run() {
        super.run();

        try {
            System.out.println("Serveur démarré " + serveur);

            while (true) {
                Socket client = serveur.accept();

                GestionnaireClient gestionnaire = new GestionnaireClient(client, gestionnaireSortie.creerSortie());
                gestionnaire.start();
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