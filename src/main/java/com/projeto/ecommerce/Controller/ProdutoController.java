package com.projeto.ecommerce.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.ecommerce.Model.Produto;
import com.projeto.ecommerce.Service.IProdutoService;

@RestController
public class ProdutoController {

	@Autowired
	private IProdutoService service;
	
	// recuperar todos os registros
	@GetMapping("/produtos")
	public ArrayList<Produto> recuperarTodos(){
		return service.recuperarTodos();
	}
	
	//recuperar pelo ID
	@GetMapping("/produtos/{codigo}")
	public ResponseEntity<Produto> recuperarPeloCodigo(@PathVariable Integer codigo){
		Produto res = service.recuperarPeloCodigo(codigo);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.status(404).build();
	}

	//cadastrar novo
	@PostMapping("/produtos")
	public ResponseEntity<Produto> inserirNovoProduto(@RequestBody Produto novo){
		Produto res = service.novoProduto(novo);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
}
