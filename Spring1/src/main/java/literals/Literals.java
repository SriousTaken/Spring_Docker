package literals;

import java.util.ArrayList;
import java.util.List;

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
	 * The internal port services are published to
	 */
	public final String INTERNAL_SERVICE_PORT = "8080";
				
	/**
	 * The identifiers of Spring web applications to communicate to
	 */
	public final List<String> COMM_PARTNERS = initialize_comm_partners();
			
	/**
	 * Initializes the list of identifiers of Spring web applications to communicate to
	 * @return the map of ports of other dockers running Spring web applications to communicate to
	 */
	private List<String> initialize_comm_partners() {
		List<String> comm_partners = new ArrayList<String>();
		//begin: set values
		comm_partners.add("Spring2");
		comm_partners.add("Spring3");
		comm_partners.add("Spring4");
		//end: set values
		return comm_partners;
	}
	
	/**
	 * Identifier of the Spring web application answering ping pong requests
	 */
	public final String PING_PONG_PARTNER = COMM_PARTNERS.get(0);
	
}
