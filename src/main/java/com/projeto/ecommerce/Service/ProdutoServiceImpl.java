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
		return (ArrayList<Produto>)dao.findAll();
	}

	@Override
	public Produto recuperarPeloCodigo(Integer codigo) {
		return dao.findById(codigo).orElse(null);
	}

	@Override
	public Produto novoProduto(Produto novo) {
		return dao.save(novo);
	}

	@Override
	public Produto atualizarProduto(Integer codigo, Produto produto) {
		Produto res = dao.findById(codigo).orElse(null);

		res.setDepartamento(produto.getDepartamento());
		res.setDescricao(produto.getDescricao());
		res.setEstoque(produto.getEstoque());
		res.setLinkFoto(produto.getLinkFoto());
		res.setNome(produto.getNome());
		res.setPreco(produto.getPreco());

		return dao.save(res);
	}
	@Override
	public void excluir(Integer codigo) {
		dao.deleteById(codigo);
	}
}
