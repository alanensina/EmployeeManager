package com.alanensina.employeemanager.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "FUNCIONARIOS")
public class Funcionario extends AbstractEntity<Long> {

	@Column(name = "NOME", nullable = false, unique = true)
	private String nome;
	
	@Column(name = "SALARIO", nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal salario;
	
	@Column(name = "DATA_ENTRADA", nullable = false, columnDefinition = "DATE")
	private LocalDate dtEntrada;
	
	@Column(name = "DATA_SAIDA", columnDefinition = "DATE")
	private LocalDate dtSaida;
	
	@OneToOne(cascade = CascadeType.ALL) // Ao cadastrar/excluir um funcionário, será cadastrado/excluído seu endereço também
	@JoinColumn(name = "ID_ENDERECO_FK")
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name = "ID_CARGO_FK")
	private Cargo cargo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public LocalDate getDtEntrada() {
		return dtEntrada;
	}

	public void setDtEntrada(LocalDate dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public LocalDate getDtSaida() {
		return dtSaida;
	}

	public void setDtSaida(LocalDate dtSaida) {
		this.dtSaida = dtSaida;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
}