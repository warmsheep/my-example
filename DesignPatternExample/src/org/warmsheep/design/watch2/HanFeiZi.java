package org.warmsheep.design.watch2;

import java.util.Vector;
/**
 * 被观察者类
 * @author Warmsheep
 * @createTime Jan 7, 2013
 * @function 
 * Vector是基于线程安全的，固这里采用线程安全作为观察者集合对象
 * 在进行活动的时候调用notifyObservers去通知所有的观察者。
 * 进行活动之前，应该调用addObserver去将需要观察的对象加入到集合中
 *
 */
public class HanFeiZi implements IHanFeizi {

	private Vector<ILisi> observer = new Vector<ILisi>();	//观察者对象列表
	private String name = "韩非子";
	
	@Override
	public void hasBreakFast() {
		notifyObservers("韩非子吃饭了");
	}

	@Override
	public void addObserver(ILisi o) {
		observer.add(o);
	}

	@Override
	public void delObserver(ILisi o) {
		observer.remove(o);
	}

	@Override
	public void notifyObservers(String context) {
		for(ILisi o : observer){
			o.update(this,context);
		}
	}
	
	/*
	 * Getter and Setter
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
