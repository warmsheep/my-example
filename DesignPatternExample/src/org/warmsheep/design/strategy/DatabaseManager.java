package org.warmsheep.design.strategy;

import java.util.List;

/**
 * 环境类
 * @author Warmsheep
 * @createTime Jan 10, 2013
 * @function 
 * 环境类，持有一个策略的引用
 *
 */
public class DatabaseManager {
	
	public DatabaseManager(){
	}
	
	public DatabaseManager(IDBManager db){
		this.db = db;
	}

	/**
	 * 具体的策略对象，选择使用哪种数据库
	 */
	private IDBManager db = null;

	public IDBManager getDb() {
		return db;
	}

	public void setDb(IDBManager db) {
		this.db = db;
	}
	
	/**
	 * 增加一条数据
	 * @param o
	 * @return
	 */
	public boolean add(Object o){
		return db.add(o);
	}
	
	/**
	 * 更新一条数据
	 * @param o
	 * @return
	 */
	public boolean update(Object o){
		return db.update(o);
	}
	
	/**
	 * 删除一条数据
	 * @param id
	 * @return
	 */
	public boolean delete(int id){
		return db.delete(id);
	}
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public List<Object> findAll(){
		return db.findAll();
	}
	
	/**
	 * 查询一条数据
	 * @param id
	 * @return
	 */
	public Object findById(int id){
		return db.findById(id);
	}
}
