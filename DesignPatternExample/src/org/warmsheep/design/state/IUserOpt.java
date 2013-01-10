package org.warmsheep.design.state;

/**
 * 状态的抽象接口
 * @author Warmsheep
 * @createTime Jan 10, 2013
 * @function 
 *
 */
public interface IUserOpt {

	boolean login(String userName,String password);
	
	boolean submit();
}
