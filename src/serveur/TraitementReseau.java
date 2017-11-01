package serveur;

import java.io.BufferedReader;
import java.io.IOException;

public interface TraitementReseau {
    void traiter(String texte, BufferedReader entree, Sortie sortie) throws IOException;
}