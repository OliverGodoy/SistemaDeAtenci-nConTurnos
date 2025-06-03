package example.persistence.repository;

import example.persistence.entity.LogMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<LogMessage, String> {
}