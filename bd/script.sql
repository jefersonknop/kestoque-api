CREATE TABLE UnidadeMedida(
    id serial primary key,
    descricao varchar (100),
	abreviatura varchar (30),
	ativo boolean,
	inquilino_id integer
);

CREATE TABLE Fabricante(
    id serial primary key,
	tipo varchar (30),
    nome varchar (255),
	nome_fantasia varchar (255),
	cpf_cnpj varchar (30),
	rg_inscricao varchar (30),
	logradouro varchar (255),
	numero varchar (20),
	complemento varchar (255),
	cep varchar (20),
	bairro varchar (100),
	cidade varchar (100),
	uf varchar (2),
	pais varchar (100),
	latitude varchar (100),
	longitude varchar (100),
	telefone varchar (50),
	celular varchar (50),
	email varchar (100),
	site varchar (100),
	informacoes varchar (1024),
	inquilino_id integer
);
