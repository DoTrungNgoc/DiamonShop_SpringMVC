package DiamonShop.Service.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.UserDao;
import DiamonShop.Entity.Users;
@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean AddAccount(Users user) {
		
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
		return userDao.AddAccount(user);
	}

	@Override
	public Users CheckUser(Users user) {
		String pass = user.getPassword();
		user = userDao.GetUserByAcc(user);
		if (user!=null) {
			if (BCrypt.checkpw(pass, user.getPassword())) {
				return user;
			}
		}
		
		return null;
	}

}
