package com.projeto.ecommerce.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.ecommerce.Model.Departamento;
import com.projeto.ecommerce.Service.IDepartamentoService;

@RestController
public class ControllerDepartamento {

	@Autowired   //injeção de dependências 
	private IDepartamentoService service;
	
	@GetMapping("/departamentos")
	private ArrayList<Departamento> buscarTodos(){
		 
		return service.buscarTodos();
	};
	
	@PostMapping("/departamentos")  //ResponseEntity dá uma resposta HTTP, que pode conter algum código ou mensagem
	public ResponseEntity<Departamento> incluirNovo(@RequestBody Departamento novo) {
		Departamento res = service.criarNovo(novo);   //insert into departamento (descricao, nome) values (?, ?)
		if(res != null) { 
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();  //caso falte alguma informação necessária para	
	}                                                //criar novo departamento, o ResponseEntity enviará 
													// a mensagem de BadRequest.
	@PutMapping("/departamentos")
		public ResponseEntity<Departamento> alterar(@RequestBody Departamento dados){
		Departamento res = service.atualizarDados(dados);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/departamentos/{id}")
	public ResponseEntity<Departamento> excluirDepartamento(@PathVariable Integer id) {
		service.excluirDepartamento(id);
		return ResponseEntity.ok(null);
	}
	
	@GetMapping("/departamentos/{codigo}")
	public ResponseEntity<Departamento> buscarPeloId(@PathVariable Integer codigo){
		Departamento res = service.buscarPeloId(codigo);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}
}
