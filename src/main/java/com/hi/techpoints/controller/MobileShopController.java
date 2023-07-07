package com.hi.techpoints.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hi.techpoints.model.Product;
import com.hi.techpoints.service.MobileShopService;

@RestController
public class MobileShopController {
	
	@Autowired
	private MobileShopService mobileShopService; 

	@RequestMapping(value = "/getDiscount", method = RequestMethod.GET, produces = "application/json")
	public Product getQuestions(@RequestParam(required = true) String model) {
		Product product = new Product();
		product.setModel(model);
		mobileShopService.getProductDiscount(product);
		return product;
	}

}
