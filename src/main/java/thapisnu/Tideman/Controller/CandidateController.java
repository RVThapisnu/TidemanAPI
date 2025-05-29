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

import thapisnu.Tideman.Service.CandidateService;
import thapisnu.Tideman.Model.Candidate;

@RestController
@RequestMapping("/candidates/{election_id}")
public class CandidateController {

	private CandidateService candidates;

    public CandidateController(CandidateService candidates) {
		this.candidates = candidates;
    }

    @GetMapping()
	public List<Candidate> show(@PathVariable int election_id) {
        return candidates.getCandidates(election_id);
    }

    @PostMapping()
    public String add(@PathVariable int election_id,@RequestBody List<String> names) {
		for(String name : names) {
			candidates.addCandidate(election_id,name);
		}
		return names + "Added Successfully";
    }

}