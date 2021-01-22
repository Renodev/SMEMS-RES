package com.rnc.smems.res.services;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.rnc.smems.res.entities.Product;
import com.rnc.smems.res.repositories.ProductRepository;

@LocalBean
@Stateless
public class ProductService {

	@Inject
	private ProductRepository productRepository;
	
	public void save (Product product) {
		
		if (product.getId() == 0) {
			product.setDate(LocalDate.now());
			productRepository.save(product);
		} else {
			productRepository.update(product);
		}
		
	} 
	
	public void delete (Product product) {
		product.setErase(true);
		productRepository.update(product);
	}
	
	public Product findByID (long id) {
		return productRepository.findByID(id);
	}
	
	
	
	
	
	
	
	public List<Product> findAll () {
		return productRepository.findAll();
	}

	public void update(Product product) {
		productRepository.update(product);
	}
}
