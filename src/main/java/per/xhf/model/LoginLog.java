package per.xhf.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class LoginLog implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String userId;
	
	private Timestamp loginTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Timestamp getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

}
