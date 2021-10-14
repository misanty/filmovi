package org.egitim.spring.model.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.egitim.spring.model.data.entity.FilmActor;
import org.egitim.spring.model.data.repository.FilmActorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class FilmActorService {

	@Autowired
	private FilmActorRepository filmActorRepository;

	@Transactional
	public List<FilmActor> findAll() {
		return (List<FilmActor>) filmActorRepository.findAll();
	}

	@Transactional
	public Optional<FilmActor> findById(Long id) {
		return filmActorRepository.findById(id);
	}

}
