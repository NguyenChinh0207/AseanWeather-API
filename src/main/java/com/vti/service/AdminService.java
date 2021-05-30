package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.repository.IAdminRepository;

@Service
public class AdminService implements IAdminService{

	
	@Autowired
	private IAdminRepository repository;
	
	/**
	 * This method is exists By Email And Password.
	 * 
	 * @Description: .
	 * @author: Đặng Văn Hải
	 * @create_date: 16/5/2021
	 * @version: 1.0
	 * @modifer: 
	 * @modifer_date: 
	 * @param : email 
	 * @param : password
	 */
	public boolean isAdminExistsByEmailAndPassword(String email, String password) {
		// chuyển string password về sha256
		String sha256hexPassword = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password); 
		return repository.existsByEmailAndPassword(email, sha256hexPassword);
	}
	
	
}
