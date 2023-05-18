package com.hi.techpoints;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import com.hi.techpoints.model.Product;

public class RunDrools {

	public static final void main(String[] args) {
		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			StatelessKieSession kSession = kContainer.newStatelessKieSession();

			System.out.println("**** Fire rules after inserting product ****");
			Product product1 = new Product(1, "Pixel");
		    kSession.execute(product1);
			
			System.out.println("**** Fire rules after inserting product ****");
			Product product2 = new Product(2, "Iphone");
			kSession.execute(product2);
	

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
