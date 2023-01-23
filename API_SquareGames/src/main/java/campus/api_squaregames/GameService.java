package campus.api_squaregames;


import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

public interface GameService {

    /**
     * method de creation d'une partie
     * @param gameCreationParams
     * @return
     */
    Game createGameService(GameCreationParams gameCreationParams);


    GameStatus getGameStatusService(int gameId);

    /**
     * Getter de gamePartMap
     * @return Map<Integer,GamePart>
     */
    Map<Integer, GamePart> getGamePartMap();

}
