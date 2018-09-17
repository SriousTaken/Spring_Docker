package applications.controller;

import java.io.IOException;

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
	 * @return html code of the index page of the Spring web application 
	 * @throws IOException 
	 */
	@GetMapping("/")
    public String index(Model model) {
		model.addAttribute("app_id",literals.App_ID);
		model.addAttribute("address", literals.CLUSTER_IP + ":" + literals.PORT);
		return "start";
	}
}
