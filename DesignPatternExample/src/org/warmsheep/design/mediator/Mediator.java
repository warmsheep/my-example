package org.warmsheep.design.mediator;

/**
 * 抽象的中介者类
 * @author Warmsheep
 * @createTime Jan 7, 2013
 * @function 
 *
 */
public abstract class Mediator {

	//定义同事类
	protected Purchase purchase;
	protected Sale sale;
	protected Stock stock;
	
	//通过Setter来注入同事类
	public Purchase getPurchase() {
		return purchase;
	}
	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	/**
	 * 清仓
	 */
	public abstract void clearStock();
	
	/**
	 * 折价处理
	 */
	public abstract void offSale();
	
	/**
	 * 采购电脑
	 */
	public abstract void buyIBMComputer(int number);
	
	/**
	 * 销售电脑
	 * @param number
	 */
	public abstract void sellComputer(int number);
}
