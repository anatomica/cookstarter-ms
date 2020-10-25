CREATE TABLE IF NOT EXISTS restaurants
(
    id    BIGSERIAL PRIMARY KEY ,
    name  VARCHAR(200) NOT NULL ,
    description VARCHAR(200) NOT NULL ,
    contact VARCHAR(200)  NOT NULL,
    menu VARCHAR(200)  NOT NULL
);
