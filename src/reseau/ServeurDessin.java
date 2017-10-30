package reseau;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurDessin {
    private final static int PORT = 1952;

    public static void main(String[] args) {
        try {
            ServerSocket serveur = new ServerSocket(PORT);

            System.out.println("Serveur démarré " + serveur);

            while(true) {
                Socket client = serveur.accept();

                try {
                    GestionnaireClient gestionnaire = new GestionnaireClient(client);
                    gestionnaire.run();
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                    client.close();
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }
}