package org.egitim.spring.model.data.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Actor extends BaseEntity {

	private static final long serialVersionUID = -5147339012734303479L;

	private Long id;
	private String firstName;
	private String lastName;
	private Date lastUpdate;
	private List<FilmActor> filmActor = new ArrayList<FilmActor>();

	@Id
	@Column(name = "actor_id", insertable = false, updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update", nullable = false)
	public Date getlastUpdate() {
		return lastUpdate;
	}

	public void setlastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String shortInfo() {

		return "Actor: " + this.getFirstName() + " " + this.getLastName();
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@OneToMany(mappedBy = "actor", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	public List<FilmActor> getFilmActor() {
		return filmActor;
	}

	public void setFilmActor(List<FilmActor> filmActor) {
		this.filmActor = filmActor;
	}

}
