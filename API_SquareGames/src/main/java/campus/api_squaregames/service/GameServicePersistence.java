package campus.api_squaregames.service;

import campus.api_squaregames.dtoweb.GameDtoWeb;
import campus.api_squaregames.dtopersistencee.*;
import fr.le_campus_numerique.square_games.engine.CellPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * The type Game service persistence.
 */
@Service
public class GameServicePersistence {

    @Autowired
    private GameDtoPersistenceRepository gameDao;

    @Autowired
    private TokenDtoPersistenceRepository tokenDao;

    /**
     * Sets game entity.
     *
     * @param  gameDtoWeb
     */
    public void setGameDtoPersistence(GameDtoWeb gameDtoWeb) {

        GameDtoPersistence gameDtoPersistence = new GameDtoPersistence();
        gameDtoPersistence.setGameStatus(gameDtoWeb.getGameStatus());
        gameDtoPersistence.setUuid(gameDtoWeb.getUuid());
        gameDtoPersistence.setBoardSize(gameDtoWeb.getBoardSize());


        // Appel du Dao pour enregistrer le Dto
        gameDao.save(gameDtoPersistence);

    }
    /**
     * Sets tokken entity.
     *
     * @param  gameDtoWeb
     */
    public void setTokenDtoPersistence(GameDtoWeb gameDtoWeb) {

        // creation et initialisation de l'objet tokenDtoPersistence
        TokenDtoPersistence tokenDtoPersistence = new TokenDtoPersistence();
        tokenDtoPersistence.setName(gameDtoWeb.getName());
        tokenDtoPersistence.setPositionX(gameDtoWeb.getPositionX());
        tokenDtoPersistence.setPositionY(gameDtoWeb.getPositionY());

        // initialisation de la propriete de tokenDtoPersistence correspondant a la clef etrangere
        tokenDtoPersistence.setGameDtoPersistence(
                new GameDtoPersistence( gameDtoWeb.getUuid(),
                                        gameDtoWeb.getBoardSize(),
                                        gameDtoWeb.getGameStatus().toString()));

        // Appel du Dao pour enregistrer le Dto
        tokenDao.save(tokenDtoPersistence);

    }
//    /**
//     * Gets game get list by status.
//     *
//     * @param gameGetListByStatus the game get list by status
//     * @return the game get list by status
//     * @throws SQLException the sql exception
//     */
//    public ArrayList<GameEntity> getGameGetListByStatus(GameGetListByStatus gameGetListByStatus) throws SQLException {
//
//        // creation de l'objet gameEntity et de la liste de GameEntity pour preparation du retour
//        ArrayList<GameEntity> gameEntities = new ArrayList<>();
//
//        // creation de la liste d'objet GameReturnGetListByStatus pour appeler le DAO
//        ArrayList<GameReturnGetListByStatus> gameReturnGetListByStatuses;
//
//        // Appel du Dao
////        gameReturnGetListByStatuses = gameDao.getGameListPersistence(gameGetListByStatus);
//
//        // Boucle de recuperation de chaque element de la liste de retour recupereé/transformé par le DAO
////        for (int i=0; i<gameReturnGetListByStatuses.size(); i++) {
////            GameEntity gameEntity = new GameEntity();
////            gameEntity.setBoardSize(gameReturnGetListByStatuses.get(i).getBoardSize());
////            gameEntity.setUuid(gameReturnGetListByStatuses.get(i).getUUID());
////            gameEntity.setGameStatus(gameReturnGetListByStatuses.get(i).getStatus());
////            gameEntities.add(gameEntity);
////        }
//
//        // retour
//        return gameEntities;
//    }
}
