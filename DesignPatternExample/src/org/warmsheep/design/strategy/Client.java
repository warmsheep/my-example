package org.warmsheep.design.strategy;

/**
 * 客户端
 * @author Warmsheep
 * @createTime Jan 10, 2013
 * @function 
 *
 */
public class Client {
	
	public static void main(String[] args) {
		//在new中指定具体的策略对象（执行对Oracle数据的操作）
		DatabaseManager db = new DatabaseManager(new OracleManager());
		
		db.add(new Object());
		db.update(new Object());
		db.delete(0);
	}

}
