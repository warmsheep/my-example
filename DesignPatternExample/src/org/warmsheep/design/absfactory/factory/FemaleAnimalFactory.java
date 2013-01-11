package org.warmsheep.design.absfactory.factory;

import org.warmsheep.design.absfactory.entity.Animal;
import org.warmsheep.design.absfactory.entity.FemaleChicken;
import org.warmsheep.design.absfactory.entity.FemaleDog;

/**
 * 具体的实现工厂，雌性动物工厂
 * @author Warmsheep
 * @createTime Jan 11, 2013
 * @function 
 *
 */
public class FemaleAnimalFactory extends AnimalFactory{

	/**
	 * 生产母鸡
	 */
	@Override
	public Animal createChicken() {
		return new FemaleChicken();
	}

	/**
	 * 生产母狗
	 */
	@Override
	public Animal createDog() {
		// TODO Auto-generated method stub
		return new FemaleDog();
	}

}
