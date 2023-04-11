package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

@Service
public class ProductService {
	
	//Declarar a dependencia para o ProductRepository e fazer a injeção de dependência
	
	@Autowired
	private ProductRepository repository;
	
	//Metodo retornar todos os ususarios do banco de dados
	public List<Product> findAll(){
		return repository.findAll();
		
	}
     //Metodo buscar usuario por ID depois tem que ir no Resource e criar o endpoint
	
	public Product findById(Long id) {
		Optional<Product> obj =  repository.findById(id);//recuperar usuario por Id
				return obj.get();
	}
	
}
