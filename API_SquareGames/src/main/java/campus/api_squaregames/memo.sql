-- creation base si elle n'existe pas
# CREATE DATABASE IF NOT EXISTS square_games;

-- suppression table si elle existe
# DROP TABLE IF EXISTS square_games.game;

-- creation de la table game si elle n'existe pas
CREATE TABLE IF NOT EXISTS square_games.game (
                                                 id             int PRIMARY KEY NOT NULL AUTO_INCREMENT,
                                                 board_size     int,
                                                 uuid           varchar(50),
    game_status    varchar(20)
    );

-- creation de la table gameDtoPersistence si elle n'existe pas
CREATE TABLE IF NOT EXISTS square_games2.gameDtoPersistence (
                                                                uuid_game      bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
                                                                board_size     int,
                                                                game_status    varchar(20)
);

-- creation de la table tokenDtoPersistence si elle n'existe pas
CREATE TABLE IF NOT EXISTS square_games2.tokenDtoPersistence (
                                                                 id_token       bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
                                                                 name           varchar(20),
                                                                 positionX      int,
                                                                 positionY      int,
                                                                 uuidGame       bigint,
                                                                 FOREIGN KEY (uuidGame) REFERENCES gameDtoPersistence(uuid_game) ON DELETE CASCADE
);

-- test de creation d'un enregistrement
# INSERT INTO
# 	square_games.game (board_size, uuid, game_status)
# 	VALUES (3,'f1966786-6451-4780-b074-f4534798c739','ONGOING');