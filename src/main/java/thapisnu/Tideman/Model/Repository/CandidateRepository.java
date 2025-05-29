package thapisnu.Tideman.Model.Repository;

import org.springframework.data.repository.ListCrudRepository;
import thapisnu.Tideman.Model.Candidate;
import thapisnu.Tideman.Model.Election;

import java.util.List;

public interface CandidateRepository extends ListCrudRepository<Candidate,Integer> {

	public List<Candidate> findByElection(Election election);

	public Candidate findByNameAndElection(String name,Election election);

}