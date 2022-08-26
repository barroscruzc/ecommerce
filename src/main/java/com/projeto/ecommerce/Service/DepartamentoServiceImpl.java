package com.projeto.ecommerce.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.ecommerce.DAO.DepartamentoDAO;
import com.projeto.ecommerce.Model.Departamento;

@Service     //essa anotação permite que o controller faça a injeção de métodos
public class DepartamentoServiceImpl implements IDepartamentoService{

	@Autowired
	private DepartamentoDAO dao;
	
	@Override
	public Departamento criarNovo(Departamento novo) {
		// TODO Auto-generated method stub
		if (novo.getNome() != null) {
			return dao.save(novo);
		}
		return null;
	}

	@Override
	public Departamento atualizarDados(Departamento dados) {
		// TODO Auto-generated method stub
		if(dados.getCodigo() != null && dados.getNome() != null) {
			return dao.save(dados);     //o que diferencia esse save do anterior é a presença de chave primária
		}
		return null;
	}

	@Override
	public ArrayList<Departamento> buscarTodos() {
		// TODO Auto-generated method stub
		return (ArrayList<Departamento>)dao.findAll();    //Conversão forçada de um iterable para um arraylist
	}

	@Override
	public Departamento buscarPeloId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);   //caso não encontre nenhum registro para esse id, retorna null
	}

	@Override
	public void excluirDepartamento(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
