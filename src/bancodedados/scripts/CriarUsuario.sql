CREATE TABLE IF NOT EXISTS usuario(
    idUsuario  INTEGER PRIMARY KEY AUTOINCREMENT , 
    nome TEXT NOT NULL,
    senha TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    dataCadastro DATETIME DEFAULT CURRENT_TIMESTAMP,
    documento TEXT NOT NULL,
    tipoDocumento TEXT CHECK (tipoDocumento IN ('cpf', 'cnpj'))
);