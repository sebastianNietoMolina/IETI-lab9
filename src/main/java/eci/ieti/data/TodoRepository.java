package eci.ieti.data;

import eci.ieti.data.model.Todo;
import eci.ieti.data.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    Page<Todo> findByResponsable(User responsable, Pageable pageable);

}
