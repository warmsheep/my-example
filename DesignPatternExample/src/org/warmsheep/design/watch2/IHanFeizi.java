package org.warmsheep.design.watch2;

/**
 * 被观察者
 * @author Warmsheep
 * @createTime Jan 7, 2013
 * @function 
 *
 */
public interface IHanFeizi {
	
	/**
	 * 吃早饭
	 */
	void hasBreakFast();
	
	/**
	 * 增加一个观察者
	 * @param o
	 */
	void addObserver(ILisi o);
	
	/**
	 * 删除一个观察者
	 * @param o
	 */
	void delObserver(ILisi o);
	
	/**
	 * 通知观察者
	 */
	void notifyObservers(String context);
	
	
	String getName();
}
