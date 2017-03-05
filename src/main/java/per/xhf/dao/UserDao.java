package per.xhf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import per.xhf.model.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int getMatchCount(String userName,String userPasswd){
		String sql = "select count(0) from t_user "+" where user_name=? and user_passwd=? ";
		return jdbcTemplate.queryForObject(sql,new Object[]{userName,userPasswd},Integer.class);
	}
	
	public User findByUserName(String userName){
		String sql = "select user_id,user_name,user_passwd from t_user where user_name=?";
		final User user = new User();
		jdbcTemplate.query(sql, new Object[]{userName}, new RowCallbackHandler() {
			
			public void processRow(ResultSet rs) throws SQLException {
				user.setUserId(rs.getString("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setUserPasswd(rs.getString("user_passwd"));
			}
		});
		
		return user;
	}
}
