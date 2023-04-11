package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

@Service
public class OrderService {
	
	//Declarar a dependencia para o userRepository e fazer a injeção de dependência
	
	@Autowired
	private OrderRepository repository;
	
	//Metodo retornar todos os ususarios do banco de dados
	public List<Order> findAll(){
		return repository.findAll();
		
	}
     //Metodo buscar usuario por ID depois tem que ir no Resource e criar o endpoint
	
	public Order findById(Long id) {
		Optional<Order> obj =  repository.findById(id);//recuperar usuario por Id
				return obj.get();
	}
	
}
