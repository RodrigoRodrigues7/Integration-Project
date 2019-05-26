package com.rodrigo.integration.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rodrigo.integration.domain.Note;
import com.rodrigo.integration.service.NoteService;

@RestController
@RequestMapping(value="/notes")
public class NoteResource {
	
	@Autowired
	private NoteService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Note> findById(@PathVariable String id) {
		Note note = service.findById(id);
		return ResponseEntity.ok().body(note);
	}
	
	@GetMapping
	public ResponseEntity<List<Note>> findAll() {
		List<Note> notes = service.findAll();
		return ResponseEntity.ok().body(notes);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Note note) {
		note = service.insert(note);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(note.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@RequestBody Note note, @PathVariable String id) {
		note.setId(id);
		note = service.update(note);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
