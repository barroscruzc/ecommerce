package com.projeto.ecommerce.DAO;

import org.springframework.data.repository.CrudRepository;

import com.projeto.ecommerce.Model.Produto;

public interface ProdutoDAO extends CrudRepository<Produto, Integer>{

}
