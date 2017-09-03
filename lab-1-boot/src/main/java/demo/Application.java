package demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import demo.domain.Player;
import demo.domain.Team;
import demo.repository.TeamRepository;

@SpringBootApplication
public class Application {

	@Autowired
	private TeamRepository teamRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@PostConstruct
	public void init() {
		List<Team> list = new ArrayList<>();

		/*
	  	Team team = new Team();
	  	team.setLocation("Harlem");
	  	team.setName("Globetrotters");
	  	list.add(team);
	  	
	  	team = new Team();
	  	team.setLocation("Washington");
	  	team.setName("Generals");
	  	list.add(team);
	  	*/
		Set<Player> set = new HashSet<>();
		
		list.add(new Team("Harlem", "Globetrotters", set));
		list.add(new Team("Washington", "Generals", null));

	  	teamRepository.save(list);
	}
}
