package com.allansmesquita.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allansmesquita.workshopmongo.domain.Post;
import com.allansmesquita.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts") // Caminho do endpoint
public class PostResource {

	@Autowired
	private PostService service;

	@GetMapping(value = "/{id}") // atalho alternativo para: "RequestMapping(method=RequestMethod.GET)"
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
