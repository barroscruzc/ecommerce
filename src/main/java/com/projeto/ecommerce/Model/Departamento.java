package com.projeto.ecommerce.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity                          //indica que a classe eh armazenavel no banco
@Table(name="departamento")      //nomeia a table
public class Departamento {

	@Column(name="codigo")       //nomeia a coluna
	@Id                          //indica que este será a primary key da tabela
	@GeneratedValue(strategy=GenerationType.IDENTITY)    ///significa que é auto_increment
	private Integer codigo;
	
	@Column(name="nome", length=50, nullable = false)
	private String nome;
	
	@Column(name="descricao", nullable = false)
	private String descricao;
	
																	//cascade: todas as alterações feitas em departamento repercutem em produtos
	@OneToMany(mappedBy="departamento", cascade = CascadeType.ALL) //dentro de produto, esse é o item que se refere ao departamento
	@JsonIgnoreProperties("departamento") //onde temos a relação bidirecional, é necessário informar quando interromper o ciclo de referência/recuperação de dados, evitando loop infinito
	private List<Produto> listaProdutos;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
