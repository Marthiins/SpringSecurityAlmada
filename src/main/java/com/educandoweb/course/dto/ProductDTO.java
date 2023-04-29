package com.educandoweb.course.dto;

import java.io.Serializable;

import com.educandoweb.course.entities.Product;

public class ProductDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String description;
	private Double price;
	// private String imgUrl; - Não quero expor essa entidade
	
	
	
	public ProductDTO() {

	}

	public ProductDTO(Product obj) {
		id = obj.getId();
		name = obj.getName();
		description = obj.getDescription();
		price = obj.getPrice();
		//imgUrl = obj.getImgUrl();
	
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	/*public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}*/
	
	
}
