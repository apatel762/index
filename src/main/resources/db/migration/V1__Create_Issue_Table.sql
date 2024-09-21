CREATE TABLE IF NOT EXISTS issue
(
    id          SERIAL NOT NULL,
    summary     VARCHAR(255) NOT NULL,
    created_at  TIMESTAMP NOT NULL,
    author      VARCHAR(255) NOT NULL,
    description TEXT,
    PRIMARY KEY (id)
);
