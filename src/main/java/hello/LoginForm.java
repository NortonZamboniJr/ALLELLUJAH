package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.web.bind.annotation.ModelAttribute;


@Entity
public class LoginForm {

    @NotNull
    @Size(min=1, max=180)
    private String login;
	private String password;
	
     @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NotNull    
    private Long id;
    
    protected LoginForm() {}
    
    public LoginForm(String login, String password) {
    	this.login = login;
		this.password = password;
    }
    
	  public String getPassword() {
        return this.password;
    }
	
	
    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String toString() {
        return "Login: " + this.login;
    }
}

