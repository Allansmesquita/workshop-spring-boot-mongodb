package com.allansmesquita.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allansmesquita.workshopmongo.domain.Post;
import com.allansmesquita.workshopmongo.repository.PostRepository;
import com.allansmesquita.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public List<Post> findByTitle(String text) { // "findByTitle" pode ser qualquer nome, não se trata de um querry
													// methods.
		return repo.findByTitleContainingIgnoreCase(text);
	}
}
