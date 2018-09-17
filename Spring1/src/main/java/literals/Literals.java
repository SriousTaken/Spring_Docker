package literals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Application literals, for example IDs, URI parts, ports...
 * @author Kevin Kassin
 */
public class Literals {
	
	/**
	 * The identifier of this Spring web application
	 */
	public final String App_ID = "Spring1";

	/**
	 * The IP of the cluster the docker running this Spring web application
	 */
	public final String CLUSTER_IP = initialize_cluster_ip();
	
	/**
	 * The port of the docker running this Spring web application
	 */
	public final String PORT = "30125";
	
	/**
	 * The ports of other dockers running Spring web applications to communicate to, mapped by their identifiers
	 */
	public final Map<String, String> PORTS_COMM_PARTNERS = initialize_ports_comm_partners();
	
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
		
	/**
	 * Initializes the map of ports of other dockers running Spring web applications to communicate to
	 * @return the map of ports of other dockers running Spring web applications to communicate to
	 */
	private Map<String, String> initialize_ports_comm_partners() {
		Map<String, String> port_comm_partners = new HashMap<String, String>();
		//begin: set values
		port_comm_partners.put("Spring2", "30126");
		port_comm_partners.put("Spring3", "30127");
		port_comm_partners.put("Spring4", "30128");
		//end: set values
		return port_comm_partners;
	}
	
}
