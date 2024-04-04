package com.chandan.Crud.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ProductDTO {

	@NotEmpty(message="name is required")
	private String name;
	
	@NotEmpty(message="category is required")
	private String category ;
	
	
	@Min(0)
	private  String price;
	
	
	private  String discounted_price;
	
	@NotEmpty(message="imageUrl is required")
	private String image_url;
	
	@NotEmpty(message="description is required")
	@Size(min=10,message="Description Should be at least 10 Character")
	
	private String productdescription;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDiscounted_price() {
		return discounted_price;
	}

	public void setDiscounted_price(String discounted_price) {
		this.discounted_price = discounted_price;
	}

	public String getImageUrl() {
		return image_url;
	}

	public void setImageUrl(String imageUrl) {
		this.image_url = imageUrl;
	}

	public String getProductdescription() {
		return productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	

	
	
}
