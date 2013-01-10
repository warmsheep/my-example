package org.warmsheep.design.state;

/**
 * 环境类
 * @author Warmsheep
 * @createTime Jan 10, 2013
 * @function 
 *
 */
public class UserManager {

	private IUserOpt userOpt = null;
	//代表各个状态的值
	public static final int ADMIN = 0;
	public static final int USER = 1;
	
	public void login(String name,String password){
		//通过动态获取状态来实例化不同的身份
		int state = getState(name);
		if(state == ADMIN){
			userOpt = new AdminOpt();
		}else if(state == USER){
			userOpt = new UserOpt();
		}
		userOpt.login(name, password);
	}
	
	private int getState(String userName){
		System.out.println("从数据库取得该用户的身份状态");
		return ADMIN;
	}
}
