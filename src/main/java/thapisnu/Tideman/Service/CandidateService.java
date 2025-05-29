package thapisnu.Tideman.Service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import thapisnu.Tideman.Model.Candidate;
import thapisnu.Tideman.Model.Election;
import thapisnu.Tideman.Model.Repository.ElectionRepository;
import thapisnu.Tideman.Model.Repository.CandidateRepository;

@Service
public class CandidateService {
	private CandidateRepository candidates;
	private ElectionRepository elections;

	public CandidateService(CandidateRepository candidates,ElectionRepository elections) {
		this.candidates = candidates;
		this.elections = elections;
	}

	public List<Candidate> getCandidates(int el_id) {
		Election election = getElection(el_id);
		return candidates.findByElection(election);
	}

	public void addCandidate(int el_id,String name) {
		Election election = getElection(el_id);
		Candidate candidate = new Candidate();
		candidate.setName(name);
		candidate.setElection(election);
		candidates.save(candidate);
	}

	private Election getElection(int el_id) {
		Optional<Election> op_el = elections.findById(el_id);
		Election election = new Election();
		if(op_el.isPresent()) {
			election = op_el.get();
		}
		return election;
	}

}