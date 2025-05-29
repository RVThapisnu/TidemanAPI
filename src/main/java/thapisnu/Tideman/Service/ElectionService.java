package thapisnu.Tideman.Service;

import org.springframework.stereotype.Service;
import java.util.List;

import thapisnu.Tideman.Model.Election;
import thapisnu.Tideman.Model.Repository.ElectionRepository;

@Service
public class ElectionService {
	private ElectionRepository elections;

	public ElectionService(ElectionRepository elections) {
		this.elections = elections;
	}

	public List<Election> getElections() {
		return elections.findAll();
	}

	public void addElection(String name) {
		Election election = new Election();
		election.setName(name);
		elections.save(election);
	}

	public void updateElection(Election election) {
		elections.save(election);
	}

	public void deleteElection(Election election) {
		elections.deleteById(election.getId());
	}
}