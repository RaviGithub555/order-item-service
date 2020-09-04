package com.order.system.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.order.system.model.Product;
import com.order.system.model.ProductBean;
import com.order.system.repository.ProductRepository;
import com.order.system.service.OrderItemService;
import com.order.system.web.exception.BadRequestException;
import com.order.system.web.exception.ResourceNotFoundException;

import javax.validation.Valid;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	private static final Logger log = LogManager.getLogger(ProductController.class);

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    OrderItemService orderItemService;


    @GetMapping
    public List<Product> findAll() {
        log.info("Find all products");
        return productRepository.findAllWithSupplierAndCategory();
    }

    @GetMapping("/{id}")
    public Product findOne(@PathVariable Long id) {
        log.info("Find product with id {}", id);
        return Optional.ofNullable(productRepository.findOne(id))
                .orElseThrow(ResourceNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody @Valid ProductBean productItemBean) {
        log.info("Create new {}", productItemBean);
        if (productItemBean==null) {
            throw new BadRequestException();
        }
        return orderItemService.createProductItem(productItemBean);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid ProductBean productBean) {
        log.info("Update {}", productBean);
        if (id==0) {
            throw new BadRequestException();
        }
        Product updateProduct = orderItemService.updateProduct(productBean,id);
    }

}
