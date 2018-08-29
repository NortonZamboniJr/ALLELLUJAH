package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.web.bind.annotation.ModelAttribute;


@Entity
public class PersonForm {

    @NotNull
    @Size(min=2, max=30)
    private String person;

     @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NotNull    
    private Long id;
    
    protected PersonForm() {}
    
    public PersonForm(String person) {
    	this.person = person;
    }
    
    public String getPerson() {
        return this.person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String toString() {
        return "Person: " + this.person;
    }
}

