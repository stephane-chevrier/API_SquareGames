package campus.api_squaregames.controleur;

import campus.api_squaregames.dtoapi.GameCreationParams;
import campus.api_squaregames.entity.GameEntity;
import fr.le_campus_numerique.square_games.engine.*;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class GameServiceImpl implements GameService {

    // creation des variables d'instance
    public Map<UUID, GameEntity> gamePartMap = new HashMap<>();


    /**
     * method de creation d'une partie
     * @param gameCreationParams
     * @return
     */
    public GameEntity createGameService(GameCreationParams gameCreationParams) {

        // Creation d'un objet GameFactory et GameEntity
        GameFactory gameFactory = null;
        GameEntity gameEntity = new GameEntity();

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

        // Création du game
        Game game = gameFactory.createGame(gameCreationParams.getPlayerCount(),gameCreationParams.getBoardSize());

        // Transfert du game au gameEntity
        gameEntity.setGameStatus(game.getStatus());
        gameEntity.setBoard(game.getBoard());
        gameEntity.setUuid(UUID.randomUUID());

        // implémentation de la liste des parties avec la partie en-cours de création
        gamePartMap.put(gameEntity.getUuid(), gameEntity);

        // retour de gameEntity
        return gameEntity;
    }

    /**
     * method de retour du status d'une partie
     * @param
     * @return GameStatus
     */
    public GameStatus getGameStatusService(int gameId) {
        // retour du status de la partie du gameID envoyé
        return gamePartMap.get(gameId).getGameStatus();

    }

}

