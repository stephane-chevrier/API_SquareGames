package campus.api_squaregames.service;

import fr.le_campus_numerique.square_games.engine.GameStatus;
import java.util.UUID;

/**
 * The type Game entity.
 */
public class GameEntity {

    // Creation des variables d'instances
    private GameStatus gameStatus;

    private UUID uuid;

    private int boardSize;

    /**
     * Instantiates a new Game entity.
     */
    public GameEntity() {
    }

    /**
     * Instantiates a new Game entity.
     *
     * @param gameStatus the game status
     * @param uuid       the uuid
     * @param boardSize  the board size
     */
    public GameEntity(GameStatus gameStatus, UUID uuid, int boardSize) {
        this.gameStatus = gameStatus;
        this.uuid = uuid;
        this.boardSize = boardSize;
    }

    /**
     * Gets board size.
     *
     * @return the board size
     */
    public int getBoardSize() {
        return boardSize;
    }

    /**
     * Sets board size.
     *
     * @param boardSize the board size
     */
    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    /**
     * Gets uuid.
     *
     * @return the uuid
     */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * Sets uuid.
     *
     * @param uuid the uuid
     */
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * Sets uuid.
     * Surcharge de method pour transformer un uuid de type String en uuid de type UUID
     * @param uuid the uuid
     */
    public void setUuid(String uuid) {
        this.uuid = UUID.fromString(uuid);
    }

    /**
     * Gets game status.
     *
     * @return the game status
     */
    public GameStatus getGameStatus() {
        return gameStatus;
    }

    /**
     * Sets game status.
     *
     * @param gameStatus the game status
     */
    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    /**
     * Sets game status.
     * Surcharge de method pour transformer un status de type String en status de type GameStatus
     * @param gameStatus the game status
     */
    public void setGameStatus(String gameStatus) {
        switch (gameStatus) {
            case "ONGOING" -> { this.gameStatus = GameStatus.ONGOING;}
            case "TERMINATED" -> { this.gameStatus = GameStatus.TERMINATED;}
            case "SETUP" -> { this.gameStatus = GameStatus.SETUP;}
        }
    }

}
