package campus.api_squaregames.entity;

import fr.le_campus_numerique.square_games.engine.CellPosition;
import fr.le_campus_numerique.square_games.engine.GameStatus;
import fr.le_campus_numerique.square_games.engine.Token;
import java.util.Map;
import java.util.UUID;


public class GameEntity {

    // Creation des variables d'instances
    private GameStatus gameStatus;
    private UUID uuid;
    private Map<CellPosition, Token> board;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Map<CellPosition, Token> getBoard() {
        return board;
    }

    public void setBoard(Map<CellPosition, Token> board) {
        this.board = board;
    }
}
