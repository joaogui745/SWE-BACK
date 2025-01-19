CREATE TABLE IF NOT EXISTS avaliacao(
    idAvaliacao INTEGER PRIMARY KEY AUTOINCREMENT,
    nota REAL CHECK (nota BETWEEN 0 AND 10),
    dataAvaliacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    conteudo TEXT,
    idRestaurante INTEGER NOT NULL,
    idUsuario INTEGER NOT NULL,
    FOREIGN KEY (idRestaurante) REFERENCES restaurante(idRestaurante)
        ON DELETE CASCADE
    FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario)
        ON DELETE CASCADE
);

