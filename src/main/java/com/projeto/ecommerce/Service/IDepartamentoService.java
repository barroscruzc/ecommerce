package com.projeto.ecommerce.Service;

import java.util.ArrayList;

import com.projeto.ecommerce.Model.Departamento;

public interface IDepartamentoService {

	public Departamento criarNovo(Departamento novo);
	public Departamento atualizarDados(Departamento dados);
	public ArrayList<Departamento> buscarTodos();
	public Departamento buscarPeloId(Integer id);
	public void excluirDepartamento(Integer id);

}
