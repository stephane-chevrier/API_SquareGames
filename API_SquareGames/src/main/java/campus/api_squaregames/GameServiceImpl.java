package campus.api_squaregames;

import fr.le_campus_numerique.square_games.engine.*;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;

@Service
public class GameServiceImpl implements GameService {

    // creation des variables d'instance
    public Map<Integer,GamePart> gamePartMap = new HashMap<>();


















    /**
     * method de creation d'une partie
     * @param gameCreationParams
     * @return
     */
    public Game createGameService(GameCreationParams gameCreationParams) {

        // Creation d'un objet game
        GameFactory gameFactory = null;

        // creation du bon jeu en fonction du GameType de gameCreationParams
        switch (gameCreationParams.getGameType()) {

            // Creation d'un jeu TicTacToe
            case ("tictactoe") -> {
                gameFactory = new TicTacToeGameFactory();
            }
            // Creation d'un jeu 15 puzzle
            case ("15 puzzle") -> {
                gameFactory = new TaquinGameFactory();
            }
            // Creation d'un jeu connect4
            case ("connect4") -> {
                gameFactory = new ConnectFourGameFactory();
            }
        }
        // retour des attributs de Game necessaires
        return gameFactory.createGame(gameCreationParams.getPlayerCount(),gameCreationParams.getBoardSize());
    }

    /**
     * method de retour du status d'une partie
     * @param int
     * @return GameStatus
     */
    public GameStatus getGameStatusService(int gameId) {
        // retour du status de la partie du gameID envoyé
        return gamePartMap.get(gameId).getGameStatus();

    }

    /**
     * Getter de gamePartMap
     * @return Map<Integer,GamePart>
     */
    public Map<Integer, GamePart> getGamePartMap() {
        return gamePartMap;
    }
}

