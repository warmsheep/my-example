package org.warmsheep.design.absfactory.entity;

/**
 * 基础的抽象类，动物
 * @author Warmsheep
 * @createTime Jan 11, 2013
 * @function 
 * 
 * 所有的动物都包含颜色，叫，性别
 *
 */
public abstract class Animal {
	
	public abstract String getColor();
	public abstract String shout();
	public abstract void getSex();

}
