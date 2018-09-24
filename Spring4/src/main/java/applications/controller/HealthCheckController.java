package applications.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import literals.Literals;

/**
 * Provides all Spring web application sites related to health checks as {@link Controller}
 * @author Kevin Kassin
 */
@Controller
public class HealthCheckController {
	
	/**
	 * time since this class was constructed
	 */
	long time_started;
	
	/**
	 * constructor
	 */
	public HealthCheckController() {
		time_started = System.nanoTime();
	}
	
	/**
	 * Literals of this application, for example IDs, URI parts, ports...
	 */
	Literals literals = new Literals();
		 
	 /**
	  * Health check by kubernetes
	  * @return Reference to a html template containing a message that the server is alive
	  */
	@GetMapping("/healthz")
	public String healthz(Model model) {
		long time_now = System.nanoTime();
		long time_elapsed_seconds = (time_now-time_started)/1000000000;
		model.addAttribute("app_id",literals.App_ID);
		model.addAttribute("time_elapsed", time_elapsed_seconds);
		return "healthz";
	}
}
