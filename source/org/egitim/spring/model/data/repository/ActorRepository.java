package org.egitim.spring.model.data.repository;

import java.util.List;
import java.util.Optional;

import org.egitim.spring.model.data.entity.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Long> {

	public List<Actor> findByLastName(String lastName);
	public Optional<Actor> findById(Long id);
	
	@Override
	public List<Actor> findAll();
	
	@Override
	public long count();
	@Override
	public void delete(Actor entity);
	
	@Override
	public <S extends Actor> S save(S entity);
	
	
	
	
	
	

}
