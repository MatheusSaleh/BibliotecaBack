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

INSERT INTO livro (nome, id_editora, id_genero, id_autor, quantidade_emprestada, data_do_ultimo_emprestimo, disponivel)
VALUES
    ('Quincas Borba', 1, 1, 1, 0, '2023-11-01', true),
    ('Dom Casmurro', 2, 2, 2, 0, '2023-11-01', true),
    ('Capitaes da Areia', 3, 3, 3, 0, '2023-11-01', true),
    ('Primo Basilio', 1, 2, 4, 0, '2023-11-01', true),
    ('Iracema', 2, 3, 5, 0, '2023-11-01', true);

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




