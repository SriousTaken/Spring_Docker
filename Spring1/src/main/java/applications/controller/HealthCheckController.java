package applications.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import literals.Literals;

/**
 * Provides all Spring web application sites related to health checks
 * @author Kevin Kassin
 */
@Controller
public class HealthCheckController {
	
	/**
	 * Literals of this application, for example IDs, URI parts, ports...
	 */
	Literals literals = new Literals();
	
	/**
	 * Pings to the Spring web application Spring2 to get a pong answer
	 * @return Reference to a html template containing a string representing the answer of Spring web application Spring2
	 */
	@GetMapping("/ping")
    public String ping(Model model) {
		String pingPongPartner = "http://" + literals.CLUSTER_IP+ ":" + literals.PORTS_COMM_PARTNERS.get("Spring2") + "/pong";
    	RestTemplate restTemplate = new RestTemplate();
    	model.addAttribute("message", restTemplate.getForObject(pingPongPartner, String.class));	
    	return "ping";
    }
    
	/**
	 * Iterates over the potencial communication partners and tries to reach them to check if they are alive. 
	 * @return Reference to a html template containing which communication partners are alive and which not 
	 */
	@GetMapping("/alive")
	 public String alive(Model model) {
		List<String> alive = new ArrayList<String>(),
					 dead = new ArrayList<String>();
		RestTemplate restTemplate = new RestTemplate();
		String address_comm_partner;
		for(String key_comm_partner : literals.PORTS_COMM_PARTNERS.keySet()) {
			address_comm_partner = "http://" + literals.CLUSTER_IP + ":" + literals.PORTS_COMM_PARTNERS.get(key_comm_partner) + "/alive";
			try {
				alive.add(restTemplate.getForObject(address_comm_partner, String.class));
			} catch(ResourceAccessException e) {
				dead.add(key_comm_partner);
			}
		}
		model.addAttribute("alive", alive);
		model.addAttribute("dead", dead);
		return "alive";
	 }
}
