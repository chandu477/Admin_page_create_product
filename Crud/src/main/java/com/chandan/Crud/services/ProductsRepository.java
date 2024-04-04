package com.chandan.Crud.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chandan.Crud.model.Product;

//used to read and write products in database
//must extends to jps respository
//we dont nned to implements its methods because jpa will do it for us
public interface ProductsRepository extends JpaRepository<Product,Integer>{

}
