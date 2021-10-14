package org.egitim.spring.model.data.entity;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 4371861923482927836L;
	
	
	private Date lastUpdate;
	



	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update", nullable = false)
	public Date getlastUpdate() {
		return lastUpdate;
	}

	public void setlastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	
	@Transient
	public abstract String shortInfo();
	
	
	
	

}
