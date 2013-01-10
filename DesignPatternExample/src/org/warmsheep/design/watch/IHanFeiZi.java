package org.warmsheep.design.watch;

public interface IHanFeiZi {

	/**
	 * 吃饭
	 */
	void havebreakFast();
	/**
	 * 重载，被观察者自己做主是否通知观察者
	 * @param isnotifyObj
	 */
	void havebreakFast(boolean isnotifyObj);
	/**
	 * 娱乐
	 */
	void haveFun();
	/**
	 * 重载，被观察者自己做主是否通知观察者
	 * @param isnotifyObj
	 */
	void haveFun(boolean isnotifyObj);
}
