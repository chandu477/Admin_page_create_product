package com.chandan.Crud.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandan.Crud.model.Product;
import com.chandan.Crud.model.ProductDTO;
import com.chandan.Crud.services.ProductsRepository;

import jakarta.validation.Valid;

//help to perform crud operation on product

@RestController
@RequestMapping("/api/products")
public class ProductsController {

	
	
	
	@Autowired
	private ProductsRepository repo;
	
	//getall product
	@GetMapping
	public List<Product> getProduct(){
		return repo.findAll();
		
	}
	
	//get product by id
	@GetMapping("{id}")
	public ResponseEntity<Product>getProduct(@PathVariable int id){
		
		Product product=repo.findById(id).orElse(null);
		if(product==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(product);
	}
	
	
	
	
	@PostMapping
	public ResponseEntity<Object> createProduct(
			@Valid @RequestBody ProductDTO productdto,
			BindingResult result
			
			){
		
		double price=0;
		try {
			price=Double.parseDouble(productdto.getPrice());
		}
		catch(Exception ex) {
			result.addError(new FieldError("productdto","price", "the price should be number"));
	}
		
		
		double discounted_price=0;
		try {
			discounted_price=Double.parseDouble(productdto.getDiscounted_price());
		}
		catch(Exception ex) {
			result.addError(new FieldError("productdto","discounted_price", "the discounted_price should be number"));
	}
		
		
		if(result.hasErrors()) {
			var errorList=result.getAllErrors();
			var errorMap=new HashMap<String,String>();
			for(int i=0;i<errorList.size();i++) {
				var error =(FieldError) errorList.get(i);
				errorMap.put(error.getField(),error.getDefaultMessage());
		}
			return ResponseEntity.badRequest().body(errorMap);
		 
		}
		
		Product product=new Product();
		product.setname(productdto.getName());
		product.setPrice(price);
		product.setCategory (productdto.getCategory ());
		product.setDiscounted_price( discounted_price);
	product.setImageUrl(productdto.getImageUrl());
		product.setProductdescription(productdto.getProductdescription());
		
		product.setCreatedAt(new Date());
		
		repo.save(product);
			return ResponseEntity.ok(product);
		}
	
	
	
	@PutMapping("{id}")
	public ResponseEntity<Object>updateProduct(
			@PathVariable int id,
			@Valid @RequestBody ProductDTO productdto,
			BindingResult result
			
			){
		
		Product product =repo.findById(id).orElse(null);
		if(product==null) {
			return ResponseEntity.notFound().build();
		}
		double price=0;
		try {
			price=Double.parseDouble(productdto.getPrice());
		}
		catch(Exception ex) {
			result.addError(new FieldError("productdto","price", "the price should be number"));
	}
		
		
		double discounted_price=0;
		try {
			discounted_price=Double.parseDouble(productdto.getDiscounted_price());
		}
		catch(Exception ex) {
			result.addError(new FieldError("productdto","discounted_price", "the discounted_price should be number"));
	}
		
		if(result.hasErrors()) {
			var errorList=result.getAllErrors();
			var errorMap=new HashMap<String,String>();
			for(int i=0;i<errorList.size();i++) {
				var error =(FieldError) errorList.get(i);
				errorMap.put(error.getField(),error.getDefaultMessage());
		}
			return ResponseEntity.badRequest().body(errorMap);
		 
		}
		
		
		product.setname(productdto.getName());
		product.setPrice(price);
		product.setCategory (productdto.getCategory ());
		product.setDiscounted_price( discounted_price);
	    product.setImageUrl(productdto.getImageUrl());
		product.setProductdescription(productdto.getProductdescription());
		
		product.setCreatedAt(new Date());
		
		repo.save(product);
		return ResponseEntity.ok(product);
	}
	
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object>deleteProduct(@PathVariable int id){
		Product product =repo.findById(id).orElse(null);
		
		if(product==null) {
			return ResponseEntity.notFound().build();
		}
		repo.delete(product);
		return ResponseEntity.ok().build();
		
	}
	
	
	
	
	
	
	}
	
	

