package hello;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface PersonRepository extends Repository<PersonForm, Long> {

	public List<PersonForm> findAll();
	
	public void save(PersonForm person);
}

