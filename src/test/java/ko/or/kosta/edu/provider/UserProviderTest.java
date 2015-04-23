package ko.or.kosta.edu.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import kr.or.kosta.edu.domain.Address;
import kr.or.kosta.edu.domain.User;
import kr.or.kosta.edu.domain.UserPk;
import kr.or.kosta.edu.provider.UserProvider;
import kr.or.kosta.edu.provider.impl.UserProviderImpl;

import org.junit.Before;
import org.junit.Test;

public class UserProviderTest {
	
	private UserProvider provider;
	
	@Before
	public void setUp() {
		provider = new UserProviderImpl();
	}

	@Test
	public void testInsertAndFind() {
		Address address = new Address();
		address.setCountry("Seoul");
		User user = new User("demonpark1", "tester", address);
		provider.insertUser(user);
		
		List<User> users = provider.findAllUsers();
		assertNotNull(users);
		assertEquals("demonpark1", users.get(0).getUserId());
		
		user = new User("sjpark", "developer", address);
		provider.insertUser(user);
		
		users = provider.findAllUsers();
		assertEquals(2, users.size());
	}
	
	@Test
	public void testUpdate() {
		Address address = new Address();
		address.setCountry("Seoul");
		User user = new User("demonpark2", "tester", address);
		provider.insertUser(user);
		
		UserPk userPk = new UserPk();
		userPk.setUserId("demonpark2");
		userPk.setUserName("tester");
		User foundUser = provider.findUserByUserId(userPk);
		assertNotNull(foundUser);
		assertEquals("Seoul", foundUser.getAddress().getCountry());
		
		address = new Address();
		address.setCountry("United States");
		
		foundUser.setAddress(address);
		provider.updateUser(foundUser);
		
		User updateUser = provider.findUserByUserId(userPk);
		assertNotNull(updateUser);
		assertEquals("United States", updateUser.getAddress().getCountry());
	}
	
	@Test
	public void delete() {
		Address address = new Address();
		address.setCountry("Seoul");
		User user = new User("demonpark3", "tester", address);
		provider.insertUser(user);
		
		UserPk userPk = new UserPk();
		userPk.setUserId("demonpark3");
		userPk.setUserName("tester");
		User foundUser = provider.findUserByUserId(userPk);
		assertNotNull(foundUser);
		assertEquals("demonpark3", foundUser.getUserId());
		
		provider.deleteUserByUserId(userPk);
		
		User updatedUser = provider.findUserByUserId(userPk);
		assertEquals(null, updatedUser);
		
	}
}
