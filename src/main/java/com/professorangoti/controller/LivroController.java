package com.professorangoti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.professorangoti.domain.Livro;
import com.professorangoti.repository.LivroRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LivroController {

	@Autowired
	LivroRepository repo;

	@GetMapping("/livro")
	public ResponseEntity<List<Livro>> todos() {
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
	}

	@GetMapping("/livro/{id}")
	public ResponseEntity<Livro> getLivro(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(repo.findById(id).orElseThrow(RuntimeException::new));
	}

	@PostMapping("/livro")
	public ResponseEntity<Livro> novo(@RequestBody Livro tutorial) {
		return ResponseEntity.status(HttpStatus.OK).body(repo.save(tutorial));
	}

	@PutMapping("/livro/{id}")
	public ResponseEntity<Livro> updateTutorial(@PathVariable("id") Long id, @RequestBody Livro tutorial) {
		tutorial.setId(id);
		return ResponseEntity.status(HttpStatus.OK).body(repo.save(tutorial));
	}

	@DeleteMapping("/livro/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		repo.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
