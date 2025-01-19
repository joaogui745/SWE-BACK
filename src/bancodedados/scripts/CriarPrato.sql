CREATE TABLE IF NOT EXISTS prato(
    idPrato INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    descricao TEXT,
    preco REAL NOT NULL,
    imagem TEXT,
    idRestaurante INTEGER NOT NULL,
    FOREIGN KEY (idRestaurante) REFERENCES restaurante(idRestaurante)
        ON DELETE CASCADE
);