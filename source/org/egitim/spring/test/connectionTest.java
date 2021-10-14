package org.egitim.spring.test;

import static org.junit.jupiter.api.Assertions.*;

import org.egitim.spring.configuration.ApplicationConfiguration;
import org.egitim.spring.model.data.entity.Actor;
import org.egitim.spring.model.data.entity.Film;
import org.egitim.spring.model.data.entity.FilmActor;
import org.egitim.spring.model.service.ActorService;
import org.egitim.spring.model.service.FilmActorService;
import org.egitim.spring.model.service.FilmService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class connectionTest {

	@Test
	void test() {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		System.out.println(context);

		FilmActorService filmActorService = context.getBean(FilmActorService.class);

		for (FilmActor filmActor : filmActorService.findAll()) {
			System.out.println(filmActor.getActor().shortInfo() + "-------->" + filmActor.getFilm().shortInfo());

		}

	}

}
