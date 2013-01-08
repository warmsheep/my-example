package org.warmsheep.design.mediator;

import java.util.Random;

/**
 * 销售管理
 * @author Warmsheep
 * @createTime Jan 7, 2013
 * @function 
 *
 */
public class Sale extends Colleague {

	public Sale(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 销售电脑
	 * @param number
	 */
	public void sellIBMComputer(int number){
		mediator.sellComputer(number);
		System.out.println("销售IBM电脑"+number+"台");
	}
	
	/**
	 * 反馈销售情况
	 * @return
	 */
	public int getSaleStatus(){
		Random rand = new Random(System.currentTimeMillis());
		int saleStatus = rand.nextInt(100);
		System.out.println("IBM电脑的销售情况为:"+saleStatus);
		return saleStatus;
	}
	
	/**
	 * 折价处理
	 */
	public void offSale(){
		mediator.offSale();
	}

}
