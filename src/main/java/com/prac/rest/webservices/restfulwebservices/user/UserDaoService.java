package com.prac.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	// JPA/Hibernate > Database
	// UserDaoService > Static List
	
	private static List<User> users = new ArrayList<>();
	
	private static int usersCounts = 0;
	
	static {
		users.add(new User(++usersCounts, "Prudhvi", LocalDate.now().minusYears(25)));
		users.add(new User(++usersCounts, "Revathi", LocalDate.now().minusYears(22)));
		users.add(new User(++usersCounts, "Charan", LocalDate.now().minusYears(24)));
		users.add(new User(++usersCounts, "Akhilada", LocalDate.now().minusYears(35)));
	}
	
	//public List<User> findAll() {
	public List<User> findAll(){
		return users;
	}

	//public User save(User user) {
	public User save(User user) {
		user.setId(++usersCounts);
		users.add(user);
		return user;
	}
	
	//public User findOne(int id) {
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}
}
