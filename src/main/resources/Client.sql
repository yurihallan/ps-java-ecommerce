DROP TABLE IF EXISTS Client;

CREATE TABLE Client(
    ID BIGINT auto_increment  ,
    NAME VARCHAR(250),
    cpf VARCHAR(11),
    
    PRIMARY KEY(ID)
);
