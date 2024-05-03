CREATE TABLE task (
    task_id SERIAL PRIMARY KEY,
    user_id SERIAL NOT NULL,
    task_title VARCHAR(255) NOT NULL,
    completed BOOLEAN NOT NULL,
    timestamp TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE
);