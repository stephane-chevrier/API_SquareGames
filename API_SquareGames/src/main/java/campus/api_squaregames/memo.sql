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

-- creation de la table gamepart de la base square_stats
CREATE TABLE IF NOT EXISTS square_stats.gamepart (
     id             bigint PRIMARY KEY NOT NULL,
     game_id        varchar(20),
     game_status    varchar(20),
     current_player bigint
);
INSERT INTO
    square_stats.gamepart(id,game_id, game_status, current_player)
VALUES (1,'tictactoe','ONGOING',1),
       (2,'tictactoe','TERMINATED',1),
       (3,'tictactoe','TERMINATED',null),
       (4,'tictactoe','TERMINATED',2),
       (5,'tictactoe','TERMINATED',1),
       (6,'15 puzzle','TERMINATED',1);

-- creation de la table gamepartplayer de la base square_stats
CREATE TABLE IF NOT EXISTS square_stats.gamepartplayer (
       id_gamepart             bigint PRIMARY KEY NOT NULL,
       FOREIGN KEY (id_gamepart) REFERENCES gamepart(id)  ON DELETE CASCADE,
       player                  bigint
);
INSERT INTO square_stats.gamepartplayer(id_gamepart, player)
VALUES (1,1),
       (1,2),
       (2,1),
       (2,2),
       (3,1),
       (3,2),
       (4,2),
       (4,3),
       (5,1),
       (5,3),
       (6,1),
       (6,2);