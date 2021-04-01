package eci.ieti.data;

import eci.ieti.data.model.Customer;
import eci.ieti.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    User findByName(String name);

    List<Customer> findByEmail(String email);
}
