package hello;

import java.util.LinkedList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class WebController implements WebMvcConfigurer {
	
	private final PersonRepository repository;
	private final LoginRepository lrepository;
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }
	
	
	public WebController(PersonRepository r, LoginRepository x) {
		this.repository = r;
		this.lrepository = x;
	}

	
	
	
	@GetMapping("/login")
	public String Home(Model model, LoginForm loginForm) {
		
		

		return "login";
	}
	
	@PostMapping("/login")
	public String addLogin(@ModelAttribute(name="loginForm") LoginForm loginForm, Model model) {
			lrepository.save(loginForm);
		return "redirect:/";
	}
	
	
	
	
	@GetMapping("/")
	public String listAll(Model model, PersonForm personForm) {
		
		
		 model.addAttribute("emptyError", false);	
		model.addAttribute("personList", this.repository.findAllByOrderByIdDesc());

		return "form";
	}

	@PostMapping("/")
	public String addPerson(@ModelAttribute(name="personForm") PersonForm personForm, Model model) {
		
		if(!personForm.getPerson().trim().equals(""))
		{
			this.repository.save(personForm);
		}
		
		else
		{
		    model.addAttribute("emptyError", true);	
			
		}
		
		return "redirect:/";
	}
}


Login (username,password)

login 1
login 2
login 3








