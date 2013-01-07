package org.warmsheep.design.watch;

import java.util.Observable;

/**
 * 韩非子
 * @author Warmsheep
 * @createTime Jan 7, 2013
 * @function 被观察者
 * 继承Observable（被观察者）类
 *
 */
public class HanFeiZi extends Observable implements IHanFeiZi {

	@Override
	public void havebreakFast() {
		// TODO Auto-generated method stub
		super.setChanged();
		super.notifyObservers("我吃饭了");
	}
	
	@Override
	public void haveFun() {
		// TODO Auto-generated method stub
		super.setChanged();
		super.notifyObservers("我娱乐了");
	}

	@Override
	public void havebreakFast(boolean isnotifyObj) {
		// TODO Auto-generated method stub
		if(isnotifyObj){
			super.setChanged();
			super.notifyObservers("我吃饭了");
		}
	}

	@Override
	public void haveFun(boolean isnotifyObj) {
		// TODO Auto-generated method stub
		if(isnotifyObj){
			super.setChanged();
			super.notifyObservers("我娱乐了");
		}
	}

}
