CREATE TABLE IF NOT EXISTS pais (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

INSERT INTO pais (nome) VALUES ('Brasil');
INSERT INTO pais (nome) VALUES ('Estados Unidos');
INSERT INTO pais (nome) VALUES ('Japão');
INSERT INTO pais (nome) VALUES ('Alemanha');
INSERT INTO pais (nome) VALUES ('Canadá');

CREATE TABLE IF NOT EXISTS triagem (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    idade INT NOT NULL,
    data_nascimento DATE NOT NULL,
    sente_dor VARCHAR(50) NOT NULL,
    pais_origem VARCHAR(100) NOT NULL,
    sintomas TEXT NOT NULL,
    data_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);