CREATE TABLE IF NOT EXISTS Issue (
    id SERIAL PRIMARY KEY,
    summary VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    author VARCHAR(255) NOT NULL,
    description TEXT
);
