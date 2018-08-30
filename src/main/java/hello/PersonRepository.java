package hello;

import java.util.*;

import org.springframework.data.repository.Repository;

public interface PersonRepository extends Repository<PersonForm, Long> {


	//public List<PersonForm> findAll();
	public List<PersonForm> findAllByOrderByIdDesc();
   
	public void save(PersonForm person);
	
}

