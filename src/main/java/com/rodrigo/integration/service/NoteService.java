package com.rodrigo.integration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.integration.domain.Note;
import com.rodrigo.integration.repository.NoteRepository;

@Service
public class NoteService {
	
	@Autowired
	public NoteRepository noteRepo;
	
	public List<Note> findAll() {
		return noteRepo.findAll();
	}
	
}
