-- src/main/resources/schema.sql

CREATE TABLE IF NOT EXISTS item_type (
                                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                         type_name VARCHAR(255) NOT NULL UNIQUE
    );
