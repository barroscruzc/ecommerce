package com.projeto.ecommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.ecommerce.DAO.PedidoDAO;
import com.projeto.ecommerce.Model.ItemPedido;
import com.projeto.ecommerce.Model.Pedido;

@Service
public class PedidoServiceImpl implements IPedidoService {
	
	@Autowired
	private PedidoDAO dao;

	@Override
	public Pedido inserirNovo(Pedido novo) {
		// antes de salvar, é necessário indicar aos itens "filhos" a qual pedido eles pertencem
		//quando temos uma lista de registros "dependentes", não basta apenas vincular os itens com pedido, porque no devido ao Cascade, 
		//quando atualiza a primeira tabela os "filhos" são atualizados automaticamente, mas o contrário não ocorre
		for(ItemPedido item: novo.getItens()) {
			item.setPedido(novo);
		}
		return dao.save(novo);
	}

	@Override
	public Pedido recuperarPeloNumero(Integer numero) {
		return dao.findById(numero).orElse(null);
	}
	
	@Override //anotação override: significa sobrescrita de métodos de uma interface/superclasse
	public List<Pedido> listar() {
		return (List<Pedido>)dao.findAll();
	}

}
