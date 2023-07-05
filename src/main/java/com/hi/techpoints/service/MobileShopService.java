package com.hi.techpoints.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hi.techpoints.model.Product;

@Service
public class MobileShopService {
 
	@Autowired
	private KieContainer kieContainer;

	public Product getProductDiscount(Product product) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(product);
		kieSession.fireAllRules();
		kieSession.dispose();
		return product;
	}
	
}