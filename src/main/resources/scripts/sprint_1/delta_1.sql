--liquibase formatted sql

--changeset Joao Victor:SIS-01
--comment Script de Inicialização do Sistema

CREATE TABLE public.credencial (
	id int8 NOT NULL,
	email varchar NOT NULL,
	senha varchar NOT NULL,
	CONSTRAINT credencial_pk PRIMARY KEY (id)
);

CREATE TABLE public.usuario (
	id int8 NOT NULL,
	email varchar NULL,
	nome varchar NULL,
	credencial int8 NOT NULL,
	CONSTRAINT usuario_pk PRIMARY KEY (id),
	CONSTRAINT usuario_fk FOREIGN KEY (credencial) REFERENCES public.credencial(id)
);


