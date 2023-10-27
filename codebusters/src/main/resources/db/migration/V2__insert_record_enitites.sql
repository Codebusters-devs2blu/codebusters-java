
-- Inserir o primeiro registro
INSERT INTO users (name, nickname, password)
VALUES ('Carlos Eduardo Pereira', 'carlosEduPereira', 'carlos123');

-- Inserir o segundo registro
INSERT INTO users (name, nickname, password)
VALUES ('Adriano Costa', 'adrianoCT', 'adriano123');

-- Inserir o terceiro registro
INSERT INTO users (name, nickname, password)
VALUES ('Ana Carolina Santos', 'anaClSt', 'anaCS123');

-- Inserir o quarto registro
INSERT INTO users (name, nickname, password)
VALUES ('Enzo Gabriel Dos Santos', 'enzoGabS', 'enzoGS123');

-- Inserir o quinto registro
INSERT INTO users (name, nickname, password)
VALUES ('João Henrique Pereira', 'jaoHP', 'jaoHP123');

-- Inserir o sexto registro
INSERT INTO users (name, nickname, password)
VALUES ('Hery Bernado Costa', 'heryBDC', 'heryBC123');




-- Inserir para as carterias dos pais 
INSERT INTO wallet (money) VALUES (1000.00);

INSERT INTO wallet (money) VALUES (1500.75);

INSERT INTO wallet (money) VALUES (750.00);
-- Insert para as carteiras das criancas 
INSERT INTO wallet (money) VALUES (500.50);


INSERT INTO wallet (money) VALUES (200.25);

INSERT INTO wallet (money) VALUES (300.50);


-- Inserir dos AdultUser
INSERT INTO adult_user (user_id, wallet_id, cpf, email, job)
VALUES (1, 1, '12345678901', 'Carlos@email.com', 'Engenheiro');

INSERT INTO adult_user (user_id, wallet_id, cpf, email, job)
VALUES (2, 2, '98765432109', 'Adriano@email.com', 'Médico');

INSERT INTO adult_user (user_id, wallet_id, cpf, email, job)
VALUES (3, 3, '54654464682', 'Ana@email.com', 'Advogado');

 -- insert dos childUser
INSERT INTO child_user (family, birthday, guardian_id, user_id, wallet_id)
VALUES (1, '2023-01-10', 1, 4, 4);

INSERT INTO child_user (family, birthday, guardian_id, user_id, wallet_id)
VALUES (2, '2023-02-15', 2, 5, 5);

INSERT INTO child_user (family, birthday, guardian_id, user_id, wallet_id)
VALUES (0, '2023-03-20', 3, 6, 6);


-- insert Objective 
INSERT INTO objective (current_amount, objective_value, child_user_id, description)
VALUES (100.00, 500.00, 1, 'Comprar brinquedos');


INSERT INTO objective (current_amount, objective_value, child_user_id, description)
VALUES (50.00, 200.00, 2, 'Fazer uma viagem');


INSERT INTO objective (current_amount, objective_value, child_user_id, description)
VALUES (25.00, 100.00, 3, 'Economizar para o futuro');


INSERT INTO objective (current_amount, objective_value, child_user_id, description)
VALUES (150.00, 1000.00, 1, 'Comprar material escolar');


INSERT INTO objective (current_amount, objective_value, child_user_id, description)
VALUES (75.00, 300.00, 2, 'Comprar roupas novas');

INSERT INTO objective (current_amount, objective_value, child_user_id, description)
VALUES (10.00, 50.00, 3, 'Comprar um brinquedo especial');

-- insert releases 
INSERT INTO release (release_value, type, date, wallet_id, description)
VALUES (100.00, 0, '2023-10-26', 4, 'Depósito da tarefa');


INSERT INTO release (release_value, type, date, wallet_id, description)
VALUES (25.00, 0, '2023-10-28', 5, 'Depósito do Kahoot');


INSERT INTO release (release_value, type, date, wallet_id, description)
VALUES (150.00, 0, '2023-10-29', 6, 'Depósito adicional');

-- insert childTask

INSERT INTO child_task (status, task_value, adult_user_id, child_user_id, description)
VALUES (1, 5.00, 1, 1, 'Limpar o quarto');
INSERT INTO child_task (status, task_value, adult_user_id, child_user_id, description)
VALUES (1, 4.00, 2, 2, 'Lavar a louça');
INSERT INTO child_task (status, task_value, adult_user_id, child_user_id, description)
VALUES (1, 3.00, 3, 3, 'Passar Aspirador');