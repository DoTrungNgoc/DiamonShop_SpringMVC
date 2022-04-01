package DiamonShop.Dao;

import org.springframework.stereotype.Repository;

import DiamonShop.Entity.MapperUsers;
import DiamonShop.Entity.Users;

@Repository
public class UserDao extends BaseDao{
	
	public boolean AddAccount(Users user) {
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO users ");
		sql.append("( ");
		sql.append("     user, ");
		sql.append("     password, ");
		sql.append("     display_name, ");
		sql.append("     address ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("     '"+user.getUser()+"', ");
		sql.append("     '"+user.getPassword()+"', ");
		sql.append("     '"+user.getDisplay_name()+"',");
		sql.append("     '"+user.getAddress()+"' ");
		sql.append(");");
		
		int rs = _jdbcTemplate.update(sql.toString());
		
		return rs>0 ? true:false;
	}
	
	public Users GetUserByAcc(Users user) {
		String sql = "SELECT * FROM `users` WHERE user = '"+user.getUser()+"'";
		Users us = _jdbcTemplate.query(sql, new MapperUsers()).get(0);
		return us;
	}
}
