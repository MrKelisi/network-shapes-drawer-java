package serveur;

import exception.FormeException;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class TraitementReseauForme extends TraitementReseauCOR {
    private final static String FIN_FORME = "FIN";
    private String nomForme;
    private String couleur;

    public TraitementReseauForme(TraitementReseauCOR next, String nomForme) {
        super(next);

        if(nomForme == null) {
            throw new NullPointerException("Le nom de la forme ne peut pas être null");
        }

        this.nomForme = nomForme;
    }

    @Override
    protected boolean traiterInterne(String texte, BufferedReader entree, Sortie sortie) throws IOException, FormeException {
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

    /**
     * Traite une variable reçue
     * @param nom Nom de la variable
     * @param valeur Valeur
     */
    private void traiterVariable(String nom, String valeur) {
        switch (nom) {
            case "couleur":
                couleur = valeur;
                break;

            default:
                traiterVariableInterne(nom, valeur);
                break;
        }
    }

    /**
     * Affiche la forme sur la sortie
     * @param sortie Destination
     * @throws FormeException si la forme est invalide
     */
    private void afficher(Sortie sortie) throws FormeException {
        if(couleur == null) {
            throw new FormeException("La couleur n'a pas été donnée");
        }

        sortie.setCouleur(couleur);

        afficherInterne(sortie);
    }

    /**
     * Traite une variable spécifique au type de forme
     * @param nom Nom de la variable
     * @param valeur Valeur
     */
    protected abstract void traiterVariableInterne(String nom, String valeur);

    /**
     * Affiche la forme spécifique
     * @param sortie Destination
     * @throws FormeException si la forme est invalide
     */
    protected abstract void afficherInterne(Sortie sortie) throws FormeException;
}