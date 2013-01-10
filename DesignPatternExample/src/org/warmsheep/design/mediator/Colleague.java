package org.warmsheep.design.mediator;

/**
 * 抽象的同事类
 * @author Warmsheep
 * @createTime Jan 7, 2013
 * @function 
 *
 */
public class Colleague {

	protected Mediator mediator;
	
	public Colleague(Mediator mediator){
		this.mediator = mediator;
	}
}
