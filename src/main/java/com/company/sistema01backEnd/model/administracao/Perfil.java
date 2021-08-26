package com.company.sistema01backEnd.model.administracao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="perfil")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Perfil implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	
	private String nome;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="perfil", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Permissao> permissoes;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}
	
	
	

}
