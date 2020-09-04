package com.order.system.service.impl;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.order.system.model.Product;
import com.order.system.model.ProductBean;
import com.order.system.repository.ProductRepository;
import com.order.system.service.OrderItemService;
import com.order.system.web.exception.BadRequestException;

@Service("OrderItemServiceImpl")
public class OrderItemServiceImpl implements OrderItemService{
	
	@Autowired
	ProductRepository productRepository;
	
	private static final Logger log = LogManager.getLogger(OrderItemServiceImpl.class);

	@Override
	public Product createProductItem(ProductBean productItemBean) {
		 log.info("Create new {}", productItemBean);	
		 if (productItemBean== null) {
		        throw new BadRequestException();
		    }
		    Random randm = null;
			try {
				randm = SecureRandom.getInstanceStrong();
			} catch (NoSuchAlgorithmException e) {
				 throw new BadRequestException();
			}
	        int productId = randm.nextInt(9000000) + 1000000;
	        if (productId == 0) {
	            throw new BadRequestException();
	        }
		 
		    Product productItem = new Product();
	        productItem.setId(productId);
	        productItem.setProductCatagory(productItemBean.getProductCatagory());
	        productItem.setProductCode(productItemBean.getProductCode());
	        productItem.setProductName(productItemBean.getProductName());
	        productItem.setProductPrice(productItemBean.getProductPrice());
	        productItem.setProductQuantity(productItemBean.getProductQuantity());
		 
		 Product itemCreate = null;
		 itemCreate = productRepository.save(productItem);
		
		return itemCreate;
	}


	@Override
	public Product updateProduct(@Valid ProductBean productBean, Long id) {
		Product currentProduct = null;
		Product updatedProduct = null;
		try {
			currentProduct = productRepository.findOne(id);
			if(productBean.getProductCatagory()!=null) {
				currentProduct.setProductCatagory(productBean.getProductCatagory());
			}
			if(productBean.getProductName()!=null) {
				currentProduct.setProductName(productBean.getProductName());
			}
			if(productBean.getProductPrice()!=null) {
				currentProduct.setProductPrice(productBean.getProductPrice());
			}
			if(productBean.getProductCode()!=null) {
				currentProduct.setProductCode(productBean.getProductCode());
			}
			if(productBean.getProductQuantity()!=null) {
				currentProduct.setProductQuantity(productBean.getProductQuantity());
			}
			updatedProduct = productRepository.save(currentProduct);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return updatedProduct;
	}

}

