CREATE TABLE transactions
(
    id           BIGSERIAL PRIMARY KEY,
    credit_value NUMERIC,
    debit_value  NUMERIC,
    memo         TEXT,
    data         TEXT,
    account_id   BIGINT NOT NULL,
    book_id      BIGINT NOT NULL,
    journal_id   BIGINT,
    FOREIGN KEY (account_id) REFERENCES accounts (id),
    FOREIGN KEY (book_id) REFERENCES books (id),
    FOREIGN KEY (journal_id) REFERENCES journals (id)
);
