package org.warmsheep.design.absfactory.entity;

/**
 * 抽象的狗类
 * @author Warmsheep
 * @createTime Jan 11, 2013
 * @function 
 *
 */
public abstract class Dog extends Animal{

	@Override
	public String getColor() {
		System.out.println("小狗是白色的");
		return null;
	}

	@Override
	public String shout() {
		System.out.println("汪汪 汪汪 汪汪 汪汪 汪汪汪");
		return null;
	}

}
