package com.bootcamp.productservice.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bootcamp.productservice.model.product;

public interface ProductRepositroy extends CrudRepository<product, Integer> {

	public Optional <product>findByPname(String pname);
} 
