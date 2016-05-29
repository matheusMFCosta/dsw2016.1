package com.actions;

public class actions extends Action {
	
	
	@DisableUserVerification
	@Error("/jsp/login/login.jsp")
	@Success("/login/homepage.do")
	public String login() throws ActionException
	{
		
	}

}
