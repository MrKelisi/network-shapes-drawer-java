package serveur;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class TraitementReseauCOR implements TraitementReseau {
    private TraitementReseauCOR next;

    public TraitementReseauCOR(TraitementReseauCOR next) {
        this.next = next;
    }

    @Override
    public void traiter(String texte, BufferedReader entree, Sortie sortie) throws IOException {
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
    }

    protected abstract boolean traiterInterne(String texte, BufferedReader entree, Sortie sortie) throws IOException;
}