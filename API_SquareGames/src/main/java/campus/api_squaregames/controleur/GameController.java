package campus.api_squaregames.controleur;

import campus.api_squaregames.dtoapi.GameCreationParams;
import campus.api_squaregames.dtoapi.GameDto;
import campus.api_squaregames.entity.GameEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Nom             GameController
 * Description     Controleur de jeux
 * @version v1.0
 * Date            20 janvier 2023
 * @author Stéphane CHEVRIER
 */
@RestController
public class GameController {

    // création de l'objet gameService
   @Autowired
   private GameService gameService;

    /**
     * method de creation d'une partie
     * @param gameCreationParams
     * @return
     */
    @PostMapping("/games")
    public GameDto createGame(@RequestBody GameCreationParams gameCreationParams) {
        GameDto gameDto = getGamePart(gameService.createGameService(gameCreationParams));
        // Appel du service de creation d'une partie et retour des attributs de Game necessaires
        return gameDto;
    }
    /**
     * method de creation d'une partie
     * @param
     * @return Object
     */
    @GetMapping("/games/{gameId}/status")
    public Object getGameStatus(@PathVariable("gameId") int gameId) {
        // Appel du service de retour du status d'une partie à partie de son Id et retour de ce status
        return gameService.getGameStatusService(gameId);
    }

    /**
     * methode de retour des attributs de GamePart
     * @param gameEntity
     * @return GamePart
     */
    public GameDto getGamePart(GameEntity gameEntity) {

        // creation d'un objet GamePart
        GameDto gameDto = new GameDto();

        // initialisation des valeurs des objets GameStatus, UUID, Map<CellPosition, Token>, gamePartId dans objet GamePart
        gameDto.setGameStatus(gameEntity.getGameStatus());
        gameDto.setBoard(gameEntity.getBoard());
        gameDto.setUuid(gameEntity.getUuid());
        gameDto.setBoardSize(gameEntity.getBoardSize());

        // retour de l'objet GamePart qui contient les elements d'une partie
        return gameDto;
    }

}
