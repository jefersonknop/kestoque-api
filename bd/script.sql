CREATE TABLE UnidadeMedida(
    id serial primary key,
    descricao varchar (100),
	abreviatura varchar (30),
	ativo boolean,
	inquilino_id long
);