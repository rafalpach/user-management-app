package com.task.user_management_app.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAll() {
		return userService.showAllUsers();	
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return userService.getUserById(id);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteById(@PathVariable("id") int id){
		userService.delete(id);
	}
	
	@PostMapping("/user")
	public void createNewUser(@RequestBody User user) {
		userService.createIfDoesntExist(user.getName(), user.getSurname(), user.getGrade(), user.getSalary());
	}
	
	@PutMapping("/user/{id}")
	public void modifyUser(@PathVariable("id") int id, @RequestBody User user) {
		userService.update(id, user);
	}
	
	@GetMapping("/usersby")
	public List<User> getUsersByParameters(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "surname", required = false) String surname,
			@RequestParam(value = "grade", required = false) String grade,
			@RequestParam(value = "salary", required = false) String salary){
		return userService.getUsersByParameters(id, name, surname, grade, salary);
	}

}
