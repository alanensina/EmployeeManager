package com.alanensina.employeemanager.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alanensina.employeemanager.dao.FuncionarioDao;
import com.alanensina.employeemanager.domain.Funcionario;

@Service @Transactional(readOnly = false)
public class FuncionarioServiceImpl implements FuncionarioService{

	@Autowired
	private FuncionarioDao dao;
	
	@Override
	public void salvar(Funcionario funcionario) {
		dao.save(funcionario);
	}

	@Override
	public void editar(Funcionario funcionario) {
		dao.update(funcionario);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override @Transactional(readOnly = true)
	public Funcionario buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Funcionario> buscarTodos() {
		return dao.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Funcionario> buscarPorNome(String nome) {
		return dao.findByNome(nome);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Funcionario> buscarPorCargo(Long id) {
		return dao.findByCargo(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Funcionario> buscarPorDatas(LocalDate entrada, LocalDate saida) {
		if(entrada != null && saida != null) {
			return dao.findByDataEntradaDataSaida(entrada,saida);
		}
		else if(entrada != null) {
			return dao.findByDataEntrada(entrada);
		}
		else if(saida != null) {
			return dao.findByDataSaida(saida);
		}
		return new ArrayList<>();
	}

	
}
