package campus.api_squaregames.dtoweb;

import fr.le_campus_numerique.square_games.engine.GameStatus;

import java.util.UUID;

    public class GameDtoWeb {

        // création des variables d'instance
        private GameStatus gameStatus;
        private UUID uuid;
        private int BoardSize;
        private String name;
        private int positionX;
        private int positionY;

        public GameDtoWeb() {
        }

        /**
         * Gets board size.
         *
         * @return the board size
         */
        public int getBoardSize() {
        return BoardSize;
    }

        /**
         * Sets board size.
         *
         * @param boardSize the board size
         */
        public void setBoardSize(int boardSize) {
        BoardSize = boardSize;
    }

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
         * Gets position x.
         *
         * @return the position x
         */
        public int getPositionX() {
            return positionX;
        }

        /**
         * Sets position x.
         *
         * @param positionX the position x
         */
        public void setPositionX(int positionX) {
            this.positionX = positionX;
        }

        /**
         * Gets position y.
         *
         * @return the position y
         */
        public int getPositionY() {
            return positionY;
        }

        /**
         * Sets position y.
         *
         * @param positionY the position y
         */
        public void setPositionY(int positionY) {
            this.positionY = positionY;
        }
    }
