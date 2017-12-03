package serveur;

import exception.FormeException;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class TraitementReseauCOR implements TraitementReseau {
    private TraitementReseauCOR next;

    public TraitementReseauCOR(TraitementReseauCOR next) {
        this.next = next;
        reset();
    }

    @Override
    public void traiter(String texte, BufferedReader entree, Sortie sortie) throws IOException, FormeException {
        if(texte == null) {
            throw new NullPointerException("Le texte ne peut pas être null");
        }
        if(sortie == null) {
            throw new NullPointerException("La sortie ne peut pas être null");
        }
        if(entree == null) {
            throw new NullPointerException("L'entrée ne peut pas être null");
        }

        if(!traiterInterne(texte, entree, sortie) && next != null) {
            next.traiter(texte, entree, sortie);
        }
        else {
            reset();
        }
    }

    /**
     * Traitement interne des communications
     * @param texte Première ligne reçue (nom de la forme)
     * @param entree Buffer d'entrée
     * @param sortie Destination des formes
     * @return Vrai si l'instuction a été traitée
     * @throws IOException si erreur de lecture
     * @throws FormeException si la forme est invalide
     */
    protected abstract boolean traiterInterne(String texte, BufferedReader entree, Sortie sortie) throws IOException, FormeException;

    /**
     * Remet à 0 les champs de la classe après son utilisation
     */
    protected abstract void reset();
}