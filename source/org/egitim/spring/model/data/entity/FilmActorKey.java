package org.egitim.spring.model.data.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FilmActorKey implements Serializable {
	
	private static final long serialVersionUID = 2860742393797148175L;

	
	private Long filmId;
	private Long actorId;	
	
	@Column(name="film_id")
	public Long getFilmId() {
		return filmId;
	}

	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}
	
	@Column(name="actor_id")
	public Long getActorId() {
		return actorId;
	}

	public void setActorId(Long actorId) {
		this.actorId = actorId;
	}

	

	public FilmActorKey() {
		
	}
	
	

	public FilmActorKey(Long filmId, Long actorId) {
		super();
		setFilmId(filmId);
		setActorId(actorId);
	}
	
	

	@Override
	public boolean equals(Object obj) {
		
		 if (this == obj) return true;
	        if (obj == null || getClass() != obj.getClass()) return false;
	        FilmActorKey filmActorKey = (FilmActorKey) obj;
	        return getFilmId().equals(filmActorKey.getFilmId()) &&
	                getActorId().equals(filmActorKey.getActorId());
	}

	@Override
	public int hashCode() {
		
		return Objects.hash(getFilmId(),getActorId());
	}
	
	
	
	

}
