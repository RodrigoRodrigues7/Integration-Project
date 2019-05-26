package com.rodrigo.integration.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.integration.domain.Note;
import com.rodrigo.integration.repository.NoteRepository;
import com.rodrigo.integration.service.Exceptions.ObjectNotFoundException;

@Service
public class NoteService {
	
	@Autowired
	private NoteRepository noteRepo;
	
	public Note findById(String id) {
		Optional<Note> note = noteRepo.findById(id);
		return note.orElseThrow(() -> new ObjectNotFoundException("This ID is Invalid!"));
	}
	
	public List<Note> findAll() {
		return noteRepo.findAll();
	}
	
	public Note insert(Note note) {
		note.setDate(new Date());
		return noteRepo.insert(note);
	}
	
	public Note update(Note note) {
		Note newNote = findById(note.getId());
		updateNote(newNote, note);
		return noteRepo.save(newNote);
	}

	public void delete(String id) {
		findById(id);
		noteRepo.deleteById(id);
	}
	
	private void updateNote(Note newNote, Note note) {
		newNote.setTitle(note.getTitle());
		newNote.setDescription(note.getDescription());
		newNote.setTag(note.getTag());
	}
	
}
