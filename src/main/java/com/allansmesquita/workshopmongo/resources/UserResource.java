package com.allansmesquita.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allansmesquita.workshopmongo.domain.User;
import com.allansmesquita.workshopmongo.dto.UserDTO;
import com.allansmesquita.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users") //Caminho do endpoint 
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping // atalho alternativo para: "RequestMapping(method=RequestMethod.GET)" 
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{id}") // atalho alternativo para: "RequestMapping(method=RequestMethod.GET)" 
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
}
