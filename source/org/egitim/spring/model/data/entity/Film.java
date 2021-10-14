package org.egitim.spring.model.data.entity;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Film")
@Table(name = "film")
public class Film extends BaseEntity {

	private static final long serialVersionUID = -5051043507605351350L;

	private Long id;
	private String title;
	private String description;
	private String releaseYear;
	private Rate rating;
	private List<FilmActor> filmActor = new ArrayList<FilmActor>();

	@Id
	@Column(name = "film_id", insertable = false, updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "release_year")
	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	@Column(name = "rating")
	@Enumerated(EnumType.ORDINAL)
	public Rate getRating() {
		return rating;
	}

	public void setRating(Rate rating) {

		this.rating = rating;
	}

	
	// this!
	@Transient
	public String shortInfo() {

		return "Film is:" + this.getTitle() + " / "+"Rating: " + this.getRating().name();
	}

	@OneToMany(mappedBy = "film", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	public List<FilmActor> getFilmActor() {
		return filmActor;
	}

	public void setFilmActor(List<FilmActor> filmActor) {
		this.filmActor = filmActor;
	}

}
