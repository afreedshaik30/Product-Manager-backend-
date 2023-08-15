package com.bootcamp.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.productservice.dao.ProductRepositroy;
import com.bootcamp.productservice.model.product;

@Service
public class ProductService {
	@Autowired
	ProductRepositroy prrepo; 
	
	public List<product> findall(){	
	return (List<product>) prrepo.findAll();
	 }
	public product findByName(String pname){
		return prrepo.findByPname(pname).orElseThrow(()->new RuntimeException("Product Not Found"));
		
	}
	public product saveProduct(product p) {
		return prrepo.save(p);
	}
    public product updateProduct(int pid,product pr) {
    	product existing=prrepo.findById(pid).
    			orElseThrow(()->new RuntimeException("No Product Available with ID:"+pid ));
		if(pr.getPname()!=null)
			existing.setPname(pr.getPname());
		if(pr.getPrice()!=null)
			existing.setPrice(pr.getPrice());
		if(pr.getQuantity()!=null)
			existing.setQuantity(pr.getQuantity());
		return prrepo.save(existing);
    }
    public String deleteProduct(int pid) {
    	product existing =prrepo.findById(pid).orElseThrow(()->new RuntimeException("No Product Available with ID:"+pid ));
    	prrepo.deleteById(pid);
    	return "Product Deleted";
    }
} 