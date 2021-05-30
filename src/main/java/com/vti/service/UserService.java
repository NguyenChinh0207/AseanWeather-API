package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.User;
import com.vti.repository.IUserRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserRepository userRepository;

	@Override
	public User getUserById(String id) {
		return userRepository.findById(id);
	}
	/**
	 * This method is exists User By ID.
	 * 
	 * @Description: .
	 * @author: Nguyễn Thị Chinh
	 * @create_date: 13/5/2021
	 * @version: 1.0
	 * @modifer: 
	 * @modifer_date: 
	 * @param: id
	 */
	@Override
	public boolean isExistsUserById(String id) {
		// TODO Auto-generated method stub
		return userRepository.existsById(id);
	}

	/**
	 * This method create User.
	 * 
	 * @Description: .
	 * @author:Nguyễn Thị Chinh
	 * @create_date: 3/5/2021
	 * @version: 1.0
	 * @modifer: 
	 * @modifer_date: 
	 * @param : user
	 */
	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
}
