package org.warmsheep.design.singleton;

/**
 * 单例的对象
 * @author Warmsheep
 * @createTime Jan 11, 2013
 * @function 
 *
 */
public class JDBCSource {

	/**
	 * 私有化构造
	 */
	private JDBCSource(){
	}
	
	/**
	 * 含有一个私有的自身对象
	 */
	private static JDBCSource instance = null;
	
	/**
	 * 获取单例的对象
	 * @return
	 */
	public synchronized static JDBCSource getInstance(){
		if(instance == null){
			instance = new JDBCSource();
		}
		return instance;
	}
	
}
