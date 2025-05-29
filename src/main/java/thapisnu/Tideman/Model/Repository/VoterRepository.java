package thapisnu.Tideman.Model.Repository;

import org.springframework.data.repository.ListCrudRepository;
import thapisnu.Tideman.Model.Voter;
import thapisnu.Tideman.Model.Election;

import java.util.List;

public interface VoterRepository extends ListCrudRepository<Voter,Integer> {

	public List<Voter> findByElection(Election election);

}