package org.warmsheep.design.mediator;

/**
 * 抽象的中介者
 * @author Warmsheep
 * @createTime Jan 7, 2013
 * @function 
 *
 */
public class AbstractMediator {

	protected Purchase purchase;
	protected Sale sale;
	protected Stock stock;
	
	public AbstractMediator(){
		purchase = new Purchase();
		sale = new Sale();
		stock = new Stock();
	}

}
