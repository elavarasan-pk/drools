package com.hi.techpoints;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.hi.techpoints.model.Event;

public class RunDrools {

	public static final void main(String[] args) {
		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rule");

			kSession.insert(new Event("Outdoor", "Sport Event"));
			kSession.insert(new Event("Hockey", "Outdoor"));
		    kSession.insert(new Event("Required 11 players", "Hockey"));
		    kSession.fireAllRules();

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
