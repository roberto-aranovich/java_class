/** create the stocks database */

CREATE TABLE stocks.quotes(
   id INT NOT NULL AUTO_INCREMENT,
   symbol VARCHAR(4) NOT NULL,
   time DATETIME NOT NULL,
   price DECIMAL NOT NULL,
   PRIMARY KEY ( id )
);

INSERT INTO quotes (symbol,time,price) VALUES ('GOOG','2004-08-19 00:00:01','85.00');
INSERT INTO quotes (symbol,time,price) VALUES ('GOOG','2015-02-03 00:00:01','527.35');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-01 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('AMZN','2015-02-03 00:00:01','363.21');

 CREATE TABLE stocks.person
     (
     ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
     first_name VARCHAR(256) NOT NULL,
     last_name VARCHAR(256) NOT NULL,
     birth_date DATETIME NOT NULL
     );

 INSERT INTO stocks.person (first_name,last_name,birth_date) VALUES ('Drew', 'Hope', '1999/10/10');
 INSERT INTO stocks.person (first_name,last_name,birth_date) VALUES ('Lang', 'Heckman', '1959/11/11');
 INSERT INTO stocks.person (first_name,last_name,birth_date) VALUES ('Lucy', 'Jones', '2010/1/1');
 INSERT INTO stocks.person (first_name,last_name,birth_date) VALUES ('Stew', 'Hammer', '1990/3/28');
 INSERT INTO stocks.person (first_name,last_name,birth_date) VALUES ('Dan', 'Lane', '1986/4/18');



 CREATE TABLE stocks.person_stocksymbol
     (
     ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
     person_id INT NOT NULL,
     FOREIGN KEY (person_id) REFERENCES person (ID),
     symbol VARCHAR(4) NOT NULL
     );

 INSERT INTO stocks.person_stocksymbol (ID, person_id, symbol) VALUES (1, 1, 'GOOG');
 INSERT INTO stocks.person_stocksymbol (ID, person_id, symbol) VALUES (2, 1, 'APPL');
 INSERT INTO stocks.person_stocksymbol (ID, person_id, symbol) VALUES (3, 2, 'AMZN');
 INSERT INTO stocks.person_stocksymbol (ID, person_id, symbol) VALUES (4, 3, 'GOOG');
 INSERT INTO stocks.person_stocksymbol (ID, person_id, symbol) VALUES (5, 3, 'APPL');
 INSERT INTO stocks.person_stocksymbol (ID, person_id, symbol) VALUES (6, 3, 'AMZN');
 INSERT INTO stocks.person_stocksymbol (ID, person_id, symbol) VALUES (7, 4, 'GOOG');
