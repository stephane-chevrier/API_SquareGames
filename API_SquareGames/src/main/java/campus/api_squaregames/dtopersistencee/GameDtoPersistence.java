package campus.api_squaregames.dtopersistencee;

import fr.le_campus_numerique.square_games.engine.GameStatus;
import java.util.UUID;

/**
 * The type Game dto persistence.
 */
public class GameDtoPersistence {

    // Creation des variables d'instances
    private int boardSize;
    private UUID uuid;
    private GameStatus gameStatus;


    /**
     * Gets game status.
     *
     * @return the game status
     */
    public String getGameStatus() {
        return gameStatus.toString();
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
     * Gets uuid.
     *
     * @return the uuid
     */
    public String getUuid() {
        return uuid.toString();
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
}
