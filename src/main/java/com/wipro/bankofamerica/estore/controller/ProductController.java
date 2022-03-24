package com.wipro.bankofamerica.estore.controller;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.bankofamerica.estore.model.Product;
import com.wipro.bankofamerica.estore.repository.ProductRepository;
import com.wipro.bankofamerica.estore.service.ProductService;

/**
 *
 * @author Jeevan -API Layer
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService eStoreService;

	/**
	 * This method is used to get all the policy details.
	 * 
	 */
	
	//Add, update, get, delete -CRUD- Produce the web services or restful services
	
	//List<Product> or Iterable<Product>
	@GetMapping("/getAll")
	public @ResponseBody Iterable<Product> getAllProduct() throws Exception {
		logger.info("Product Rest Controller Implementation : getAllProduct() method");
		return eStoreService.getAllProduct();  //here we are calling //
	}

	/*
	 * This method is used to store the product details for particular user.
	 */
	
	@PostMapping("/save")
	public ResponseEntity<Product> createProduct(@RequestBody Product product, HttpServletRequest request)
			throws Exception {
		Product createdProduct = this.eStoreService.saveProduct(product);
		logger.info("Product Rest Controller Implementation : createProduct() method");
		return ResponseEntity.ok().body(createdProduct);
	}

	/*
	 * This method is used to get the product details by using id
	 */
	@GetMapping("/get/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) {
		Product product = eStoreService.getProductById(id);
		logger.info("Product Rest Controller Implementation : getProductById() method");
		return ResponseEntity.ok().body(product);
	}

	/*
	 * This method is used to delete the product details of user by using id.
	 */
	
	@DeleteMapping("/delete/{id}")
	public void deleteProductById(@PathVariable("id") Integer id) throws Exception {
		logger.info("Product Rest Controller Implementation : deleteProductById() method");
		eStoreService.deleteProduct(id);
	}
}
