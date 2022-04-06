CREATE TABLE UserAccount  (
    user_id INTEGER AUTO_INCREMENT NOT NULL,
    email VARCHAR(75) NOT NULL,
    password VARCHAR(75) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE Calculation (
    calculation_id INTEGER AUTO_INCREMENT NOT NULL,
    user_id INTEGER NOT NULL ,
    firstNumber DOUBLE NOT NULL ,
    operator VARCHAR(1) NOT NULL ,
    secondNumber DOUBLE NOT NULL,
    answer DOUBLE NOT NULL,
    PRIMARY KEY (calculation_id)
);

ALTER TABLE Calculation
    ADD CONSTRAINT FK_UserAcc_Calculation
    FOREIGN KEY (user_id)
    REFERENCES UserAccount(user_id);


