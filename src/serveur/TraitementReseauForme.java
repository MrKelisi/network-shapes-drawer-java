package serveur;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class TraitementReseauForme extends TraitementReseauCOR {
    private final static String FIN_FORME = "FIN";
    private String nomForme;

    public TraitementReseauForme(TraitementReseauCOR next, String nomForme) {
        super(next);

        if(nomForme == null) {
            throw new NullPointerException("Le nom de la forme ne peut pas être null");
        }

        this.nomForme = nomForme;
    }

    @Override
    protected boolean traiterInterne(String texte, BufferedReader entree, Sortie sortie) throws IOException {
        if(!nomForme.equals(texte)) {
            return false;
        }

        String reponse;

        do {
            reponse = entree.readLine();
            if(reponse == null) {
                throw new IOException("Ligne null reçue");
            }

            String parties[] = reponse.split("=", 2);

            if(parties.length == 2) {
                traiterVariable(parties[0], parties[1]);
            }
        } while (!reponse.equals(FIN_FORME));

        afficher(sortie);

        return true;
    }

    protected abstract void traiterVariable(String nom, String valeur);
    protected abstract void afficher(Sortie sortie);
}