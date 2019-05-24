package com.rodrigo.integration.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rodrigo.integration.domain.Note;

@Repository
public interface NoteRepository extends MongoRepository<Note, String>{

}
