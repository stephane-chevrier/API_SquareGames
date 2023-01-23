import fr.le_campus_numerique.square_games.engine.CellPosition;
import fr.le_campus_numerique.square_games.engine.GameStatus;
import fr.le_campus_numerique.square_games.engine.Token;

import java.util.Collection;
import java.util.Map;

public class GameState {

    // Creation des variables d'instances
    public String FactoryId;

    public GameStatus Status;

    public int BoardSize;

    public Map<CellPosition, Token> Board;

    public Collection<Token> RemaingTokens;

    public Collection<Token> RemoveTokens;

    public String getFactoryId() {
        return FactoryId;
    }

    public void setFactoryId(String factoryId) {
        FactoryId = factoryId;
    }

    public GameStatus getStatus() {
        return Status;
    }

    public void setStatus(GameStatus status) {
        Status = status;
    }

    public int getBoardSize() {
        return BoardSize;
    }

    public void setBoardSize(int boardSize) {
        BoardSize = boardSize;
    }

    public Map<CellPosition, Token> getBoard() {
        return Board;
    }

    public void setBoard(Map<CellPosition, Token> board) {
        Board = board;
    }

    public Collection<Token> getRemaingTokens() {
        return RemaingTokens;
    }

    public void setRemaingTokens(Collection<Token> remaingTokens) {
        RemaingTokens = remaingTokens;
    }

    public Collection<Token> getRemoveTokens() {
        return RemoveTokens;
    }

    public void setRemoveTokens(Collection<Token> removeTokens) {
        RemoveTokens = removeTokens;
    }

}
