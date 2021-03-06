package applications.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import literals.Literals;

/**
 * Provides index site of the Spring web application
 * @author Kevin Kassin
 */
@Controller
public class IndexController {

	/**
	 * Literals of this application, for example IDs, URI parts, ports...
	 */
	Literals literals = new Literals();
	
	/**
	 * Defines the index page of the Spring web application
	 * @return reference to the html template of the index page of the Spring web application 
	 */
	@GetMapping("/")
    public String index(Model model) {
		model.addAttribute("app_id",literals.App_ID);
		return "start";
	}
}
