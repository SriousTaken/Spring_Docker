package applications.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DB_String {
	
	@Id
	private Integer id;
	private String string;
	
	public DB_String(Integer id, String string) {
		this.id = id;
		this.string = string;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setString(String string) {
		this.string = string;
	}
	
	public String getString() {
		return string;
	}
	
	@Override
	public String toString() {
		return "{" + id + "," + string + "}";
	}
	
}
