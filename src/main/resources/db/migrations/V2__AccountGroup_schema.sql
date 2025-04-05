CREATE TABLE account_groups
(
    id         BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    code       VARCHAR(255) UNIQUE,
    name       VARCHAR(125),
    group_type VARCHAR(255)
);
