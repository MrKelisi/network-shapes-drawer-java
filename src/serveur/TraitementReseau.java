package serveur;

import java.io.BufferedReader;
import java.io.IOException;

public interface TraitementReseau {
    /**
     * Traite les instructions reçues sur le réseau
     * @param texte Première ligne reçue (nom de la forme)
     * @param entree Buffer d'entrée
     * @param sortie Destination des formes
     * @throws IOException si erreur de lecture
     */
    void traiter(String texte, BufferedReader entree, Sortie sortie) throws IOException;
}