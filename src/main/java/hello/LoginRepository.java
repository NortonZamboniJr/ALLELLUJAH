package hello;

import java.util.*;

import org.springframework.data.repository.Repository;

public interface LoginRepository extends Repository<LoginForm, Long> {



	public List<LoginForm> findAll();
   
	public void save(LoginForm login);
	
}

