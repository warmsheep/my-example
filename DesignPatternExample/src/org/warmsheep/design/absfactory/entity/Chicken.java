package org.warmsheep.design.absfactory.entity;

/**
 * 抽象的鸡类
 * @author Warmsheep
 * @createTime Jan 11, 2013
 * @function 
 *
 */
public abstract class Chicken extends Animal{

	@Override
	public String getColor() {
		System.out.println("小鸡是黄色的");
		return null;
	}

	@Override
	public String shout() {
		System.out.println("鸡鸡 鸡鸡 鸡鸡 鸡鸡 鸡鸡鸡");
		return null;
	}

}
