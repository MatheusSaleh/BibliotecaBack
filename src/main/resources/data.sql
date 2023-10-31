INSERT INTO AUTOR (nome) VALUES ('Machado De Assis');
INSERT INTO AUTOR (nome) VALUES ('Jorge Amado');
INSERT INTO AUTOR (nome) VALUES ('Guimarães Rosa');
INSERT INTO AUTOR (nome) VALUES ('Clarice Lispector');
INSERT INTO AUTOR (nome) VALUES ('Carlos Drummond de Andrade');

INSERT INTO EDITORA (nome) VALUES ('Record');
INSERT INTO EDITORA (nome) VALUES ('Globo');
INSERT INTO EDITORA (nome) VALUES ('Atica');
INSERT INTO EDITORA (nome) VALUES ('Wish');
INSERT INTO EDITORA (nome) VALUES ('Atlas');

INSERT INTO GENERO (nome) VALUES ('Ação');
INSERT INTO GENERO (nome) VALUES ('Romance');
INSERT INTO GENERO (nome) VALUES ('Aventura');
INSERT INTO GENERO (nome) VALUES ('Ficção Científica');
INSERT INTO GENERO (nome) VALUES ('Didático');


INSERT INTO PESSOA (nome, endereco) VALUES ('Douglas Sanches da Cunha', 'Rua Padre Gusmões');
INSERT INTO PESSOA (nome, endereco) VALUES ('Diomara Reigatto', 'Av. Rui Barbosa');
INSERT INTO PESSOA (nome, endereco) VALUES ('Alex Polleto', 'Av. Dom Antonio');
INSERT INTO PESSOA (nome, endereco) VALUES ('Almir Rogério Camolesi', 'Rua Floriano Peixoto');
INSERT INTO PESSOA (nome, endereco) VALUES ('Luiz Ricardo Begosso', 'Rua Candido Mota');


INSERT INTO LIVRO (data_do_ultimo_emprestimo, nome, quantidade_emprestada, id_autor, id_editora, id_genero, id_pessoa) VALUES ('2023-10-26', 'Capitães Da Areia', 2, 3, 2, 1, 2);

INSERT INTO venda (data_venda, valor)
VALUES ('2023-10-30', 100.00);

INSERT INTO venda (data_venda, valor)
VALUES ('2023-10-31', 150.50);

INSERT INTO venda (data_venda, valor)
VALUES ('2023-11-15', 75.25);

INSERT INTO venda (data_venda, valor)
VALUES ('2023-12-05', 120.50);

INSERT INTO venda (data_venda, valor)
VALUES ('2024-01-20', 85.75);

INSERT INTO venda (data_venda, valor)
VALUES ('2024-02-10', 200.00);