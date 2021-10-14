package org.egitim.spring.model.service;

import java.util.List;


import javax.transaction.Transactional;

import org.egitim.spring.model.data.entity.Actor;

import org.egitim.spring.model.data.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ActorService {

	@Autowired private ActorRepository actorRepository;
	
	@Transactional
	public List<Actor> findAll() {
		return (List<Actor>) actorRepository.findAll();
	}

	@Transactional
	public List<Actor> findByLastName(String lastName) {
		return actorRepository.findByLastName(lastName);
	}


}
