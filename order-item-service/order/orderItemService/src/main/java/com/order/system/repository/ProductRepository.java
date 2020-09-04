package com.order.system.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.order.system.model.Product;

@Repository
public class ProductRepository{

    @Autowired
    MongoOperations mongoOperations;

	public Product save(@Valid Product product) {
		Product prdt = null;
		try {
			prdt = mongoOperations.save(product,"products");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prdt;
		
	}

	public List<Product> findAllWithSupplierAndCategory() {
		List<Product> productList = null;
		try {
			productList  = mongoOperations.findAll(Product.class, "products");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	public Product findOne(Long id) {
		Product product = null;
		try {
			Query query = new Query(Criteria.where("PRODCUT_ID").is(id));
			product = mongoOperations.findOne(query, Product.class, "products");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

}
