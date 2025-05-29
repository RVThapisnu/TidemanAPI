package thapisnu.Tideman.Service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import thapisnu.Tideman.Model.Voter;
import thapisnu.Tideman.Model.Election;
import thapisnu.Tideman.Model.Repository.VoterRepository;
import thapisnu.Tideman.Model.Repository.ElectionRepository;

@Service
public class VoterService {
	private VoterRepository voters;
	private ElectionRepository elections;

	public VoterService(VoterRepository voters,ElectionRepository elections) {
		this.voters = voters;
		this.elections = elections;
	}

	public List<Voter> getVoters(int election_id) {
		Optional<Election> op_elect = elections.findById(election_id);
		if(op_elect.isPresent()) {
			Election election = op_elect.get();
			return voters.findByElection(election);
		}
		return voters.findAll();
	}

	public void addVoter(int election_id,String name) {
		Voter voter = new Voter();
		Optional<Election> op_elect = elections.findById(election_id);
		if(op_elect.isPresent()) {
			Election election = op_elect.get();
			voter.setElection(election);
		}
		voter.setName(name);
		voters.save(voter);
	}

}