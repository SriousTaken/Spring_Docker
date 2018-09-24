package applications.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import literals.Literals;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class RabbidMQController {
	
	/**
	 * Literals of this application, for example IDs, URI parts, ports...
	 */
	Literals literals = new Literals();
	
	private int counter=1;
	
	private final RabbitTemplate rabbitTemplate;
	
	@Autowired
	public RabbidMQController(final RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	@RequestMapping("rabbitMQTest")
	public String rabbitMQTest() {
		rabbitTemplate.convertAndSend(literals.topicExchangeName, "", "Message Nr. " + counter);
		counter++;
		return "Message Nr. " + (counter-1) + " send";
	}
}
