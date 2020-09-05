package com.order.system.document;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.persistence.*;

@Document(collection = "products")
public class Product {
	
	@Id
	private String mongoId;

	@Field("PRODCUT_ID")
	private int Id;
	
	@Field("PRODCUT_NAME")
	private String productName;
	
	@Field("PRODCUT_CODE")
	private String productCode;
	
	@Field("PRODCUT_CATAGORY")
	private String productCatagory;
	
	@Field("PRODCUT_QUANTITY")
	private String productQuantity;
	
	@Field("PRODCUT_PRICE")
	private String productPrice;

	public String getMongoId() {
		return mongoId;
	}

	public void setMongoId(String mongoId) {
		this.mongoId = mongoId;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductCatagory() {
		return productCatagory;
	}

	public void setProductCatagory(String productCatagory) {
		this.productCatagory = productCatagory;
	}

	public String getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	
}