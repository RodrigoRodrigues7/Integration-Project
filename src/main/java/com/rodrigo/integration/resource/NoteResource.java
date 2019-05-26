package com.rodrigo.integration.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.integration.domain.Note;
import com.rodrigo.integration.service.NoteService;

@RestController
@RequestMapping(value="/notes")
public class NoteResource {
	
	@Autowired
	private NoteService service;
	
	@GetMapping
	public ResponseEntity<List<Note>> findAll() {
		List<Note> notes = service.findAll();
		return ResponseEntity.ok().body(notes);
	}
	
}
