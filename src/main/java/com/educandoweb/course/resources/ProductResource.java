package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.dto.ProductDTO;
import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/products")
public class ProductResource { // ProductResource que é um RestController
	
	
	private final ProductService service; //ProductResource que é um RestController tem a Dependencia com o Service

	@Autowired
	public ProductResource(ProductService service) {
	this.service = service;
}

	//endpoint para acessar os usuarios / controlador rest que responde no caminho users
	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll(){ 
		List<Product>list = service.findAll();
		//List<ProductDTO> listDto = list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList())
		List<ProductDTO> listDto = list.stream().map(ProductDTO::new).collect(Collectors.toList()); //Convertendo list de produtos para ProdutoDTO
		return ResponseEntity.ok().body(listDto); 
		
	}
	
	//endpoint buscar produto por Id
	@GetMapping(value = "/{id}") //pode ser assim tambem  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(new ProductDTO(obj));
		
	}
	
	//endpoint Inserir produto 
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody ProductDTO objDto){ //Retorna um objeto vazio e recebe como argumento ProductDTO
		Product obj = service.fromDTO(objDto); //Converter esse objDto para Product 
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); //URL do novo objeto inserido
		
		return ResponseEntity.created(uri).build();
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
