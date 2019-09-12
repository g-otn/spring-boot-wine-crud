CREATE TABLE vinho (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    safra INT NOT NULL,
    volume INT NOT NULL,
    valor DECIMAL(10, 2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;