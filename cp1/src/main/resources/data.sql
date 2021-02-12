INSERT INTO tb_client (name, cpf, income, birth_Date, children, password) VALUES ('Gabriel', '12345678911', 6500.0, '1999-07-13T02:00:00Z', 1, '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_client (name, cpf, income, birth_Date, children, password) VALUES ('Carlin', '45685214573', 1350.1, '1990-03-13T00:00:00Z', 2, '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_client (name, cpf, income, birth_Date, children, password) VALUES ('João L.', '45698753210', 3250.0, '1988-01-13T18:00:00Z', 4, '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_client (name, cpf, income, birth_Date, children, password) VALUES ('Uncle Bob', '89635742103', 20000.0, '1996-04-13T06:00:00Z', 5, '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_client (name, cpf, income, birth_Date, children, password) VALUES ('R.R Martin', '78695369863', 40000.0, '1979-09-13T05:00:00Z', 0, '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_client (name, cpf, income, birth_Date, children, password) VALUES ('Silvio Santos', '12357412390', 100000.0, '1970-03-10T00:00:00Z', 2, '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_client (name, cpf, income, birth_Date, children, password) VALUES ('Rute', '75685210369', 4500.0, '2001-10-21T14:00:00Z', 4, '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_client (name, cpf, income, birth_Date, children, password) VALUES ('Ronaldinho', '15985236987', 60000.0, '1985-06-13T09:30:00Z', 10, '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_client (name, cpf, income, birth_Date, children, password) VALUES ('Vasconcelos', '03698521598', 13450.0, '2000-11-13T13:50:00Z', 8, '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_client (name, cpf, income, birth_Date, children, password) VALUES ('Putin', '75402358741', 75650.0, '1976-12-13T16:20:00Z', 3, '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLE_USER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (4, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (5, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (6, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (7, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (8, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (9, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (10, 2);