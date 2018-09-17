package literals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Application literals, for example IDs, URI parts, ports...
 * @author Kevin Kassin
 */
public class Literals {
	
	/**
	 * The identifier of this Spring web application
	 */
	public final String App_ID = "Spring2";

	/**
	 * The IP of the cluster the docker running this Spring web application
	 */
	public final String CLUSTER_IP = initialize_cluster_ip();

	/**
	 * The port of the docker running this Spring web application
	 */
	public final String PORT = "30126";
	
	/**
	 * Initializes the cluster ip by reading a file copied into the docker when building it.
	 * @return the cluster ip
	 */
	private String initialize_cluster_ip() {
		File file = new File("cluster_ip.txt");
		BufferedReader br;
		String string, 
		       cluster_ip = ""; 
		try {
			br = new BufferedReader(new FileReader(file));
			while ((string = br.readLine()) != null) cluster_ip = cluster_ip+string; 
			br.close();
		} catch (IOException e) { e.printStackTrace(); }
		return cluster_ip;
	}
}
