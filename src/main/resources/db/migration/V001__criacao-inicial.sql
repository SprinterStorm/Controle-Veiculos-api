CREATE TABLE usuario (
	id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(60) NOT NULL,
    email VARCHAR(60) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    data_nascimento DATETIME NOT NULL,
    PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE veiculo (
	id BIGINT NOT NULL AUTO_INCREMENT,
    usuario_id BIGINT NOT NULL,
    marca VARCHAR(60) NOT NULL,
    modelo VARCHAR(60) NOT NULL,
    ano VARCHAR(4) NOT NULL,
    PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE veiculo ADD CONSTRAINT fk_veiculo_usuario
FOREIGN KEY (usuario_id) REFERENCES usuario (id);

ALTER TABLE veiculo ADD rodizio_ativo TINYINT(1) NOT NULL;
UPDATE veiculo SET rodizio_ativo = FALSE;