package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class GestionnaireClient extends Thread {
    private BufferedReader fluxEntrant;
    private Sortie sortie;

    public GestionnaireClient(Socket client, Sortie sortie) throws IOException {
        if(client == null) {
            throw new NullPointerException("Le client ne peut pas être null");
        }

        if(sortie == null) {
            throw new NullPointerException("La sortie ne peut pas être null");
        }

        this.sortie = sortie;
        fluxEntrant = new BufferedReader(new InputStreamReader(client.getInputStream()));
    }

    @Override
    public void run() {
        super.run();

        try {
            while(!this.isInterrupted()) {
                String requete = fluxEntrant.readLine();

                if(requete == null) {
                    sortie.afficher();
                    break;
                }

                System.out.println(requete);
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}