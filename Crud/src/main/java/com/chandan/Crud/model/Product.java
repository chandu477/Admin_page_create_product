package com.chandan.Crud.model;

import java.util.Date;

import jakarta.persistence.*;




@Entity
@Table(name="Products")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	
	
	private String name ;
	private String category ;
	private double price ;
	private double discounted_price ;
	
	
	@Column(columnDefinition="TEXT")
	
	private String productdescription;
	private Date createdAt;
	private String imageUrl;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public  double getPrice() {
		return price;
	}
	public void setPrice(  double price) {
		this.price = price;
	}
	public  double getDiscounted_price() {
		return discounted_price;
	}
	public void setDiscounted_price( double discounted_price) {
		this.discounted_price = discounted_price;
	}
	public String getProductdescription() {
		return productdescription;
	}
	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	

	
	
	
	
	
	
	
}
