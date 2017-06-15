use locacao_veiculos_db;

select * from categoria;
insert into categoria (preco, descricao) 
	values(300, 'Popular');

select * from cliente;
insert into cliente (cpf, nome, endereco, telefone) 
	values('111.222.333-44', 'Pedro Pereira', 'Águas Claras 554, Centro', '(34)99943-9878');
    
select * from funcionario;
insert into funcionario (matricula, nome, endereco, telefone)
	values('001', 'Diego José', 'Águas Correntes 23 Centro', '(34)99662-3232');
    
select * from avaria;
insert into avaria (descricao, valor)
	values('Vidro quebrado', 1000);

select * from multa;
insert into multa (descricao, valor)
	values('Sinal fechado', 900);
    
select * from veiculo;
insert into veiculo (marca, modelo, ano, valor, categoria_id)
	values('GM', 'Opala', 1978, 5000, 1);
    
select * from locacao;
insert into locacao (data, hora, veiculo_id, cliente_id, funcionario_id_cad, funcionario_id_rec)
	values(now(), '13:00', 1, 1, 1, 1);

select * from locacao_avaria;
insert into locacao_avaria (locacao_id, avaria_id)
	values(1, 1);

select * from locacao_multa;
insert into locacao_multa (multa_id, locacao_id)
	values(1, 1);



use locacao_veiculos_db;

select * from categoria;
select * from veiculo;
select * from avaria;
select * from multa;
select * from funcionario;
select * from cliente;
select * from locacao;
select * from locacao_multa;
select * from locacao_avaria;

insert into locacao_multa (multa_id, locacao_id) values(2, 1);
insert into locacao_avaria(locacao_id, avaria_id) values(1, 2);

select * from locacao where funcionario_id_cad = 1;
select * from locacao where veiculo_id = 1;

insert into locacao (data, hora, veiculo_id, cliente_id, funcionario_id_cad, funcionario_id_rec) 
	values('2016-01-18', '07:50:00', 8, 1, 1, 1);

SELECT * FROM locacao WHERE MONTH(data) = '10';

select * from locacao order by data asc;
SELECT count(*) FROM locacao WHERE MONTH(data) = '10';
SELECT * FROM cliente WHERE id IN(SELECT sum(count(cliente_id)) FROM locacao WHERE MONTH(data) = '10');

select cliente_id from locacao where month(data) = '10' group by cliente_id order by count(*) desc limit 1;

SELECT * FROM cliente WHERE id = 
	(SELECT cliente_id FROM locacao WHERE MONTH(data) = '01' 
    GROUP BY cliente_id 
    ORDER BY COUNT(*) 
    DESC LIMIT 1);
