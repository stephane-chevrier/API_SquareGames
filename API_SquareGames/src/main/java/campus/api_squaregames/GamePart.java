package campus.api_squaregames;

import fr.le_campus_numerique.square_games.engine.CellPosition;
import fr.le_campus_numerique.square_games.engine.GameStatus;
import fr.le_campus_numerique.square_games.engine.Token;
import java.util.Map;
import java.util.UUID;


public class GamePart {

    // création des variables d'instance
    private int gamePartId;
    private GameStatus gameStatus;
    private UUID uuid;
    private Map<CellPosition, Token> board;

    /**
     * Setter de gameStatus
     * @param gameStatus
     */
    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
    /**
     * Setter de uuid
     * @param uuid
     */
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
    /**
     * Setter de board
     * @param board
     */
    public void setBoard(Map<CellPosition, Token> board) {
        this.board = board;
    }

    /**
     * Getter de gameStatus
     */
    public GameStatus getGameStatus() {
        return gameStatus;
    }

    /**
     * Getter de uuid
     */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * Getter de board
     */
    public Map<CellPosition, Token> getBoard() {
        return board;
    }

    public int getGamePartId() {
        return gamePartId;
    }

    public void setGamePartId(int gamePartId) {
        this.gamePartId = gamePartId;
    }
}
