package org.egitim.spring.model.data.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Entity
@Table(name="film_actor")
public class FilmActor  {
	
	
	private FilmActorKey id;
	private Film film;
	private Actor actor;
	
	

	@EmbeddedId
	public FilmActorKey getId() {
		return id;
	}

	public void setId(FilmActorKey id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("filmId")
	@JoinColumn(name="film_id")
	public Film getFilm() {
		return film;
		
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	/*
	 *  @JoinTable(name = "cart_items",
            joinColumns = { @JoinColumn(name = "cart_id") },
            inverseJoinColumns = { @JoinColumn(name = "item_id") })*/
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("actorId")
	@JoinColumn(name= "actor_id")
	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}


	

}
