package org.warmsheep.design.watch;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者类
 * @author Warmsheep
 * @createTime Jan 7, 2013
 * @function 
 *
 */
public class LiSi implements Observer{

	@Override
	public void update(Observable observable,Object obj) {
		// TODO Auto-generated method stub
		System.out.println("观察到新的活动："+obj.toString());
		upload(obj.toString());
	}
	
	public void upload(String msg){
		System.out.println("上报内容："+msg);
	}

}
