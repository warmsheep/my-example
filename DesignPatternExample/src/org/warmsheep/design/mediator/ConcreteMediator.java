package org.warmsheep.design.mediator;

public class ConcreteMediator extends Mediator {

	@Override
	public void clearStock() {
		//不要再采购了
				super.purchase.refuseBuyIBM();
		//清仓折价销售
		super.sale.offSale();
		
	}

	@Override
	public void offSale() {
		// TODO Auto-generated method stub
		System.out.println("折价销售IBM电脑:"+stock.getStockNumber()+"台");
		super.stock.decrease(stock.getStockNumber());
	}

	@Override
	public void buyIBMComputer(int number) {
		// TODO Auto-generated method stub
		int saleStatus = super.sale.getSaleStatus();
		if(saleStatus > 80) //销售情况良好
		{
			System.out.println("采购IBM电脑:"+number+"台");
			super.stock.increase(number);
		}else {
			int buyNumber = number/2;	//折半采购
			System.out.println("采购IBM电脑:"+buyNumber + "台");
			super.stock.increase(buyNumber);
		}
	}

	@Override
	public void sellComputer(int number) {
		// TODO Auto-generated method stub
		//库存数量不够
		if(super.stock.getStockNumber() < number){
			super.purchase.buyIBMComputer(number);
		}
		super.stock.decrease(number);
	}

}
