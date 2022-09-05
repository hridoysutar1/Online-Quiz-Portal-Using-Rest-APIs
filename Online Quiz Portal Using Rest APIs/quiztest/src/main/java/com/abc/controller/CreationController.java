package com.abc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.User;
import com.abc.UserRepository;
import com.abc.model.ParticipantDetails;
import com.abc.repository.ParticipantDetailsRepo;

@RestController
public class CreationController {
	
	@Autowired
	ParticipantDetailsRepo ptRepo;
	
	@Autowired
	UserRepository urepo;
	
	@GetMapping("/admin/home")
	public String adminhome() {
		
		return  "<h1>Welcome Admin</h1>";
	}
	
	@PostMapping("/participant/register")
	public ResponseEntity<String> registerParticpant(@RequestBody ParticipantDetails pd) {
		
		
		try {
			ptRepo.save(pd);
			
			
			String uname=pd.getpName();
			String pass=pd.getPassword();
			User user=new User();
			user.setUsername(uname);
			user.setPassword(pass);
			user.setRole("participant");
			urepo.save(user);
			
		}catch(Exception e) {
			return new ResponseEntity<>("Failed",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return new ResponseEntity<>("success",HttpStatus.CREATED);
	}
	@PostMapping("/admin/createadmin")
	public ResponseEntity<String>createAdmin(@RequestBody User user) {
		
		
		try {
			urepo.save(user);
		}catch(Exception e) {
			return new ResponseEntity<>("Failed",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>("success",HttpStatus.CREATED);
	}
	
	@PutMapping("/admin/updateadmin/{id}")
	public ResponseEntity<String>updateAdmin(@PathVariable ("id") Integer id,@RequestBody User user) {
		
		
		try {
			
			User u=urepo.getById(id);
			u.setUsername(user.getUsername());
			u.setPassword(user.getPassword());
			u.setRole(user.getRole());
			urepo.save(u);
		}catch(Exception e) {
			return new ResponseEntity<>("Failed",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>("success",HttpStatus.CREATED);
	}
	
	
	

}
