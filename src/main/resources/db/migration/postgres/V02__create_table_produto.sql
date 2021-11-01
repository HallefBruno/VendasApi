create table produto(
    id serial not null primary key,
    descricao varchar(200) not null unique,
    quantidade int not null,
    preco_custo decimal(10,2) not null,
    preco_venda decimal(10,2) not null,
    observacao varchar(200),
    categoria_id int not null,
    CONSTRAINT produto_fk FOREIGN KEY(categoria_id) REFERENCES categoria(id)
);


INSERT INTO produto (descricao, quantidade, preco_custo, preco_venda, observacao, categoria_id) values ('TV Philco 32"', 10, 500, 870, 'Tv 32 Polegadas Philco Led Hd Conv. Digital Ptv32b51d', 1);
INSERT INTO produto (descricao, quantidade, preco_custo, preco_venda, observacao, categoria_id) values ('AOC Smart TV 43"', 10, 1250, 1623.20, 'Smart Tv Led 43 Polegadas Aoc Le43s5970s Full Hd Wi-fi 2 Usb', 1);
INSERT INTO produto (descricao, quantidade, preco_custo, preco_venda, observacao, categoria_id) values ('Sansung HD TV 32"', 10, 729, 1073.36, 'Tv Led 32 Samsung Un32n4000', 1);
INSERT INTO produto (descricao, quantidade, preco_custo, preco_venda, observacao, categoria_id) values ('Celular Moto G7 Plus', 25, 1200.50, 1899, 'Celular Motorola Moto G7 Plus Indigo 64gb 4gb Ram Xt1965', 1);
INSERT INTO produto (descricao, quantidade, preco_custo, preco_venda, observacao, categoria_id) values ('Smartphone Samsung Galaxy S9', 15, 2750, 3299, 'Smartphone Samsung Galaxy S9+ Tela 6.2 128gb 6gb De Ram', 1);
INSERT INTO produto (descricao, quantidade, preco_custo, preco_venda, observacao, categoria_id) values ('Piscina 10 mil listros', 10, 500, 700, 'Piscina 10 mil listros', 3);
INSERT INTO produto (descricao, quantidade, preco_custo, preco_venda, observacao, categoria_id) values ('Piscina 20 mil listros', 10, 600, 800, 'Piscina 20 mil listros', 3);
INSERT INTO produto (descricao, quantidade, preco_custo, preco_venda, observacao, categoria_id) values ('Piscina 30 mil listros', 10, 700, 900, 'Piscina 30 mil listros', 3);
INSERT INTO produto (descricao, quantidade, preco_custo, preco_venda, observacao, categoria_id) values ('Liquidificador 12 Veloc. 1000w', 30, 70.90, 139.90, 'Liquidificador 12 Veloc. 1000w Turbo Premium Mondial 110v', 4);
INSERT INTO produto (descricao, quantidade, preco_custo, preco_venda, observacao, categoria_id) values ('Fogão Elétrico De Mesa', 8, 60.80, 106.80, 'Fogão Elétrico De Mesa 2 Pratos 2000 Watts Agrato 220v', 4);
INSERT INTO produto (descricao, quantidade, preco_custo, preco_venda, observacao, categoria_id) values ('Fogão 4 Bocas', 20, 280.50, 424.86, 'Fogão 4 Bocas Atlas Mônaco Com Acendimento Automático', 4);
INSERT INTO produto (descricao, quantidade, preco_custo, preco_venda, observacao, categoria_id) values ('Fogão 5 Bocas', 30, 864, 1164.94, 'Fogão 5 Bocas Tripla Chama Automático Agile Glass Inox Atlas', 4);
INSERT INTO produto (descricao, quantidade, preco_custo, preco_venda, observacao, categoria_id) values ('Cafeteira Expresso', 22, 315.90, 415.90, 'Cafeteira Expresso 15 Bar Coffee Cream 110v Mondial', 4);
INSERT INTO produto (descricao, quantidade, preco_custo, preco_venda, observacao, categoria_id) values ('Geladeira / Refrigerador Electrolux', 50, 1000, 1370, 'Geladeira / Refrigerador Electrolux 240 Litros 1 Porta Class', 4);
INSERT INTO produto (descricao, quantidade, preco_custo, preco_venda, observacao, categoria_id) values ('Relógio Technos Masculino Dourado', 35, 180, 249, 'Relógio Technos Masculino Dourado Performer - 2115laa/4c', 5);
INSERT INTO produto (descricao, quantidade, preco_custo, preco_venda, observacao, categoria_id) values ('Relógio Nibosi Cronógrafo', 50, 100, 160.50, 'Relógio Nibosi Cronógrafo Fr Grátis Promoção Carnaval', 5);
INSERT INTO produto (descricao, quantidade, preco_custo, preco_venda, observacao, categoria_id) values ('Anel Maciço Ouro 18k', 60, 210, 299.90, 'Anel Solitario Maciço Ouro 18k 750 7mm Escolha A Cor', 5);
