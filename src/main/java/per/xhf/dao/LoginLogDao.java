package per.xhf.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import per.xhf.model.LoginLog;

@Repository
public class LoginLogDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addLog(LoginLog log){
		String sql = "insert into t_login_log(user_id,login_time) "+" values(?,?)";
		Object[] args = {log.getUserId(), log.getLoginTime()};
		jdbcTemplate.update(sql, args);
	}
}
