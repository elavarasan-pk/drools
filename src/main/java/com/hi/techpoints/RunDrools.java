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
			
			Product product = new Product("Pixel", 0, "Sale");
		    kSession.insert(product);
			kSession.fireAllRules();
			
			System.out.println("The discount for the mobile product "
					+ product.getModel() + " is " + product.getDiscount());

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
