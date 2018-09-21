package applications.controller;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import literals.Literals;

/**
 * Provides all Spring web application sites related to health checks
 * @author Kevin Kassin
 */
@RestController
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
	 * Provides a simple message containing the id of the application
	 * @return a simple message containing the id of the application
	 */
	 @RequestMapping(value="/alive", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
	 public String alive() {
		 return literals.App_ID;
	 }
	 
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
