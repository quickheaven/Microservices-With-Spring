package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.Team;
import demo.repository.TeamRepository;

//@RestController
public class TeamController {

	/*
	@RequestMapping("/teams")
	public List<Team> getTeams() {
		List<Team> list = new ArrayList<>();
		
		Team team = new Team();
		team.setId(0l);
		team.setLocation("Harlem");
		team.setName("Globetrotters");
		list.add(team);

		team = new Team();
		team.setId(1l);
		team.setLocation("Washington");
		team.setName("Generals");
		list.add(team);
		
		
		return list;
	}
	*/
	
	@Autowired
	private TeamRepository teamRepository;
	
	@RequestMapping("/teams")
	public Iterable<Team> getTeams() {
		return teamRepository.findAll();
				
	}
	
	@RequestMapping("/team/{id}")
	public Team getTeam(@PathVariable Long id) {
		return teamRepository.findOne(id);
	}
	
	
}
