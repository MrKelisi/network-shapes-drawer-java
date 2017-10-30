package reseau;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class GestionnaireClient extends Thread {
    private BufferedReader fluxEntrant;
    private Socket client;

    public GestionnaireClient(Socket client) throws IOException {
        if(client == null) {
            throw new NullPointerException("Le client ne peut pas être null");
        }

        fluxEntrant = new BufferedReader(new InputStreamReader(client.getInputStream()));
    }

    @Override
    public void run() {
        super.run();

        try {
            while(!this.isInterrupted()) {
                String requete = fluxEntrant.readLine();

                if(requete == null) {
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