package com.allansmesquita.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allansmesquita.workshopmongo.domain.User;
import com.allansmesquita.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users") //Caminho do endpoint 
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping // atalho alternativo para: "RequestMapping(method=RequestMethod.GET)" 
	public ResponseEntity<List<User>> findAll(){
		
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
