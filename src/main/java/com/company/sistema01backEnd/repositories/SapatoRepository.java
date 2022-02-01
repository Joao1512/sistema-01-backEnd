package com.company.sistema01backEnd.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.company.sistema01backEnd.DTO.SapatoDTO;
import com.company.sistema01backEnd.model.administracao.Sapato;

@Repository
public interface SapatoRepository extends JpaRepository<Sapato, Long>{

	@Query("Select new com.company.sistema01backEnd.DTO.SapatoDTO(s.id, s.tamanho, s.categoria, s.cor, s.preco, s.marca, s.dataCadastro, s.quantidadeEstoque, s.descricao) from Sapato s"
			+ " where ("
			+ " (s.id = :id OR :id IS NULL)"
			+ " AND (s.tamanho = :tamanho OR :tamanho IS NULL)"
			+ " AND (s.categoria = :categoria OR :categoria IS NULL)"
			+ " AND (s.cor = :cor OR :cor IS NULL)"
			+ " AND (s.preco = :preco OR :preco IS NULL)"
			+ " AND (s.marca = :marca OR :marca IS NULL)"
//			+ " AND ( CAST(:dataCadastro AS date) IS NULL OR s.dataCadastro = CAST(:dataCadastro AS date))"
			+ " AND (s.quantidadeEstoque = :quantidadeEstoque OR :quantidadeEstoque IS NULL)"
			+ " AND (s.descricao LIKE CONCAT('%', :descricao, '%') OR :descricao IS NULL)"
			+ " )")
	public List<SapatoDTO> buscarTodosParaTabela(Long id, Long tamanho, String categoria, String cor, Long preco, String marca, Long quantidadeEstoque, String descricao);
}
