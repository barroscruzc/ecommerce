package com.projeto.ecommerce.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.ecommerce.DAO.ProdutoDAO;
import com.projeto.ecommerce.Model.Produto;

@Service
public class ProdutoServiceImpl implements IProdutoService{

	@Autowired
	private ProdutoDAO dao;
	
	@Override
	public ArrayList<Produto> recuperarTodos() {
		// TODO Auto-generated method stub
		return (ArrayList<Produto>)dao.findAll();
	}

	@Override
	public Produto recuperarPeloCodigo(Integer codigo) {
		// TODO Auto-generated method stub
		return dao.findById(codigo).orElse(null);
	}

	@Override
	public Produto novoProduto(Produto novo) {
		// TODO Auto-generated method stub
		return dao.save(novo);
	}

}
