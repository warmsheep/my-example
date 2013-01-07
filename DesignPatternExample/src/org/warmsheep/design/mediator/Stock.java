package org.warmsheep.design.mediator;

/**
 * 库存管理
 * @author Warmsheep
 * @createTime Jan 7, 2013
 * @function 
 *
 */
public class Stock extends Colleague{

	public Stock(Mediator mediator) {
		super(mediator);
	}
	
	private static int COMPUTER_NUMBER = 100;
	
	/**
	 * 库存增加
	 * @param number
	 */
	public void increase(int number){
		COMPUTER_NUMBER +=  number;
		System.out.println("库存数量为:"+COMPUTER_NUMBER);
	}
	
	/**
	 * 库存减少
	 * @param number
	 */
	public void decrease(int number){
		COMPUTER_NUMBER -= number;
		System.out.println("库存数量为："+COMPUTER_NUMBER);
	}
	
	/**
	 * 获得库存数量
	 * @return
	 */
	public int getStockNumber(){
		return COMPUTER_NUMBER;
	}
	
	/**
	 * 清仓
	 */
	public void clearStock(){
		System.out.println("需要清理的存货数量为："+COMPUTER_NUMBER);
		mediator.clearStock();
	}

}
