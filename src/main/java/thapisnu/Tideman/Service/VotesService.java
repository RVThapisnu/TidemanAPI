package thapisnu.Tideman.Service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import thapisnu.Tideman.Model.Votes;
import thapisnu.Tideman.Model.Voter;
import thapisnu.Tideman.Model.Candidate;
import thapisnu.Tideman.Model.Repository.VotesRepository;
import thapisnu.Tideman.Model.Repository.VoterRepository;

@Service
public class VotesService {

	private VotesRepository votes;
	private VoterRepository voters;

	public VotesService(
		VotesRepository votes,
		VoterRepository voters
	) {
		this.votes = votes;
		this.voters = voters;
	}

	public void addVote(int voter_id,int rank,Candidate candidate) {

		Votes vote = new Votes();
		Optional<Voter> op = voters.findById(voter_id);

		if(op.isPresent()) {
			Voter voter = op.get();
			vote.setVoter(voter);
		}

		vote.setRank(rank);
		vote.setCandidate(candidate);

		votes.save(vote);
	}

	public List<Votes> getVotes(int voter_id) {

		Optional<Voter> op = voters.findById(voter_id);

		if(op.isPresent()) {
			Voter voter = op.get();
			return votes.findByVoter(voter);
		}

		return votes.findAll();

	}

}