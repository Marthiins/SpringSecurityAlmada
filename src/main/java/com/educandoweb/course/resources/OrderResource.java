package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource { // OrderResource que é um RestController
	
	@Autowired
	private OrderService service; //OrderResource que é um RestController tem a Dependencia com o Service
	
	//endpoint para acessar os usuarios / controlador rest que responde no caminho orders
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order>list = service.findAll();
		return ResponseEntity.ok().body(list); //.ok para retornar a resposta com sucesso e o .body retorna o corpo da mensagem
		
	}
	
	//endpoint buscar usuario por Id
	@GetMapping(value = "/{id}") // Vai indicar que minha requisição vai aceitar um id dentro da url
    public ResponseEntity<Order> finById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
}
