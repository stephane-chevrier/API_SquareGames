package campus.api_squaregames.daopersistence;

import campus.api_squaregames.dtopersistencee.*;
import campus.api_squaregames.entity.GameEntity;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.UUID;

@Component
public class GameDaoMySql implements GameDao {

    /**
     * Methode d'ajout d'un jeu dans la persistence
     * @param gameEntity
     */
    @Override
    public void addGamePersistence(GameDtoPersistence gameDtoPersistence) {
        // Code à implémenter

        // Pour tester le fonctionnement
        System.out.println("Sauvegarde du jeu n° "+gameDtoPersistence.getUuid());
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
