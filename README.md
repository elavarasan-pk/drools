Consider a Mobile shop which needs to maintain business logic of calculating discount based on the type of mobile model. This can be done in our Java Code. But such rules may change daily and need to be updated regularly in our code which is not good. Also we will always require a Developer for making such changes. So its a good practice to define this logic as rules in a Business Rule Management System. If tomorrow the discount is to be changed this can be done even by a non technical person.

Let’s start
Using drools we have to define the discounts offered on various mobile products depending on the model. For example if the product is ‘Google Pixel’ model offer a discount of 30% and so on. We will create Eclipse Maven project as follows-


The POM defined is as follows- Only a single dependency og Drools-compiler is required.

<dependencies>
    <dependency>
      <groupId>org.drools</groupId>
      <artifactId>drools-compiler</artifactId>
      <version>6.0.1.Final</version>
   </dependency>
</dependencies>
Next define the Model class Product which defines the type of mobile model item.

package com.hi.techpoints.model;
 
public class Product {
 
    private String model;
    private int discount;
 
    public String getModel() {
        return model;
    }
 
    public void setModel(String model) {
        this.model = model;
    }
 
    public int getDiscount() {
        return discount;
    }
 
    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
Now define the rules in the drl file. We will use the type property of the Product class for defining the rules for defining what action needs to be taken if a particular condition is met. The .drl file should be place in resources/com.rule folder.

package com.rule
 
import com.hi.techpoints.model.Product
 
rule "Offer for Iphone"
    when 
        productObject: Product(model=="Iphone")
    then
        productObject.setDiscount(20);
    end
     
rule "Offer for Pixel"
    when 
        productObject: Product(model=="Pixel")
    then
        productObject.setDiscount(30);
    end
Drools employs a concept called Working Memory. Finally we define DroolsTest class to load the facts and the rules in the drools working memory and firing all the rules.

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
