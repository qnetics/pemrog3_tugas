-- Create User Table --
CREATE TABLE user (
    id INT NOT NULL PRIMARY KEY,
    email VARCHAR(32) NOT NULL,
    password VARCHAR(64) NOT NULL,
    account_number VARCHAR(19) NOT NULL
);



-- Create Aut Token Table --
CREATE TABLE auth_token (
    id VARCHAR(16) NOT NULL PRIMARY KEY,
    user_id VARCHAR(16) NOT NULL,
    access_token VARCHAR(32) NOT NULL,
    CONSTRAINT AUTH_TOKEN_FOREIGN_KEY
    FOREIGN KEY (user_id)
    REFERENCES user(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);



-- Create User Balance Table --
CREATE TABLE user_balance (
    id VARCHAR(16) NOT NULL PRIMARY KEY,
    user_id VARCHAR(16) NOT NULL,
    balance INT NOT NULL CHECK(balance >= 100000),
    CONSTRAINT USER_BALANCE_FOREIGN_KEY
    FOREIGN KEY (user_id)
    REFERENCES user(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);



-- Create Mutation Table --
CREATE TABLE mutation (
    id VARCHAR(16) NOT NULL PRIMARY KEY,
    user_id VARCHAR(16) NOT NULL,
    before_balance INT NOT NULL,
    after_balance INT NOT NULL,
    type_transaction VARCHAR NOT NULL,
    CONSTRAINT MUTATION_FOREIGN_KEY
    FOREIGN KEY (user_id)
    REFERENCES user(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
); 
