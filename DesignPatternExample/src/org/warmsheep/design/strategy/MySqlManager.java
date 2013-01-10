package org.warmsheep.design.strategy;

import java.util.List;

/**
 * MySql数据库策略的实现类
 * @author Warmsheep
 * @createTime Jan 10, 2013
 * @function 
 *
 */
public class MySqlManager implements IDBManager{

	@Override
	public boolean add(Object o) {
		System.out.println("MySql数据库添加数据");
		return true;
	}

	@Override
	public boolean delete(int id) {
		System.out.println("MySql数据库删除数据");
		return true;
	}

	@Override
	public boolean update(Object o) {
		System.out.println("MySql数据库更新数据");
		return false;
	}

	@Override
	public List<Object> findAll() {
		System.out.println("MySql数据库查找所有数据");
		return null;
	}

	@Override
	public Object findById(int id) {
		System.out.println("MySql数据库查找数据");
		return null;
	}

}
