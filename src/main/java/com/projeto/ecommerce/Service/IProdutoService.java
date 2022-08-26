package com.projeto.ecommerce.Service;

import java.util.ArrayList;

import com.projeto.ecommerce.Model.Produto;

public interface IProdutoService {

	public ArrayList<Produto> recuperarTodos();
	public Produto recuperarPeloCodigo(Integer codigo);
	public Produto novoProduto(Produto novo);
}
