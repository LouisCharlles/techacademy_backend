CREATE TABLE usuarios(
    usuario_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome varchar(255) NOT NULL,
    email VARCHAR(191) NOT NULL UNIQUE,
    senha varchar(255) NOT NULL
);