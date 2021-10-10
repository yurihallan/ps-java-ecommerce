DROP TABLE IF EXISTS ItemCart;

CREATE TABLE ItemCart(
    ID BIGINT auto_increment  ,
    id_client BIGINT,
    id_product BIGINT,
    qtdProduct INTEGER,
     
    PRIMARY KEY(ID)
);
