package com.alanensina.employeemanager.service;

import java.util.List;

import com.alanensina.employeemanager.domain.Funcionario;

public interface FuncionarioService {
	void salvar(Funcionario funcionario);
	
	void editar(Funcionario funcionario);
	
	void excluir(Long id);
	
	Funcionario buscarPorId(Long id);
	
	List<Funcionario> buscarTodos();
}
