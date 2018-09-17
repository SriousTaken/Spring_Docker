package applications.controller;

import org.springframework.http.MediaType;
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
	 * Literals of this application, for example IDs, URI parts, ports...
	 */
	Literals literals = new Literals();
	
	/**
	 * Provides the a simple "pong" message to check for availability of the docker running the Springweb application
	 * @return a simple "pong" message
	 */
	 @RequestMapping(value="/pong", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
	 public String pong() {
		 return "Pong!";
	 }
	 
	 /**
	  * Provides a simple message containing the id of the application
	  * @return a simple message containing the id of the application
	  */
	 @RequestMapping(value="/alive", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
	 public String alive() {
		 return literals.App_ID;
	 }
}
