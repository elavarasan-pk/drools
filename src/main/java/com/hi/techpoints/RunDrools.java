package com.hi.techpoints;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hi.techpoints.model.Product;
import com.hi.techpoints.service.ProductServiceImpl;

public class RunDrools {

	public static void main(String args[]) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ProductServiceImpl bean = ((ProductServiceImpl) applicationContext
				.getBean("ProductServiceImpl"));

		Product product = new Product();
		product.setModel("Pixel");

		bean.calculateDiscount(product);

		showDiscount(product);
	}

	private static void showDiscount(Product product) {
		System.out.println("The discount for the product (" + product.getModel() + ") is " + product.getDiscount());
	}

}
