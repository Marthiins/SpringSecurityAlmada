package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {
	
	//Declarar a dependencia para o categoryRepository e fazer a injeção de dependência
	
	@Autowired
	private CategoryRepository repository;
	
	//Metodo retornar todos os ususarios do banco de dados
	public List<Category> findAll(){
		return repository.findAll();
		
	}
     //Metodo buscar usuario por ID depois tem que ir no Resource e criar o endpoint
	
	public Category findById(Long id) {
		Optional<Category> obj =  repository.findById(id);//recuperar usuario por Id
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado ID: " + ", Tipo: " + Category.class.getName()));
	}
	
}
