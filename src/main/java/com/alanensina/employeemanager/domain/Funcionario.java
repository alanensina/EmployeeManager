package com.alanensina.employeemanager.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table
public class Funcionario extends AbstractEntity<Long> {

	@Column(nullable = false, unique = true)
	private String nome;
	
	@Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal salario;
	
	@Column(nullable = false, columnDefinition = "DATE")
	private LocalDate dataEntrada;
	
	@Column(columnDefinition = "DATE")
	private LocalDate dataSaida;
	
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
		return dataEntrada;
	}

	public void setDtEntrada(LocalDate dtEntrada) {
		this.dataEntrada = dtEntrada;
	}

	public LocalDate getDtSaida() {
		return dataSaida;
	}

	public void setDtSaida(LocalDate dtSaida) {
		this.dataSaida = dtSaida;
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