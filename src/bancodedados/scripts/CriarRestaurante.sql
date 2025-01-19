CREATE TABLE IF NOT EXISTS restaurante(
    idRestaurante INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    descricao TEXT,
    temEntrega INTEGER,
    localizacao TEXT NOT NULL,
    idUsuario INTEGER NOT NULL,
    FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario)
        ON DELETE CASCADE
);