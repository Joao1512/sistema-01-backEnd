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

--changeset Joao Victor:SIS-02
-- Tabelas de funcionalidade e perfil
CREATE TABLE public.funcionalidade (
	id int8 NOT NULL,
	nome varchar NOT NULL,
	regra varchar NOT NULL,
	CONSTRAINT funcionalidade_pk PRIMARY KEY (id)
);
CREATE TABLE public.perfil (
	id int8 NOT NULL,
	nome varchar NOT NULL,
	CONSTRAINT perfil_pk PRIMARY KEY (id)
);
CREATE TABLE public.permissao (
	id int8 NOT NULL,
	funcionalidade int8 NOT NULL,
	perfil int8 NOT NULL,
	habilitada boolean NOT NULL,
	CONSTRAINT permissao_pk PRIMARY KEY (id),
	CONSTRAINT permissao_fk FOREIGN KEY (perfil) REFERENCES public.perfil(id),
	CONSTRAINT permissao_fk_1 FOREIGN KEY (funcionalidade) REFERENCES public.funcionalidade(id)
);

--changeset Joao Victor:SIS-02.1
CREATE TABLE public.credencial_perfil (
	credencial int8 NOT NULL,
	perfil int8 NOT NULL,
	CONSTRAINT credencial_perfil_fk FOREIGN KEY (credencial) REFERENCES public.credencial(id),
	CONSTRAINT credencial_perfil_fk_1 FOREIGN KEY (perfil) REFERENCES public.perfil(id)
);



