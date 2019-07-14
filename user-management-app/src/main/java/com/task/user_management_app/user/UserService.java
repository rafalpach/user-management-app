package com.task.user_management_app.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.task.user_management_app.error_message.UserNotFoundException;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> showAllUsers() {
		return userRepository.getAllUsers();
	}
	
	public User getUserById(int id) {
		try {
			return userRepository.getUserById(id);
		} catch (EmptyResultDataAccessException ex) {
			throw new UserNotFoundException(id);
		}
	}
	
	public void delete(int id) {
		User userToDelete = getUserById(id);
		userRepository.delete(userToDelete);
	}
	
	public void createIfDoesntExist(String name, String surname, Integer grade, Integer salary) {
		if(userRepository.getUserByName(name, surname).isEmpty()){
			User u = new User();
			u.setName(name);
			u.setSurname(surname);
			u.setGrade(grade);
			u.setSalary(salary);
			userRepository.create(u);
		}
	}
	
	public void update(int id, User user) {
		User userToUpdate = getUserById(id);
		if (user.getName() != null) {
			userToUpdate.setName(user.getName());
		}
		if (user.getSurname() != null) {
			userToUpdate.setSurname(user.getSurname());
		}
		if (user.getGrade() != null) {
			userToUpdate.setGrade(user.getGrade());
		}
		if (user.getSalary() != null) {
			userToUpdate.setSalary(user.getSalary());
		}
        userRepository.update(userToUpdate);
    }

	public List<User> getUsersByParameters(String id, String name, String surname, String grade, String salary) {
		return userRepository.getUsersByParameters(id, name, surname, grade, salary);
	}
	
}
