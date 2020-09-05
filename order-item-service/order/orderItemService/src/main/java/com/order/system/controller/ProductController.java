package com.order.system.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.order.system.bean.ProductBean;
import com.order.system.document.Product;
import com.order.system.service.OrderItemService;
import com.order.system.web.exception.BadRequestException;
import com.order.system.web.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	private static final Logger log = LogManager.getLogger(ProductController.class);

    
    @Autowired
    OrderItemService orderItemService;


    @GetMapping("/products")
    public List<Product> findAllProducts() {
        log.info("Find all products");
        return orderItemService.findAllProductItem();
    }

    @GetMapping("/{id}")
    public Product findOne(@PathVariable Long id) {
        log.info("Find product with id {}", id);
        return Optional.ofNullable(orderItemService.findOne(id))		
                .orElseThrow(ResourceNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody @Valid ProductBean product) {
        log.info("Create new {}", product);
        if (product==null) {
            throw new BadRequestException();
        }
        return orderItemService.submitProductItem(product);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody @Valid ProductBean product) {
        log.info("Update {}", product);
        String updateMessage = null;
        if (id==0) {
            throw new BadRequestException();
        }
        Product updateProduct = orderItemService.updateProduct(product,id);
        if(updateProduct!=null) {
        	updateMessage = "product successfully update";
        }else {
        	updateMessage = "product not updated";
        }
		return updateMessage;
    }

}
