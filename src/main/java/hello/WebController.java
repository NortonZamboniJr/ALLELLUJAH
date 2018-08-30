package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WebController {
	
	private final PersonRepository repository;
	
	public WebController(PersonRepository r) {
		this.repository = r;
	}

	@GetMapping("/")
	public String listAll(Model model, PersonForm personForm) {
		
		
			
		model.addAttribute("personList", this.repository.findAllByOrderByIdDesc());

		return "form";
	}

	@PostMapping("/")
	public String addPerson(@ModelAttribute(name="personForm") PersonForm personForm) {
		
		this.repository.save(personForm);

		return "redirect:/";
	}
}


