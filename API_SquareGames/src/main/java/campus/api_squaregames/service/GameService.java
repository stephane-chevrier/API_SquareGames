package campus.api_squaregames.service;


import campus.api_squaregames.dtoweb.GameCreationParams;
import campus.api_squaregames.dtoweb.GameDtoWeb;
import fr.le_campus_numerique.square_games.engine.GameStatus;

public interface GameService {

    /**
     * method de creation d'une partie
     * @param gameCreationParams
     * @return
     */
    GameEntity createGameService(GameCreationParams gameCreationParams, String entete);


    GameStatus getGameStatusService(int gameId);

    /**
     * methode de retour des attributs de GamePart
     * @param gameEntity
     * @param entete
     * @return GamePart
     */
    GameDtoWeb getGamePart(GameEntity gameEntity);
}
