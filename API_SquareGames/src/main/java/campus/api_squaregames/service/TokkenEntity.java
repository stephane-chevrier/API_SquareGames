package campus.api_squaregames.service;

import fr.le_campus_numerique.square_games.engine.CellPosition;
import java.util.UUID;

/**
 * The type Tokken entity.
 */
public class TokkenEntity {

// Création des variables d'instance
    UUID uuid;
    String name;
    CellPosition position;

    /**
     * Gets owner id.
     *
     * @return the owner id
     */
    public UUID getOwnerId() {
        return uuid;
    }

    /**
     * Sets owner id.
     *
     * @param ownerId the owner id
     */
    public void setOwnerId(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets position.
     *
     * @return the position
     */
    public CellPosition getPosition() {
        return position;
    }

    /**
     * Sets position.
     *
     * @param position the position
     */
    public void setPosition(CellPosition position) {
        this.position = position;
    }
}
