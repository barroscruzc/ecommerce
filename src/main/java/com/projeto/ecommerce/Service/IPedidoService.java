package com.projeto.ecommerce.Service;

import java.util.List;

import com.projeto.ecommerce.Model.Pedido;

public interface IPedidoService {

	public Pedido inserirNovo(Pedido novo);
	public Pedido recuperarPeloNumero(Integer numero);
	public List<Pedido> listar();
}
