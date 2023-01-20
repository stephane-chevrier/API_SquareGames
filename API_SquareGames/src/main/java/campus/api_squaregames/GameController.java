package campus.api_squaregames;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    /**
     * method de creation d'une partie
     * @param params
     * @return
     */
    @PostMapping("/games")
    public String createGame(@RequestBody GameCreationParams params) {

        // Creation d'un jeu TicTacToe
        Game game = new TicTacToeGame();

        // retour des attributs de Game necessaires
        return getGamePart(game).toString();
    }
    /**
     * methode de retour des attributs de GamePart
     * @param game
     * @return GamePart
     */
    private GamePart getGamePart(Game game) {

        // creation d'un objet GamePart
        GamePart gamePart = new GamePart();

        // recuperation des valeurs des objets GameStatus, UUID, Map<CellPosition, Token> dans objet GamePart
        gamePart.setGameStatus(game.getStatus());
        gamePart.setUuid(game.getCurrentPlayerId());
        gamePart.setBoard(game.getBoard());
        return gamePart;
    }
//    @GetMapping("/games/{gameId}")
//    public Object getGame(@PathVariable("gameId") String gameId) {
//        // TODO - actually get and return game with id 'gameId'
//        return null;
//    }


}
