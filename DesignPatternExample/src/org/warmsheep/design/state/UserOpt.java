package org.warmsheep.design.state;

/**
 * 普通用户状态
 * @author Warmsheep
 * @createTime Jan 10, 2013
 * @function 
 *
 */
public class UserOpt implements IUserOpt{

	@Override
	public boolean login(String userName, String password) {
		System.out.println("普通用户登录，跳转至首页");
		return false;
	}

	@Override
	public boolean submit() {
		System.out.println("普通用户提交");
		return false;
	}

}
