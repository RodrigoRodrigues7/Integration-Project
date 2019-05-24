package com.rodrigo.integration.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rodrigo.integration.domain.Note;
import com.rodrigo.integration.domain.User;
import com.rodrigo.integration.domain.UserDTO;
import com.rodrigo.integration.repository.NoteRepository;
import com.rodrigo.integration.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private NoteRepository noteRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepo.deleteAll();
		noteRepo.deleteAll();

		User cheif = new User(null, "Master Cheif", "sierra177@gmail.com");
		User johnson = new User(null, "Sergeant Johnson", "Johnson@gmail.com");
		User arbiter = new User(null, "Thel Vadamee", "Sangheili@gmail.com");

		Note noteC = new Note(null, "Finnish the Fight", "A simple guide on how to finnish the goddam fight", "unsc", sdf.parse("24/05/2554"), new UserDTO(cheif));
		Note noteJ = new Note(null, "Fight for Her", "Fight for the earth marines", "unsc", sdf.parse("21/02/2552"), new UserDTO(johnson));
		Note noteA = new Note(null, "Invade Reach", "Today is the invasion of the covenant armada on Reach", "covenant", sdf.parse("13/03/2550"), new UserDTO(arbiter));
		
		noteRepo.saveAll(Arrays.asList(noteC, noteJ, noteA));
		
		cheif.getNotes().addAll(Arrays.asList(noteC));
		johnson.getNotes().addAll(Arrays.asList(noteJ));
		arbiter.getNotes().addAll(Arrays.asList(noteA));
		
		userRepo.saveAll(Arrays.asList(cheif, johnson, arbiter));
	}

}
