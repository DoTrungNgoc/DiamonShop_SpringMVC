package DiamonShop.Service.User;

import DiamonShop.Entity.Users;

public interface IUserService {
	public boolean AddAccount(Users user);
	public Users CheckUser(Users user);
}
