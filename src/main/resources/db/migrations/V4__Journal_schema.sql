CREATE TABLE journals
(
    id      SERIAL PRIMARY KEY,
    date    DATE NOT NULL,
    memo    TEXT,
    seq     INT  NOT NULL,
    book_id INT,
    CONSTRAINT fk_book FOREIGN KEY (book_id) REFERENCES books (id)
);
