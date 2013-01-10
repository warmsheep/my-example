package org.warmsheep.design.mediator;

/**
 * 客户，场景类
 * @author Warmsheep
 * @createTime Jan 7, 2013
 * @function 
 *
 */
public class Client {

	public static void main(String[] args) {
		ConcreteMediator mediator = new ConcreteMediator();
		Purchase purchase = new Purchase(mediator);
		Sale sale = new Sale(mediator);
		Stock stock = new Stock(mediator);
		
		
		mediator.setPurchase(purchase);
		mediator.setSale(sale);
		mediator.setStock(stock);
		
		System.out.println("-----------采购人员采购电脑-------------");
		purchase.buyIBMComputer(100);
		System.out.println("-----------销售人员销售电脑-------------");
		sale.sellIBMComputer(1);
		System.out.println("------------库房人员清理库存-------------");
		stock.clearStock();
	}
}
