package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource { // CategoryResource que é um RestController
	
	@Autowired
	private CategoryService service; //CategoryResource que é um RestController tem a Dependencia com o Service
	
	//endpoint para acessar os usuarios / controlador rest que responde no caminho categories
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category>list = service.findAll();
		return ResponseEntity.ok().body(list); //.ok para retornar a resposta com sucesso e o .body retorna o corpo da mensagem
		
	}
	
	//endpoint buscar usuario por Id
	@GetMapping(value = "/{id}") // Vai indicar que minha requisição vai aceitar um id dentro da url
    public ResponseEntity<Category> finById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
}
