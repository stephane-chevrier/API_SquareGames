package campus.api_squaregames.dtopersistencee;

import fr.le_campus_numerique.square_games.engine.GameStatus;
import jakarta.persistence.*;

import java.util.UUID;

/**
 * The type Game dto persistence.
 */
@Entity
//@Table(name="toto")
public class GameDtoPersistence {

    // Creation des variables d'instances
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private UUID uuid;
    private int boardSize;
    private String gameStatus;


    /**
     * Gets game status.
     *
     * @return the game status
     */
    public String getGameStatus() {
        return gameStatus;
    }

    /**
     * Sets game status.
     *
     * @param gameStatus the game status
     */
    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus.toString();
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
