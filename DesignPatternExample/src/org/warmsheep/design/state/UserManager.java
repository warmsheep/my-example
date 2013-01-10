package org.warmsheep.design.state;

public class UserManager {

	private IUserOpt userOpt = null;
	public static final int ADMIN = 0;
	public static final int USER = 1;
	
	public void login(String name,String password){
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
