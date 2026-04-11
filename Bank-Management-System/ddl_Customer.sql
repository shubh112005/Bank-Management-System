CREATE TABLE customer
(
    id      BIGINT       NOT NULL,
    name    VARCHAR(255) NULL,
    email   VARCHAR(255) NULL,
    phone   VARCHAR(255) NULL,
    address VARCHAR(255) NULL,
    CONSTRAINT pk_customer PRIMARY KEY (id)
);