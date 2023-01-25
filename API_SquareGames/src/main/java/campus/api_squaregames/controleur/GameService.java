package campus.api_squaregames.controleur;


import campus.api_squaregames.dtoapi.GameCreationParams;
import campus.api_squaregames.dtoapi.GameDto;
import campus.api_squaregames.entity.GameEntity;
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
    GameDto getGamePart(GameEntity gameEntity);
}
