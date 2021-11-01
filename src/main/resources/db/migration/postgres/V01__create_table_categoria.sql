create table categoria(
    id serial not null primary key,
    nome varchar(100) not null unique
);

INSERT INTO categoria (nome) values ('Tecnologia');
INSERT INTO categoria (nome) values ('Acessórios para veículos');
INSERT INTO categoria (nome) values ('Esporte e Lazer');
INSERT INTO categoria (nome) values ('Casa e Eletrodomésticos');
INSERT INTO categoria (nome) values ('Joias e Relógios');