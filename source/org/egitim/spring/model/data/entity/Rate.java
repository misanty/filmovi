package org.egitim.spring.model.data.entity;

public enum Rate {
	NONE(0),
	ONE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5);
	
	private int rating;
	Rate(int rating) {
		this.rating = rating;
	}
	
public int asRating() {
	return rating;
}
}
