package campus.api_squaregames;

import fr.le_campus_numerique.square_games.engine.CellPosition;
import fr.le_campus_numerique.square_games.engine.GameStatus;
import fr.le_campus_numerique.square_games.engine.Token;

import java.util.Map;
import java.util.UUID;

public class GamePart {

    private GameStatus gameStatus;
    private UUID uuid;
    private Map<CellPosition, Token> board;

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setBoard(Map<CellPosition, Token> board) {
        this.board = board;
    }
}
