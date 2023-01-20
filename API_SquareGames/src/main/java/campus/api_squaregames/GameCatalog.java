package campus.api_squaregames;

import java.util.Collection;

public interface GameCatalog {

    /**
     *  methode de récupération de la liste des identifiants des jeux disponibles
      * @return Collection<String>
     */
    abstract Collection<String> getGameIdentifiers();

}
