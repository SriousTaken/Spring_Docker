package applications.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import literals.Literals;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RestController
public class RabbidMQController {
	
	/**
	 * Literals of this application, for example IDs, URI parts, ports...
	 */
	Literals literals = new Literals();
	
	String lastMessageReceived = "No message received.";
	
	@RabbitListener(queues = "rabbitMQTestQueue")
    public void receiveMessage(String messageReceived) {
		lastMessageReceived = messageReceived;
    }
	
	@RequestMapping("rabbitMQTest")
	public String rabbitMQTest() {
		return lastMessageReceived;
	}
}
