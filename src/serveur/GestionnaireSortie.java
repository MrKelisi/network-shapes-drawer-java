package serveur;

import exception.CreationSortieException;

public interface GestionnaireSortie {
    /**
     * Crée une nouvelle sortie
     * @return Nouvelle sortie
     * @throws CreationSortieException si la sortie n'a pas pu être crée
     */
    Sortie creerSortie() throws CreationSortieException;
}