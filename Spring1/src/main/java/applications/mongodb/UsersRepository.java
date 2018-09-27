package applications.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<DB_String, Integer> {

	
}
