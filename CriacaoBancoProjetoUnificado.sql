CREATE DATABASE IF NOT EXISTS ProjetoUnificado

USE ProjetoUnificado

CREATE TABLE Usuarios (
   ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   NomeCompleto VARCHAR(60) NOT NULL,
   NomeUsuario VARCHAR(30) NOT NULL,
   Email VARCHAR(100) NOT NULL,
   Senha VARCHAR(20) NOT NULL,
   Telefone VARCHAR(25) NOT NULL
);

INSERT INTO Usuarios (NomeCompleto, NomeUsuario, Email, Senha, Telefone) VALUES ("Allan Lima dos Santos", "Allan", "ulquiorraallan@gmail.com", "123", "11941668120");
SELECT * FROM Usuarios;

CREATE TABLE Projetos (
   ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   Nome VARCHAR(30) NOT NULL,
   Descricao VARCHAR(150) NOT NULL,
   UsuarioProprietario int NOT NULL,
   CONSTRAINT fk_Projetos_Usuarios FOREIGN KEY(UsuarioProprietario) REFERENCES Usuarios(ID) 
);

INSERT INTO Projetos (Nome, Descricao, UsuarioProprietario) VALUES ("Teste", "Descrição de teste", 1);
SELECT * FROM Projetos;

CREATE TABLE Requisitos (
   ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   Identificador ENUM("RF", "RNF") NOT NULL, 
   Nome VARCHAR(30) NOT NULL,
   Modulo VARCHAR(30) NOT NULL,
   Funcionalidades VARCHAR(1500) NOT NULL,
   DataCriacao DATE NOT NULL,
   DataUltimaAlteracao DATE NOT NULL,
   Prioridade ENUM("Baixa", "Média", "Alta") NOT NULL,
   Versao VARCHAR(20) NOT NULL,
   Complexidade ENUM("Baixa", "Média", "Alta") NOT NULL,
   EsforcoHoras DATETIME NOT NULL,
   Estado ENUM("Pendente", "Em Andamento", "Finalizado") NOT NULL,
   Fase ENUM("Iniciação", "Planejamento", "Execução", "Monitoramento", "Controle", "Encerramento") NOT NULL,
   Descricao VARCHAR(1500) NOT NULL,
   Projeto int NOT NULL,
   Autor int NOT NULL,
   AutorUltimaAlteracao int NOT NULL,
   CONSTRAINT fk_Requisitos_Projetos FOREIGN KEY(Projeto) REFERENCES Projetos(ID),
   CONSTRAINT fk_Requisitos_Autor FOREIGN KEY(Autor) REFERENCES Usuarios(ID),
   CONSTRAINT fk_Requisitos_AutorUltimaAlteracao FOREIGN KEY(AutorUltimaAlteracao) REFERENCES Usuarios(ID)
);

ALTER TABLE Requisitos MODIFY COLUMN DataUltimaAlteracao DATE NULL;
ALTER TABLE Requisitos MODIFY COLUMN AutorUltimaAlteracao INT NULL;
ALTER TABLE Requisitos MODIFY COLUMN EsforcoHoras INT NULL;

INSERT INTO Requisitos (Identificador, Nome, Modulo, Funcionalidades, DataCriacao, Prioridade, Versao, Complexidade, EsforcoHoras, Estado, Fase, Descricao, Projeto, Autor) 
VALUES (2, "Teste 2", "Teste 2", "Testar tabela requisitos 2", NOW(), 1, "1", 1, 10, 1, 1, "Teste de requisito", 1, 13);

INSERT INTO Requisitos (Identificador, Nome, Modulo, Funcionalidades, DataCriacao, Prioridade, Versao, Complexidade, EsforcoHoras, Estado, Fase, Descricao, Projeto, Autor) 
VALUES (1, "Teste", "Teste", "Testar tabela requisitos", NOW(), 1, "1", 1, 10, 1, 1, "Teste de requisito", 1, 1);

INSERT INTO Requisitos (Identificador, Nome, Modulo, Funcionalidades, DataCriacao, Prioridade, Versao, Complexidade, EsforcoHoras, Estado, Fase, Descricao, Projeto, Autor)
VALUES (1, "Teste", "Teste", "Testar tabela requisitos", NOW(), 1, "1", 1, 10, 1, 1, "Teste de requisito", 1, 1);

SELECT * FROM Requisitos;