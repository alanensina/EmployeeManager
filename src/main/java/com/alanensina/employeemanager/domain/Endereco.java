package com.alanensina.employeemanager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table
public class Endereco extends AbstractEntity<Long> {

	@Column(nullable = false)
	private String logradouro;
	
	@Column(nullable = false)
	private String bairro;
	
	@Column(nullable = false)
	private String cidade;
	
	@Column(nullable = false, length = 2)
	@Enumerated(EnumType.STRING)
	@NotNull(message = "{NotNull.endereco.uf}") // Mensagens estão no arquivo ValidationMessages.properties
	private UF uf;
	
	@Column(nullable = false, length = 9)
	@Size(min = 9, max = 9, message = "{Size.endereco.cep}") // Mensagens estão no arquivo ValidationMessages.properties
	private String cep;
	
	@NotNull(message = "{NotNull.endereco.numero}") // Mensagens estão no arquivo ValidationMessages.properties
	@Column(nullable = false, length = 5)
	private Integer numero;
	
	@Size(max = 255)
	private String complemento; // Por ser um campo opcional, não há a necessidade de fazer o mapeamento com a anotação @Column

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}