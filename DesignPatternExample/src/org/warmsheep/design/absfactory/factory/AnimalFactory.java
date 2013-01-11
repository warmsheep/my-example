package org.warmsheep.design.absfactory.factory;

import org.warmsheep.design.absfactory.entity.Animal;

/**
 * 抽象的动物工厂
 * @author Warmsheep
 * @createTime Jan 11, 2013
 * @function 
 *
 */
public abstract class AnimalFactory {

	/**
	 * 生产鸡
	 * @return
	 */
	public abstract Animal createChicken();
	
	/**
	 * 生产狗
	 * @return
	 */
	public abstract Animal createDog();
}
