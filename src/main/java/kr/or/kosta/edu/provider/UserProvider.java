package kr.or.kosta.edu.provider;

import java.util.List;

import kr.or.kosta.edu.domain.User;
import kr.or.kosta.edu.domain.UserPk;

public interface UserProvider {
	User findUserByUserId(UserPk userId);
	List<User> findAllUsers();
	void insertUser(User user);
	void updateUser(User user);
	void deleteUserByUserId(UserPk userId);
}

