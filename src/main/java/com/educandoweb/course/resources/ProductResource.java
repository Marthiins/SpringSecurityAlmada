package com.educandoweb.course.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.dto.ProductDTO;
import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource { // ProductResource que é um RestController
	
	@Autowired
	private ProductService service; //ProductResource que é um RestController tem a Dependencia com o Service
	
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
	
	
}
