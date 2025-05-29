package thapisnu.Tideman.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

import thapisnu.Tideman.Model.Votes;
import thapisnu.Tideman.Model.Candidate;

import thapisnu.Tideman.Service.VotesService;

@RestController
@RequestMapping("votes/{voter_id}")
public class VotesController {

	private VotesService votes;

	public VotesController(VotesService votes) {
		this.votes = votes;
	}

	@GetMapping()
	public List<Votes> get(@PathVariable int voter_id) {
		return votes.getVotes(voter_id);
		//return Streamable.of(votes.getVotes(voter_id)).toList().toArray(new Votes[0]);
	}

	@PostMapping("/{rank}")
	public void post(@PathVariable int voter_id,@PathVariable int rank,@RequestBody Candidate cand) {
		votes.addVote(voter_id,rank,cand);
	}

}