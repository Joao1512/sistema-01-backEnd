package com.company.sistema01backEnd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.sistema01backEnd.DTO.SapatoDTO;
import com.company.sistema01backEnd.DTO.SapatoFiltroDTO;
import com.company.sistema01backEnd.model.administracao.Sapato;
import com.company.sistema01backEnd.repositories.SapatoRepository;

@Service
public class SapatoService {

	@Autowired
	private SapatoRepository repository;
	
	public Sapato buscarPorId(Long id) throws Exception {
		Optional<Sapato> sapato = repository.findById(id);
		return sapato.orElseThrow(() -> new Exception("sapato não encontrado!"));
	}
	
	public List<SapatoDTO> buscarTodosParaTabela(SapatoFiltroDTO filtro) {
		 return repository.buscarTodosParaTabela(filtro.getId(), filtro.getTamanho(), filtro.getCategoria(), filtro.getCor(), filtro.getPreco(), filtro.getMarca(), filtro.getQuantidadeEstoque(), filtro.getDescricao());

	}
	
	public Sapato salvar(SapatoDTO sapatoDTO) {
		Sapato sapato = sapatoDTO.toEntityInsert();
		return repository.save(sapato);
	}
	
	public void excluir(Long id) {
		repository.deleteById(id);
	}
	
	public Sapato editar(SapatoDTO sapatoDTO) throws Exception {
		Sapato sapato = buscarPorId(sapatoDTO.getId());
		sapato = sapatoDTO.toEntityUpdate(sapato);
		
		return repository.save(sapato);
	}
}
