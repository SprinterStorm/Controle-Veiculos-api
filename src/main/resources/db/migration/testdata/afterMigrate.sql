set foreign_key_checks = 0;

delete from usuario;
delete from veiculo;

set foreign_key_checks = 1;

alter table usuario auto_increment = 1;
alter table veiculo auto_increment = 1;

insert into usuario (id, nome, email, cpf, data_nascimento) values (1, 'Thiago','thiago@veiculos.com','37611388819', '1989-12-21 21:10:00');
insert into usuario (id, nome, email, cpf, data_nascimento) values (2, 'Michel','michel@veiculos.com','12345678912', '2002-08-30 20:10:00');
insert into usuario (id, nome, email, cpf, data_nascimento) values (3, 'Vitoria','vitoria@veiculos.com','12345678913', '2001-05-18 14:10:00');

insert into veiculo (id, usuario_id, marca, modelo, ano, rodizio_ativo) values (1, 1, 'Fiat', 'Palio EDX', '1997', true);
insert into veiculo (id, usuario_id, marca, modelo, ano, rodizio_ativo) values (2, 2, 'Volks Wagen', 'Gol GTI', '2005', false);
insert into veiculo (id, usuario_id, marca, modelo, ano, rodizio_ativo) values (3, 3, 'Pegeout', 'Sandero', '2010', true);
insert into veiculo (id, usuario_id, marca, modelo, ano, rodizio_ativo) values (4, 1, 'Fiat', 'Bravo', '1999', false);
insert into veiculo (id, usuario_id, marca, modelo, ano, rodizio_ativo) values (5, 2, 'Honda', 'Civic', '2012', true);
insert into veiculo (id, usuario_id, marca, modelo, ano, rodizio_ativo) values (6, 3, 'Hyundai', 'Santa fé', '2008', false);
