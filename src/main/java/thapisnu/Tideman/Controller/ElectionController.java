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
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

import thapisnu.Tideman.Service.ElectionService;
import thapisnu.Tideman.Model.Election;

@RestController
@CrossOrigin(origins="localhost:8080")
@RequestMapping("/elections")
public class ElectionController {

	private ElectionService elections;

    public ElectionController(ElectionService elections) {
		this.elections = elections;
    }

    @GetMapping()
	public List<Election> show() {
        return elections.getElections();
    }

	@PostMapping()
    public String add(@RequestBody String name) {
		elections.addElection(name);
		return name + " Added Successfully !!";
    }

    @PutMapping()
    public String update(@RequestBody Election election) {
		elections.updateElection(election);
		return election.getName() + " Updated Successfully !! ";
    }

    @DeleteMapping()
    public String delete(@RequestBody Election election) {
		elections.deleteElection(election);
		return election.getName() + " Deleted Successfully !! ";
    }
}