package thapisnu.Tideman.Service;

import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Arrays;
import java.util.List;

import thapisnu.Tideman.Model.Winner;
import thapisnu.Tideman.Model.Election;
import thapisnu.Tideman.Model.Repository.WinnerRepository;
import thapisnu.Tideman.Model.Repository.ElectionRepository;
import thapisnu.Tideman.Model.Voter;
import thapisnu.Tideman.Model.Candidate;
import thapisnu.Tideman.Model.Votes;
import thapisnu.Tideman.Model.Repository.VoterRepository;
import thapisnu.Tideman.Model.Repository.CandidateRepository;
import thapisnu.Tideman.Model.Repository.VotesRepository;

import thapisnu.Tideman.VotingSystem;

@Service
public class WinnerService {
	private WinnerRepository winners;
	private ElectionRepository elections;
	private CandidateRepository candidates;
	private VoterRepository voters;
	private VotesRepository votes;
	private VotingSystem voting;

	public WinnerService(
		WinnerRepository winners,
		ElectionRepository elections,
		CandidateRepository candidates,
		VoterRepository voters,
		VotesRepository votes,
		VotingSystem voting
		) {
		this.winners = winners;
		this.elections = elections;
		this.candidates = candidates;
		this.voters = voters;
		this.votes = votes;
		this.voting = voting;
	}

	public Winner getWinners(int election_id) {

		Optional<Election> op = elections.findById(election_id);

		return winners.findByElection(op.get());
	}

	public void calculateWinner(Election election) {
		String[] cands = getCands(election);
		String[][] votes_ar = getVotes(election,cands.length);

		voting.setCandidates(cands);
		voting.setVoters(votes_ar);

		String winner = voting.findWinner();
		Candidate cand = candidates.findByNameAndElection(winner,election);

		Winner win = new Winner();

		win.setElection(election);
		win.setCandidate(cand);

		winners.save(win);
	}

	private String[][] getVotes(Election election,int cands_size) {
		List<Voter> voter_list = voters.findByElection(election);
		String[][] prefs = new String[voter_list.size()][cands_size];
		int count = 0;
		for(Voter v : voter_list) {
			List<Votes> votes_list = votes.findByVoter(v);
			for(Votes v2 : votes_list) {
				prefs[count][v2.getRank() - 1] = v2.getCandidate().getName();
			}
			count ++;
		}
		return prefs;
	};

	private String[] getCands(Election election) {
		List<Candidate> cands_list = candidates.findByElection(election);
		String[] cands = new String[cands_list.size()];
		int count = 0;
		for(Candidate c : cands_list) {
			cands[count] = c.getName();
			count ++;
		}
		return cands;
	};

}