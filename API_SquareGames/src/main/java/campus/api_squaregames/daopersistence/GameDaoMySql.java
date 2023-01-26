package campus.api_squaregames.daopersistence;

import campus.api_squaregames.dtopersistencee.*;
import campus.api_squaregames.entity.GameEntity;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.Map;
import java.util.UUID;

@Component
public class GameDaoMySql implements GameDao {

    /**
     * Methode d'ajout d'un jeu dans la persistence
     * @param gameDtoPersistence
     */
    @Override
    public void addGamePersistence(GameDtoPersistence gameDtoPersistence) throws SQLException {

        // Initialisation de la connexion si elle n'existe pas
        Connection connexion = SingletonConnexion.getInstance().getConnexion();

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
    public Map<UUID,GameEntity> getGameListPersistence() {
        // Code à implémenter
        return null;
    }
}
