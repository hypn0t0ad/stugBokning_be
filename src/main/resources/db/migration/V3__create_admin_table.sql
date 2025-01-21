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

-- INSERT INTO ADMIN (NAME, USERNAME, PASSWORD, ROLE, CREATED_AT)
-- VALUES ('admin', 'admin', '$2a$12$3UJxuCYHzIu3/Kq846oCI.PWzK4hbkUSsHPlscRofuabvGPb.fnyG', 'ADMIN', CURRENT_DATE);