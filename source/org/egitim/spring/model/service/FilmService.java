package org.egitim.spring.model.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.egitim.spring.model.data.entity.Film;
import org.egitim.spring.model.data.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class FilmService {

@Autowired private FilmRepository filmRepository;

	@Transactional
	public List<Film> findAll() {
		return (List<Film>) filmRepository.findAll();
	}

	@Transactional
	public List<Film> findByTitle(String title) {
		return filmRepository.findByTitle(title);
	}
	

/*
	@Transactional
	public Optional<Film> findById(Long id) {
		return filmRepository.findById(id);
	}*/

}
