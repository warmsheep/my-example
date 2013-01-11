package org.warmsheep.design.iterator;

/**
 * 自定义容器接口
 * @author Warmsheep
 * @createTime Jan 11, 2013
 * @function 
 *  
 *  MyIterator是自定义的迭代器接口
 */
public interface MyCollection {
	
	/**
	 * 增加一个对象
	 * @param o 对象
	 */
	void add(Object o);
	
	/**
	 * 根据索引移除一个对象
	 * @param i 索引
	 * @return
	 */
	Object remove(int i);
	
	/**
	 * 根据对象引用移除一个对象
	 * @param o 对象引用
	 * @return
	 */
	Object remove(Object o);

	/**
	 * 获得迭代器
	 * @return
	 */
	MyIterator iterator();

}
