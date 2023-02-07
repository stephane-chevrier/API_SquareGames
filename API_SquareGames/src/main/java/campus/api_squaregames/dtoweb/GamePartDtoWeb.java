package campus.api_squaregames.dtoweb;

public class GamePartDtoWeb {

    // creation des proprietes de l'objet
    private Long idGamepart;

    private String gameId;

    private String gameStatus;

    private Long currentPlayer;

    public GamePartDtoWeb() {
    }


    /**
     * Gets game id.
     *
     * @return the game id
     */
    public String getGameId() {
        return gameId;
    }

    /**
     * Sets game id.
     *
     * @param gameId the game id
     */
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

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
    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }

    /**
     * Gets current player.
     *
     * @return the current player
     */
    public Long getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Sets current player.
     *
     * @param currentPlayer the current player
     */
    public void setCurrentPlayer(Long currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    /**
     * Gets id gamepart.
     *
     * @return the id gamepart
     */
    public Long getIdGamepart() {
        return idGamepart;
    }

    /**
     * Sets id gamepart.
     *
     * @param idGamepart the id gamepart
     */
    public void setIdGamepart(Long idGamepart) {
        this.idGamepart = idGamepart;
    }
}
