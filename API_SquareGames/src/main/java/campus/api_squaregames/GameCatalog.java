package campus.api_squaregames;

import fr.le_campus_numerique.square_games.engine.GameFactory;
import java.util.Map;

/**
 * Nom             GameCatalog
 * Description     Interface
 * @version v1.0
 * Date            19 janvier 2023
 * @author Stéphane CHEVRIER
 */

public interface GameCatalog {

    /**
     *  methode de récupération de la liste des identifiants des jeux disponibles
      * @return Collection<String>
     */
    Map<String, GameFactory> getGameIdentifiers();

}
