package campus.api_squaregames.daopersistence;

import campus.api_squaregames.dtopersistencee.*;
import campus.api_squaregames.entity.GameEntity;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

@Component
public class GameDaoMySql implements GameDao {

    @Override
    public Connection initConnexionMySql() throws SQLException {
        return SingletonConnexion.getInstance().getConnexion();
    }
    /**
     * Methode d'ajout d'un jeu dans la persistence
     * @param gameDtoPersistence
     */
    @Override
    public void addGamePersistence(GameDtoPersistence gameDtoPersistence) throws SQLException {

        // Initialisation de la connexion si elle n'existe pas
        Connection connexion = initConnexionMySql();

        // Initialisation de la requete avec les proprietes de gameDtoPersistence recu en parametre
        String requete = "INSERT INTO game (board_size,uuid,game_status) VALUES (?,?,?)";

        // Preparation de l'envoi de la requete
        PreparedStatement statement = connexion.prepareStatement(requete);
        statement.setInt(1,gameDtoPersistence.getBoardSize());
        statement.setString(2,gameDtoPersistence.getUuid());
        statement.setString(3,gameDtoPersistence.getGameStatus());

        // Envoi de la requete et recuperation du nombre d'enregistrements mis a jour (dans ce cas toujours =1)
        statement.executeUpdate();
    }

    /**
     * Methode de suppression d'un jeu dans la persistence
     * @param gameEntity
     */
    @Override
    public void deleteGamePersistence(GameEntity gameEntity) {
        // Code à implémenter
    }
    /**
     * Methode de mise à jour d'un jeu dans la persistence
     * @param gameEntity
     */
    @Override
    public void updateGamePersistence(GameEntity gameEntity) {
        // Code à implémenter
    }

    /**
     * Methode de recuperation d'un jeu a partir de son UUID
     * @param uuid
     * @return gameEntity
     */
    @Override
    public GameEntity getGamePersistence(UUID uuid) {
        // Code à implémenter
        return null;
    }

    /**
     * Methode de recuperation de la liste des jeux
     * @return Map<UUID,GameEntity>
     */
    @Override
    public ArrayList<GameReturnGetListByStatus> getGameListPersistence(GameGetListByStatus gameGetListByStatus) throws SQLException {

        // Initialisation de la liste d'objets de retour
        ArrayList<GameReturnGetListByStatus> ArrayListRetour = new ArrayList<GameReturnGetListByStatus>();

        // Initialisation de la connexion si elle n'existe pas
        Connection connexion = initConnexionMySql();

        // Initialisation de la requete avec les proprietes de gameDtoPersistence recu en parametre
        String requete = "SELECT * FROM game WHERE game_status = ?";

        // Preparation de l'envoi de la requete
        PreparedStatement statement = connexion.prepareStatement(requete);
        statement.setString(1,gameGetListByStatus.getGameStatus());

        // Envoi de la requete et recuperation du resultat
        ResultSet resultSet = statement.executeQuery();

        // recuperation des donnees du resultSet
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        while (resultSet.next()) {
            GameReturnGetListByStatus retour = new GameReturnGetListByStatus();
            retour.setBoardSize(resultSet.getInt(2));
            retour.setUUID(resultSet.getString(3));
            retour.setStatus(resultSet.getString(4));
            ArrayListRetour.add(retour);
        }
        return ArrayListRetour;
    }
}
