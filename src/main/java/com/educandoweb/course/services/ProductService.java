package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.dto.ProductDTO;
import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(
				() -> new ResourceNotFoundException("Objeto não encontrado ID: " + ", Tipo: " + Product.class.getName()));
	}
	
	public Product insert (Product obj) {
		return repository.save(obj);

	}
	
	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException  e) {
			 throw new DataIntegrityViolationException("Não é possivel excluir um produto que possua Categoria" , e);
		}
			
			
	}
	
	public Product update (Product obj) { //Dados que o ususario vai enviar para a requisição não tem vinculo com o Banco de dados
		Product newObj = findById(obj.getId()); //Instanciando um objecto produto e buscando no banco de dados
		updateData(newObj , obj);//Pegando os dados que enviei no  obj e atualizar o newOBJ e depois salvar
		return repository.save(newObj);
	}
			
	private void updateData(Product newObj, Product obj) { //Atalizar conforme a regra de negocio
		newObj.setName(obj.getName());
		newObj.setDescription(obj.getDescription());
		newObj.setPrice(obj.getPrice());
		
	}

	public Product fromDTO(ProductDTO objDTO) { //Converter DTO para entidade
		 return new Product(objDTO.getId(), objDTO.getName(), objDTO.getDescription(), objDTO.getPrice(), null); //recebendo os dados do DTO como parametro
	 }
	
	

}

	
