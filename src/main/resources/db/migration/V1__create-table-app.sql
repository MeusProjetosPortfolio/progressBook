-- Migration inicial para criação do esquema do banco de dados

-- Tabela de Usuários
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    photo VARCHAR(255),
    reader_level VARCHAR(50)
);

-- Tabela de Livros
CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    genre VARCHAR(100),
    total_pages INTEGER NOT NULL
);

-- Tabela de Progresso
CREATE TABLE progress (
    id SERIAL PRIMARY KEY,
    status VARCHAR(50) NOT NULL,
    start_date DATE,
    end_date DATE,
    progress_note VARCHAR(500)
);

-- Tabela de Leituras
CREATE TABLE readings (
    id SERIAL PRIMARY KEY,
    rating INTEGER,
    current_page INTEGER,
    user_id INTEGER REFERENCES users(id) ON DELETE CASCADE,
    book_id INTEGER REFERENCES books(id) ON DELETE CASCADE,
    progress_id INTEGER REFERENCES progress(id) ON DELETE CASCADE
);

-- Tabela de Conquistas
CREATE TABLE archievements (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(500),
    points INTEGER,
    img_archievement VARCHAR(255)
);
