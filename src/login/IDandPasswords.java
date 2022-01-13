package login;

import java.util.HashMap;

public class IDandPasswords {

	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	public IDandPasswords(){
		
		logininfo.put("admin","password");
		logininfo.put("admin2","password2");
		logininfo.put("admin3","password3");
		
	}
	
	public HashMap getLoginInfo(){
		return logininfo;
	}
}