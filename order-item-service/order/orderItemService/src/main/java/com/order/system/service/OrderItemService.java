package com.order.system.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import com.order.system.model.Product;
import com.order.system.model.ProductBean;

@Service
public interface OrderItemService {
	
	public Product createProductItem(ProductBean products);

	public Product updateProduct(@Valid ProductBean productBean, Long id);

}
