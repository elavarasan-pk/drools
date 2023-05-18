package com.hi.techpoints;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.hi.techpoints.model.Product;

public class RunDrools {

	public static final void main(String[] args) {
		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rule");

			System.out.println("**** Fire rules after inserting product ****");
			Product product1 = new Product(1, "Pixel");
		    kSession.insert(product1);
			kSession.fireAllRules();
			
			System.out.println("**** Fire rules after inserting product ****");
			Product product2 = new Product(2, "Iphone");
		    kSession.insert(product2);
			kSession.fireAllRules();
	

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
