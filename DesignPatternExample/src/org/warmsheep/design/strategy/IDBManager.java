package org.warmsheep.design.strategy;

import java.util.List;

/**
 * 策略的接口
 * @author Warmsheep
 * @createTime Jan 10, 2013
 * @function 
 *	给出策略所需实现的接口
 */
public interface IDBManager {

	boolean add(Object o);
	
	boolean delete(int id);
	
	boolean update(Object o);
	
	List<Object> findAll();
	
	Object findById(int id);
}
