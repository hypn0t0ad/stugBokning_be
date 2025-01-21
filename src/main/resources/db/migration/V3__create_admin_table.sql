CREATE TABLE ADMIN (
                       ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                       NAME VARCHAR(255) NOT NULL,
                       USERNAME VARCHAR(255) NOT NULL,
                       PASSWORD VARCHAR(255) NOT NULL,
                       ROLE VARCHAR(255) NOT NULL,
                       CREATED_AT TIMESTAMP NOT NULL,
                       UPDATED TIMESTAMP,
                       PRIMARY KEY (ID)
);