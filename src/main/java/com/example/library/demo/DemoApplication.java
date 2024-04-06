package com.example.library.demo;

import com.example.library.demo.model.Author;
import com.example.library.demo.model.Book;
import com.example.library.demo.repository.BookRepository;
import com.example.library.demo.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	Menu menu;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		menu.executeCommand();
	}
}
