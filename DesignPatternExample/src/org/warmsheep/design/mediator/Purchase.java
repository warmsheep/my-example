package org.warmsheep.design.mediator;

/**
 * 采购管理
 * @author Warmsheep
 * @createTime Jan 7, 2013
 * @function 
 *
 */
public class Purchase extends Colleague {

	public Purchase(Mediator mediator) {
		super(mediator);
	}
	
	/**
	 * 买电脑
	 * @param number
	 */
	public void buyIBMComputer(int number){
		mediator.buyIBMComputer(number);
	}
	
	/**
	 * 不再采购电脑
	 */
	public void refuseBuyIBM(){
		System.out.println("不再采购IBM电脑");
	}

}
