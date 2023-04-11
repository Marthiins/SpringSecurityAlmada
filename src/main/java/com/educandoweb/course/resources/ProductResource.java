package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource { // ProductResource que é um RestController
	
	@Autowired
	private ProductService service; //ProductResource que é um RestController tem a Dependencia com o Service
	
	//endpoint para acessar os usuarios / controlador rest que responde no caminho users
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product>list = service.findAll();
		return ResponseEntity.ok().body(list); //.ok para retornar a resposta com sucesso e o .body retorna o corpo da mensagem
		
	}
	
	//endpoint buscar usuario por Id
	@GetMapping(value = "/{id}") // Vai indicar que minha requisição vai aceitar um id dentro da url
    public ResponseEntity<Product> finById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
}
