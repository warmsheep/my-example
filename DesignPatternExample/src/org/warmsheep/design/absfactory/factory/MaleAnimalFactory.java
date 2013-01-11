package org.warmsheep.design.absfactory.factory;

import org.warmsheep.design.absfactory.entity.Animal;
import org.warmsheep.design.absfactory.entity.MaleChicken;
import org.warmsheep.design.absfactory.entity.MaleDog;

/**
 * 具体的实现工厂，雄性动物工厂
 * @author Warmsheep
 * @createTime Jan 11, 2013
 * @function 
 *
 */
public class MaleAnimalFactory extends AnimalFactory {

	/**
	 * 生产公鸡
	 */
	@Override
	public Animal createChicken() {
		return new MaleChicken();
	}

	/**
	 * 生产公狗
	 */
	@Override
	public Animal createDog() {
		return new MaleDog();
	}

}
