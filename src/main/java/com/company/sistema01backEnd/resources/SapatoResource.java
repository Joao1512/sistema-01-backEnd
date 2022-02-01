package com.company.sistema01backEnd.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.sistema01backEnd.DTO.SapatoDTO;
import com.company.sistema01backEnd.DTO.SapatoFiltroDTO;
import com.company.sistema01backEnd.model.administracao.Sapato;
import com.company.sistema01backEnd.services.SapatoService;

@RestController
@CrossOrigin()
@RequestMapping("/sapatos")
public class SapatoResource {
	
	@Autowired
	private SapatoService service;
	
	@Secured("ROLE_DELETAR_SAPATO")
	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		service.excluir(id);
		return ResponseEntity.ok().build();
	}

	@Secured("ROLE_CADASTRAR_SAPATO")
	@PostMapping("/cadastrar")
	public ResponseEntity<Sapato> cadastrar(@RequestBody SapatoDTO sapato) {
		Sapato novoSapatoCadastrado = service.salvar(sapato);
		return ResponseEntity.ok(novoSapatoCadastrado);
	}
	
	@Secured("ROLE_VISUALIZAR_SAPATO")
	@PostMapping("/editar")
	public ResponseEntity<Sapato> editar(@RequestBody SapatoDTO sapatoDTO) throws Exception {
		Sapato sapatoEditado = service.editar(sapatoDTO);
		return ResponseEntity.ok(sapatoEditado);
	}

	@Secured("ROLE_VISUALIZAR_SAPATO")
	@GetMapping("/listarFiltrado")
	public ResponseEntity<List<SapatoDTO>> buscarTodosParaTabela(@RequestBody SapatoFiltroDTO filtro) { 
		List<SapatoDTO> sapatos = service.buscarTodosParaTabela(filtro);
		return ResponseEntity.ok(sapatos);
	}
	
	@Secured("ROLE_VISUALIZAR_SAPATO")
	@GetMapping("/buscarPorId/{id}")
	public ResponseEntity<SapatoDTO> buscarPorId(@PathVariable("id") Long id) throws Exception {
		Sapato sapato = service.buscarPorId(id);
		SapatoDTO sapatoDTO = new SapatoDTO(sapato);
		return ResponseEntity.ok(sapatoDTO);
	}
}
