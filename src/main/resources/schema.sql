CREATE TABLE users (
                                id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                                first_name VARCHAR(100) NOT NULL,
                                last_name VARCHAR(100) NOT NULL,
                                email VARCHAR(100) NOT NULL,
                                username VARCHAR(25) NOT NULL,
                                passwd VARCHAR(15) NOT NULL
);