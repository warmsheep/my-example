package org.warmsheep.design.state;

/**
 * 管理员的状态
 * @author Warmsheep
 * @createTime Jan 10, 2013
 * @function 
 *
 */
public class AdminOpt implements IUserOpt {

	@Override
	public boolean login(String userName, String password) {
		System.out.println("管理员登录成功，跳转至后台");
		return false;
	}

	@Override
	public boolean submit() {
		System.out.println("管理员提交");
		return false;
	}

}
