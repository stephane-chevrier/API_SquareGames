//package campus.api_squaregames.daopersistence;
//
//import campus.api_squaregames.dtopersistencee.*;
//import campus.api_squaregames.entity.GameEntity;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.UUID;
//
//public interface GameDao {
//
//    /**
//     * Init connexion my sql connection.
//     *
//     * @return the connection
//     * @throws SQLException the sql exception
//     */
//    Connection initConnexionMySql() throws SQLException;
//
//    /**
//     * Methode d'ajout d'un jeu dans la persistence
//     * @param gameEntity
//     */
//    void addGamePersistence(GameDtoPersistence gameDtoPersistence) throws SQLException;
//    /**
//     * Methode de suppression d'un jeu dans la persistence
//     * @param gameEntity
//     */
//    void deleteGamePersistence(GameEntity gameEntity);
//    /**
//     * Methode de mise à jour d'un jeu dans la persistence
//     * @param gameEntity
//     */
//    void updateGamePersistence(GameEntity gameEntity);
//
//    /**
//     * Methode de recuperation d'un jeu a partir de son UUID
//     * @param uuid
//     * @return gameEntity
//     */
//    GameEntity getGamePersistence(UUID uuid);
//
//    /**
//     * Gets game list persistence.
//     *
//     * @param gameGetListByStatus the game get list by status
//     * @return the game list persistence
//     * @throws SQLException the sql exception
//     */
//    ArrayList<GameReturnGetListByStatus> getGameListPersistence(GameGetListByStatus gameGetListByStatus) throws SQLException;
//}
