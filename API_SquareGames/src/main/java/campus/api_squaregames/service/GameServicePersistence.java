package campus.api_squaregames.service;

import campus.api_squaregames.dtopersistencee.*;
import campus.api_squaregames.entity.GameEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The type Game service persistence.
 */
@Service
public class GameServicePersistence {

    @Autowired
    private GameDtoPersistenceRepository gameDao;

    /**
     * Sets game entity.
     *
     * @param gameDtoPersistence the game dto persistence
     */
    public void setGameDtoPersistence(GameDtoPersistence gameDtoPersistence) {

        // Appel du Dao
        gameDao.save(gameDtoPersistence);
    }

    /**
     * Gets game get list by status.
     *
     * @param gameGetListByStatus the game get list by status
     * @return the game get list by status
     * @throws SQLException the sql exception
     */
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
