package cz.cvut.fit.tjv.semproject.server;

import cz.cvut.fit.tjv.semproject.server.entities.DirectionEntity;
import cz.cvut.fit.tjv.semproject.server.services.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL) // this is for links in http api
public class ServerApplication {
	@Autowired
	private DirectionService directionService;

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void afterStartup() {
		Page<DirectionEntity> res = directionService.readAll(Pageable.unpaged());
		DirectionEntity client = new DirectionEntity();
		System.out.println("Hello!");
	}
}
