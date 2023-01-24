package campus.api_squaregames.controleur;

import campus.api_squaregames.dtoapi.GameCreationParams;
import campus.api_squaregames.entity.GameEntity;
import fr.le_campus_numerique.square_games.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class GameServiceImpl implements GameService {

    // creation des variables d'instance
    public Map<UUID, GameEntity> gamePartMap = new HashMap<>();

    @Autowired
    List<GamePlugin> factories = new ArrayList<>();

    // creation
//    @Autowired
//    GamePluginTicTacToe gamePluginTicTacToe;

    /**
     * method de creation d'une partie
     * @param gameCreationParams
     * @return
     */
    public GameEntity createGameService(GameCreationParams gameCreationParams) {

        int index = this.factories.indexOf(gameCreationParams.getGameType());

        // Creation d'un objet GameFactory et GameEntity
        GameFactory gameFactory = this.factories.get(index).getGameFactory();
        GameEntity gameEntity = new GameEntity();



        // creation du bon jeu en fonction du GameType de gameCreationParams
        switch (gameCreationParams.getGameType()) {

            // Creation d'un jeu TicTacToe
            case ("tictactoe") -> {
//                gamePlugin = gamePluginTicTacToe;
            }
            // Creation d'un jeu 15 puzzle
            case ("15 puzzle") -> {
//                gameFactory = new TaquinGameFactory();
            }
            // Creation d'un jeu connect4
            case ("connect4") -> {
//                gameFactory = new ConnectFourGameFactory();
            }
        }

        // Initialisation du nombre de joueurs reçus par la requete et par défaut
        int nombreJoueursRecus = gameCreationParams.getPlayerCount();
        int nombreJoueursDefaut = this.factories.get(index).getDefaultPlayerCount();

        // Affichage d'un message si incohérence
        if (nombreJoueursRecus!=nombreJoueursDefaut) {
            if (nombreJoueursRecus==0) {
                System.out.println("Vous n'avez pas spécifié le nombre de joueurs, il est par defaut "+nombreJoueursDefaut+" pour ce jeu.");
            } else {
                System.out.println(nombreJoueursRecus+" joueurs n'est pas correct, seul "+nombreJoueursDefaut+" est autorisé.");
            }
        }
        // Création du game avec le nombre de joueurs par defaut
//        Game game = gamePlugin.getGameFactory().createGame();
        Game game = gameFactory.createGame(nombreJoueursDefaut,gameCreationParams.getBoardSize());

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

