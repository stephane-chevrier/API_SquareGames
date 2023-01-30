package campus.api_squaregames.service;

import campus.api_squaregames.dtoweb.GameCreationParams;
import campus.api_squaregames.dtoweb.GameDtoWeb;
import campus.api_squaregames.entity.GameEntity;
import fr.le_campus_numerique.square_games.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class GameServiceImpl implements GameService {

    // creation des variables d'instance
    public Map<UUID, GameEntity> gamePartMap = new HashMap<>();

    @Value("en")
    private Locale langue;

    @Autowired
    List<GamePlugin> factories = new ArrayList<>();

    /**
     * method de creation d'une partie
     * @param gameCreationParams
     * @return
     */
    public GameEntity createGameService(GameCreationParams gameCreationParams, String langage) {

        // affiche le contenu de la clef messageBienvenue dans le fichier message_XX
        this.langue = Locale.forLanguageTag(langage);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message",langue);
        System.out.println(resourceBundle.getString("messageBienvenue"));

        // recuperation de l'index de gameType de la requete dans la liste des factories
        int index = factories.stream()
                .map(o -> o.getName().toLowerCase())

                .toList()
                .indexOf(gameCreationParams.getGameType().toLowerCase());

        // Creation d'un objet GameFactory et GameEntity
        GameFactory gameFactory = this.factories.get(index).getGameFactory();
        GameEntity gameEntity = new GameEntity();

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
        Game game = gameFactory.createGame(nombreJoueursDefaut,gameCreationParams.getBoardSize());

        // Transfert du game au gameEntity
        gameEntity.setGameStatus(game.getStatus());
//        gameEntity.setBoard(game.getBoard());
        gameEntity.setUuid(UUID.randomUUID());
        gameEntity.setBoardSize(game.getBoardSize());

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

    /**
     * methode de retour des attributs de GamePart
     * @param gameEntity
     * @param
     * @return GamePart
     */
    @Override
    public GameDtoWeb getGamePart(GameEntity gameEntity /*, String entete */) {


        // creation d'un objet GamePart
        GameDtoWeb gameDtoWeb = new GameDtoWeb();

        // initialisation des valeurs des objets GameStatus, UUID, Map<CellPosition, Token>, gamePartId dans objet GamePart
        gameDtoWeb.setGameStatus(gameEntity.getGameStatus());
//        gameDtoApi.setBoard(gameEntity.getBoard());
        gameDtoWeb.setUuid(gameEntity.getUuid());
        gameDtoWeb.setBoardSize(gameEntity.getBoardSize());

        // retour de l'objet GamePart qui contient les elements d'une partie
        return gameDtoWeb;
    }
}

