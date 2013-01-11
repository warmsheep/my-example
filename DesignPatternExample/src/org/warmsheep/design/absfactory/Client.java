package org.warmsheep.design.absfactory;

import org.warmsheep.design.absfactory.entity.Animal;
import org.warmsheep.design.absfactory.factory.AnimalFactory;
import org.warmsheep.design.absfactory.factory.FemaleAnimalFactory;
import org.warmsheep.design.absfactory.factory.MaleAnimalFactory;

public class Client {

	public static void main(String[] args) {
		//公母两条产线
		AnimalFactory femaleFactory = new FemaleAnimalFactory();
		AnimalFactory maleFactory = new MaleAnimalFactory();
		
		//开始生产
		Animal chicken = femaleFactory.createChicken();
		Animal dog = maleFactory.createDog();
		
		chicken.getColor();
	    chicken.getSex();
	    chicken.shout();
	    
	    dog.getColor();
	    dog.getSex();
	    dog.shout();
		
	}
}
