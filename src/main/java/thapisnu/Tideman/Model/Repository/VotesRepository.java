package thapisnu.Tideman.Model.Repository;

import org.springframework.data.repository.ListCrudRepository;
import thapisnu.Tideman.Model.Votes;
import thapisnu.Tideman.Model.Voter;

import java.util.List;

public interface VotesRepository extends ListCrudRepository<Votes,Integer> {

	public List<Votes> findByVoter(Voter voter);

}