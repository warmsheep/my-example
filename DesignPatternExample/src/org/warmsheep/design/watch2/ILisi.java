package org.warmsheep.design.watch2;

/**
 * 观察者接口
 * @author Warmsheep
 * @createTime Jan 7, 2013
 * @function 
 *
 */
public interface ILisi {

	/**
	 * 观察到活动上报
	 * @param hanfeizi
	 * @param context
	 */
	void update(IHanFeizi hanfeizi,String context);
}
