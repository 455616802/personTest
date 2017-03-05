package per.xhf.service;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.xhf.dao.LoginLogDao;
import per.xhf.dao.UserDao;
import per.xhf.model.LoginLog;
import per.xhf.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private LoginLogDao loginLogDao;
	
	public boolean getMatchCount(String userName,String userPasswd){
		return userDao.getMatchCount(userName, userPasswd)>0;
	}
	
	public User findByUserName(String userName){
		return userDao.findByUserName(userName);
	}
	
	public void loginSuccess(String userId){
		LoginLog log = new LoginLog();
		log.setUserId(userId);
		log.setLoginTime(new Timestamp(new Date().getTime()));
		loginLogDao.addLog(log);
	}
}
