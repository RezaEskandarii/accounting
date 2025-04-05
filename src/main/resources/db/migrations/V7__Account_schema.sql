CREATE TABLE accounts
(
    id               BIGSERIAL PRIMARY KEY,
    name             VARCHAR(256) NOT NULL UNIQUE,
    code             VARCHAR(8)   NOT NULL UNIQUE,
    level            INTEGER,
    is_root          BOOLEAN      NOT NULL,
    description      TEXT,
    account_group_id BIGINT,
    account_type     VARCHAR(255),
    created_at       TIMESTAMP,
    updated_at       TIMESTAMP,
    CONSTRAINT fk_account_group FOREIGN KEY (account_group_id) REFERENCES account_groups (id),
    CONSTRAINT chk_account_type CHECK (account_type IN ('ASSET', 'LIABILITY', 'INCOME', 'EXPENSE', 'EQUITY'))
);
