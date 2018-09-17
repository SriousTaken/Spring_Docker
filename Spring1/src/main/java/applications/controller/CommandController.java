package applications.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import literals.Literals;
import util.CommandExecutioner;

/**
 * Provides all Spring web application sites related to commands
 * @author Kevin Kassin
 */
@RestController
public class CommandController {
	
	/**
	 * Literals of this application, for example IDs, URI parts, ports...
	 */
	Literals literals = new Literals();
	
	 /**
     * Executes a ls command on the docker the Spring web application is running on
     * @return String representing the result of the ls command
     */
    @RequestMapping("/command_fix")
    public String command() {
    	CommandExecutioner commandExecutioner = new CommandExecutioner("ls", System.getProperty("user.home"));
    	return commandExecutioner.execute();
    }
    
    /**
     * @return Gives an instruction on how to use the command input features
     */
    @RequestMapping("/command_input")
    public String command_input_instruction() {
    	return "Input your command to execute in the URL in the form of .../command_input/{command}!";
    }
    
    /**
     * Executes a command given by the user on the on the docker the Spring web application is running on
     * @return String representing the result of the executed command
     */
    @RequestMapping("/command_input/{command}")
    public String command_input(@PathVariable String command) {
    	CommandExecutioner commandExecutioner = new CommandExecutioner(command, System.getProperty("user.home"));
    	return commandExecutioner.execute();
    }

}
