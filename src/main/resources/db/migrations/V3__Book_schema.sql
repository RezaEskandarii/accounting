CREATE TABLE books
(
    id         BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    name       VARCHAR(255) NOT NULL UNIQUE,
    start_date DATE,
    end_date   DATE
);
