package thapisnu.Tideman.Model.Repository;

import org.springframework.data.repository.ListCrudRepository;
import thapisnu.Tideman.Model.Election;

public interface ElectionRepository extends ListCrudRepository<Election,Integer> {}