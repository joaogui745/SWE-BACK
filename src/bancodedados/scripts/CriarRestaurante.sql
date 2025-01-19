CREATE TABLE IF NOT EXISTS restaurante(
    idRestaurante INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    descricao TEXT,
    temEntrega INTEGER,
    localizacao TEXT NOT NULL,
    idUser INTEGER NOT NULL,
    FOREIGN KEY (idUser) REFERENCES usuario(idUser)
        ON DELETE CASCADE
);