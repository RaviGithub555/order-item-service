package com.order.system.service;

import java.util.List;

import javax.validation.Valid;
import org.springframework.stereotype.Service;
import com.order.system.bean.ProductBean;
import com.order.system.document.Product;

@Service
public interface OrderItemService {
	
	public Product submitProductItem(ProductBean products);

	public Product updateProduct(@Valid ProductBean productBean, Long id);

	public List<Product> findAllProductItem();

	public Product findOne(Long id);

}
