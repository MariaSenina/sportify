CREATE TABLE sportify.users (
                                id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                                first_name VARCHAR(100) NOT NULL,
                                last_name VARCHAR(100) NOT NULL,
                                email VARCHAR(100) NOT NULL,
                                username VARCHAR(25) NOT NULL,
                                passwd VARCHAR(15) NOT NULL
);

INSERT INTO sportify.users (first_name, last_name, email, username, passwd)
VALUES ('Sheldon', 'Cooper', 'scooper@email.com', 'scooper', '123qwe'),
       ('Leonard', 'Hofstadter', 'lhofst@email.com', 'lhof', '234wer'),
       ('Rajesh', 'Koothrappali', 'rkooth@email.com', 'rkooth', '345ert'),
       ('Howard', 'Wolowitz', 'hwolowitz@email.com', 'hwolo', '456rty');