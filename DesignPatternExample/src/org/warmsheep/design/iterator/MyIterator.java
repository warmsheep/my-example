package org.warmsheep.design.iterator;

/**
 * 自定义迭代器接口
 * @author Warmsheep
 * @createTime Jan 11, 2013
 * @function 
 *
 */
public interface MyIterator {
	
	/**
	 * 是否还有下一个元素
	 * @return
	 */
	boolean hasNext();
	/**
	 * 取下一个元素
	 * @return
	 */
	Object next();
	/**
	 * 移除当前元素
	 * @return
	 */
	Object remove();
}
