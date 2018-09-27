package applications.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import applications.mongodb.DB_String;
import applications.mongodb.UsersRepository;
import exceptions.NoIdFoundException;

/**
 * Provides all Spring web application sites related to the MongoDB database
 * @author Kevin Kassin
 */
@RestController
@RequestMapping("/mongodb")
public class MongoDBController {
	
	/**
	 * Safety limit for searching an unused id
	 */
	int id_limit = 10000;
	
	/**
	 * Reference to the interface to the underlying database
	 */
	@Autowired
	UsersRepository repository;
	
	/**
	 * Gets all database elements
	 * @return String representing the result of the database operation
	 */
	@RequestMapping("/findall")
    public String findAll() {
		String result = "";
		for(DB_String db_string : repository.findAll()) result=result+db_string.toString() + "\n";  
		return result;
	}
	
	/**
	 * Instruction page to the operation {@link #findById}
	 * @return String giving instruction how to use operation {@link #findById}
	 */
	@RequestMapping("/findbyid/")
    public String findByIdInstruction() {
		return "Input the id to search the database element for in the URL in the form of .../mongodb/findbyid/{id}!";
	}
	
	/**
	 * Get one specific database element dependent on the given id
	 * @param id the id of the database element to get 
	 * @return String representing the result of the database operation
	 */
	@RequestMapping("/findbyid/{id}")
    public String findById(@PathVariable int id) {
		return repository.findById(id).toString();
	}
	
	/**
	 * Instruction page to the operation {@link #add}
	 * @return String giving instruction how to use operation {@link #add}
	 */
	@RequestMapping("/add")
    public String addInstruction() {
		return "Input the string to add to the database in the URL in the form of .../mongodb/add/{string}!";
	}
	
	/**
	 * Adds an element to the database
	 * @param string The string to add to the database
	 * @return if the operation was successful
	 */
	@RequestMapping("/add/{string}")
    public String add(@PathVariable String string) {
		int id = getUnusedId(); 
		DB_String new_db_string = new DB_String(id, string);
		repository.save(new_db_string);
		return "Added the following element: " + new_db_string.toString();
	}
	
	/**
	 * Instruction page to the operation {@link #deleteById}
	 * @return String giving instruction how to use operation {@link #deleteById}
	 */
	@RequestMapping("/deletebyid")
    public String deleteByIdInstruction() {
		return "Input the id to delete the database element for in the URL in the form of .../mongodb/deletebyid/{id}!";
	}
	
	/**
	 * Deletes an element from the database
	 * @param id the id of the database element to delete
	 * @return if the operation was successful
	 */
	@RequestMapping("/deletebyid/{id}")
    public String deleteById(@PathVariable int id) {
		Optional<DB_String> db_string = repository.findById(id);
		if(db_string.isPresent()) {
			repository.deleteById(id);
			return "Deleted the following element: " + db_string.toString();
		} else {
			return "There is no element associated to this id.";	
		}
	}
	
	/**
	 * Deletes all elements from the database
	 * @return if the operation was successful
	 */
	@RequestMapping("/deleteall")
    public String deleteAll() {
		repository.deleteAll();
		return "Cleared the database.";
	}
	
	/**
	 * Gets an unused id for a newly added database element
	 * @return an used id for a newly added database element or throws an exception if not possible
	 */
	private Integer getUnusedId() {
		List<Integer> used_ids = new ArrayList<Integer>();
		for(DB_String db_string : repository.findAll()) used_ids.add(db_string.getId());
		for(int i = 0; i<id_limit; i++) if(!used_ids.contains(i)) return i; 
		throw new NoIdFoundException();
	};
}
