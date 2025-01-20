CREATE TABLE ADMIN (
                       ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                       USERNAME VARCHAR(255) NOT NULL,
                       PASSWORD VARCHAR(255) NOT NULL,
                       CREATED_AT TIMESTAMP NOT NULL,
                       UPDATED TIMESTAMP,
                       PRIMARY KEY (ID)
);



