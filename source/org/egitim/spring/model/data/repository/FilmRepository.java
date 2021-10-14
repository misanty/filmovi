package org.egitim.spring.model.data.repository;

import java.util.List;
import java.util.Optional;

import org.egitim.spring.model.data.entity.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {
	public List<Film> findByTitle(String title);
	public Optional<Film> findById(Long id);
	

}
