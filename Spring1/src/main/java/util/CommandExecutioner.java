package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Allows to execute bash commands on a docker running a Spring web application
 * @author Kevin Kassin
 */
public class CommandExecutioner {
	
	/**
	 * The command to execute
	 */
	String command = null;
		  
	/**
	 * The directory to execute the command from
	 */
	String directory = null;
	
	/**
	 * Constructor without parameters, command and directory are to be set later
	 */
	public CommandExecutioner() {}
	
	/**
	 * Constructor with parameters, command and directory are to be set immediately
	 * @param command
	 * @param directory
	 */
	public CommandExecutioner(String command, String directory) {
		this.command = command;
		this.directory = directory;
	}
	
	/**
	 * Set method for the command to execute
	 * @param command the command to execute
	 */
	public void setCommand(String command) {
		this.command = command;
	}
	
	/**
	 * Set method for the directory to execute the command from
	 * @param directory the directory to execute the command from
	 */
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	
	/**
	 * Get method for the command to execute
	 * @return the command to execute
	 */
	public String getCommand() {
		return command;
	}
	
	/**
	 * Get method for the directory to execute the command from
	 * @return the directory to execute the command from
	 */
	public String getDirectory() {
		return directory;
	}
	
	/**
	 * Executes and outputs the result of the command by following these steps:<br>
	 * Step 1: Executes the command in a Runtime object<br>
	 * Step 2: Saves the result of the command in a {@link StringBuffer}<br>
	 * Step 3: Output string if command was executed without a failure 
	 * @return the result of the executed command or error messages
	 */
	public String execute() {
		//Step1
		Process process = null;
		try {
			process = Runtime.getRuntime().exec(String.format("sh -c " + command + " %s", directory));
		} catch (IOException e) { e.printStackTrace(); System.err.println("Execution of command " + command + " failed!"); return null;}
		if(process == null) { System.err.println("Process is null!"); return null; }
		//Step 2
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    	StringBuffer stringBuffer = new StringBuffer();
    	String line;
    	try {
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line).append("\n");
			}
		} catch (IOException e1) { e1.printStackTrace(); System.err.println("BufferedReader failed!"); return null;}
    	//Step 3
    	int exitCode;
    	try {
			exitCode = process.waitFor();
		} catch (InterruptedException e) { e.printStackTrace(); return "Process was interrupted!";}
    	assert exitCode == 0;
    	return stringBuffer.toString();
}	}
