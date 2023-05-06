package com.hi.techpoints;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;

import com.hi.techpoints.model.Product;

public class RunDrools {

	public static void main(String[] args) throws DroolsParserException,
			IOException {
		RunDrools droolsTest = new RunDrools();
		droolsTest.executeDrools();
	}

	public void executeDrools() throws DroolsParserException, IOException {

		PackageBuilder packageBuilder = new PackageBuilder();

		String ruleFile = "/com/rule/Rules.drl";
		InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);

		Reader reader = new InputStreamReader(resourceAsStream);
		packageBuilder.addPackageFromDrl(reader);
		org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(rulesPackage);

		WorkingMemory workingMemory = ruleBase.newStatefulSession();

		Product product = new Product();
		product.setModel("Pixel");

		workingMemory.insert(product);
		workingMemory.fireAllRules();

		System.out.println("The discount for the mobile product " + product.getModel()
				+ " is " + product.getDiscount());
	}

}
