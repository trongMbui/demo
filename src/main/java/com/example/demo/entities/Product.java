package com.example.demo.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotEmpty(message="{Size.Product.Brand}")
	@Size(min = 5, message="{Size.Product.Name}")
    private String name;
	
	@NotEmpty(message ="{Size.Product.Brand}")
    private String brand;
    
	@NotEmpty(message ="{Size.Product.Brand}")
	@Size(min = 3, message ="{Size.Product.Madein}")
	private String madein;

	@NotNull(message = "Size.Product.Brand")
	@Min(value = 1, message = "{Size.Product.Price}")
    private float price;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMadein() {
		return this.madein;
	}

	public void setMadein(String madein) {
		this.madein = madein;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}


   
}
