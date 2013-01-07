package org.warmsheep.design.watch2;

/**
 * 观察者类
 * @author Warmsheep
 * @createTime Jan 7, 2013
 * @function 
 *
 */
public class Lisi implements ILisi {

	/**
	 * 监听到活动就行动起来，将活动上报
	 */
	@Override
	public void update(IHanFeizi hanfeizi,String context) {
		// TODO Auto-generated method stub
		System.out.println("监控到新活动，活动者为："+hanfeizi.getName());
		upload(context);
	}

	public void upload(String context){
		System.out.println("将活动上报："+context);
	}
}
