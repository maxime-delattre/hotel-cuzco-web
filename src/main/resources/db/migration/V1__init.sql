create table room
(
    number INT NOT NULL ,
    etage INT NOT NULL ,
    description VARCHAR(255) NOT NULL,
    capacite INT NOT NULL
);

ALTER TABLE room ADD CONSTRAINT room_pkey PRIMARY KEY(number);

INSERT INTO room VALUES ( 101, 1, 'belle chambre', 2 );
INSERT INTO room VALUES ( 102, 2, 'belle chambre', 3 );