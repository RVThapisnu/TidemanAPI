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

import thapisnu.Tideman.Service.ElectionService;
import thapisnu.Tideman.Model.Election;
import thapisnu.Tideman.Service.VoterService;
import thapisnu.Tideman.Model.Voter;

@RestController
@RequestMapping("/voters/{election_id}")
public class VoterController {

	private VoterService voters;
	private ElectionService elections;

    public VoterController(VoterService voters,ElectionService elections) {
		this.elections = elections;
		this.voters = voters;
    }

    @GetMapping()
	public List<Voter> show(@PathVariable int election_id) {
        return voters.getVoters(election_id);
    }

	@PostMapping()
    public String add(@PathVariable int election_id,@RequestBody List<String> name) {
		for(String n:name) {
			voters.addVoter(election_id,n);
		}
		return name + " Added Successfully !!";
    }

}