package campus.api_squaregames.daopersistence;

import campus.api_squaregames.dtopersistencee.*;
import campus.api_squaregames.entity.GameEntity;

import java.util.Map;
import java.util.UUID;

public interface GameDao {

    /**
     * Methode d'ajout d'un jeu dans la persistence
     * @param gameEntity
     */
    void addGamePersistence(GameDtoPersistence gameDtoPersistence);
    /**
     * Methode de suppression d'un jeu dans la persistence
     * @param gameEntity
     */
    void deleteGamePersistence(GameEntity gameEntity);
    /**
     * Methode de mise à jour d'un jeu dans la persistence
     * @param gameEntity
     */
    void updateGamePersistence(GameEntity gameEntity);

    /**
     * Methode de recuperation d'un jeu a partir de son UUID
     * @param uuid
     * @return gameEntity
     */
    GameEntity getGamePersistence(UUID uuid);

    /**
     * Methode de recuperation de la liste des jeux
     * @return Map<UUID,GameEntity>
     */
    Map<UUID,GameEntity> getGameListPersistence();
}
