package com.allansmesquita.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.allansmesquita.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	List<Post> findByTitleContainingIgnoreCase(String text); // findBy_ _ _ _Containing(Strin text) --> o findBy+atributo(que se
													// quer buscar)+containing faz com que o spring data monte
													// automaticamente a consulta. =>QUERRY METHODS ** "IgnoreCase" faz com que seja ignorado capslock. 

}
