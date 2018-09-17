package applications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Defines a Spring web application using Rest calls
 * @author Kevin Kassin
 */
@SpringBootApplication
public class Application {

	/**
	 * Runs the Spring web application
	 */
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}