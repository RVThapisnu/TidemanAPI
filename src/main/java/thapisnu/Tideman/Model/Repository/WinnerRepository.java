package thapisnu.Tideman.Model.Repository;

import org.springframework.data.repository.ListCrudRepository;
import thapisnu.Tideman.Model.Winner;
import thapisnu.Tideman.Model.Election;

import java.util.List;

public interface WinnerRepository extends ListCrudRepository<Winner,Integer> {

	public Winner findByElection(Election election);

}