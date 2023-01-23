package campus.api_squaregames;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.GameStatus;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
   private GameService gameService = new GameServiceImpl();

    /**
     * method de creation d'une partie
     * @param gameCreationParams
     * @return
     */
    @PostMapping("/games")
    public GamePart createGame(@RequestBody GameCreationParams gameCreationParams) {
        GamePart gamePart = getGamePart(gameService.createGameService(gameCreationParams));
        // Appel du service de creation d'une partie et retour des attributs de Game necessaires
        return gamePart;
    }
    /**
     * method de creation d'une partie
     * @param Integer
     * @return Object
     */
    @GetMapping("/games/{gameId}/status")
    public Object getGameStatus(@PathVariable("gameId") int gameId) {
        // Appel du service de retour du status d'une partie à partie de son Id et retour de ce status
        return gameService.getGameStatusService(gameId);
    }

    /**
     * methode de retour des attributs de GamePart
     * @param game
     * @return GamePart
     */
    public GamePart getGamePart(Game game) {

        // creation d'un objet GamePart
        GamePart gamePart = new GamePart();

        // initialisation des valeurs des objets GameStatus, UUID, Map<CellPosition, Token>, gamePartId dans objet GamePart
        gamePart.setGameStatus(game.getStatus());
        gamePart.setUuid(game.getCurrentPlayerId());
        gamePart.setBoard(game.getBoard());
        if (gameService.getGamePartMap()!=null) {
            gamePart.setGamePartId(gameService.getGamePartMap().keySet().size()+1);
        } else {
            gamePart.setGamePartId(1);
        }

        // implémentation de la liste des parties avec la partie en-cours de création
        gameService.getGamePartMap().put(gamePart.getGamePartId(), gamePart);

        // retour de l'objet GamePart qui contient les elements d'une partie
        return gamePart;
    }

}
