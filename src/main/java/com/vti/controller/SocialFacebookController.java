package com.vti.controller;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.vti.dto.UserDTO;
import com.vti.repository.IUserRepository;
import com.vti.service.IUserService;
import com.vti.utils.JwtUtil;
import com.vti.utils.ResponseJwt;
import com.vti.utils.TokenDTO;

@RestController
@CrossOrigin("*")
public class SocialFacebookController {

	
	@Autowired
	private PasswordEncoder passwrodEncoder;
	
	 @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private JwtUtil jwtUtil;

	    @Autowired
	    @Qualifier("userDetailsService")
	    private UserDetailsService  userDetailsService;
	    
	    @Autowired
	    private IUserRepository userRepository;
	
	 
	
	@Autowired 
	IUserService userService;
	


	
	
	private String generateTokenFace(String id) {
		final UserDetails userDetails = userDetailsService.loadUserByUsername(id);
		String jwt = jwtUtil.generateToken(userDetails);
		return jwt;
	}
	
	
	
	
}
