package org.egitim.spring.model.data.repository;

import java.util.List;
import java.util.Optional;

import org.egitim.spring.model.data.entity.FilmActor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FilmActorRepository extends CrudRepository<FilmActor, Long>{
	
	
	public Optional<FilmActor> findById(Long id);
	
	@Override
	public List<FilmActor> findAll();
	
	@Override
	public long count();
	@Override
	public void delete(FilmActor entity);
	
	@Override
	public <S extends FilmActor> S save(S entity);
	

}
