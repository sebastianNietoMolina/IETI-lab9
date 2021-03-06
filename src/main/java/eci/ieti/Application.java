package eci.ieti;

import eci.ieti.data.*;
import eci.ieti.data.model.Customer;
import eci.ieti.data.model.Product;

import eci.ieti.data.model.Todo;
import eci.ieti.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");

        customerRepository.deleteAll();

        customerRepository.save(new Customer("Alice", "Smith"));
        customerRepository.save(new Customer("Bob", "Marley"));
        customerRepository.save(new Customer("Jimmy", "Page"));
        customerRepository.save(new Customer("Freddy", "Mercury"));
        customerRepository.save(new Customer("Michael", "Jackson"));

        productRepository.deleteAll();

        productRepository.save(new Product(1L, "Samsung S8", "All new mobile phone Samsung S8"));
        productRepository.save(new Product(2L, "Samsung S8 plus", "All new mobile phone Samsung S8 plus"));
        productRepository.save(new Product(3L, "Samsung S9", "All new mobile phone Samsung S9"));
        productRepository.save(new Product(4L, "Samsung S9 plus", "All new mobile phone Samsung S9 plus"));
        productRepository.save(new Product(5L, "Samsung S10", "All new mobile phone Samsung S10"));
        productRepository.save(new Product(6L, "Samsung S10 plus", "All new mobile phone Samsung S10 plus"));
        productRepository.save(new Product(7L, "Samsung S20", "All new mobile phone Samsung S20"));
        productRepository.save(new Product(8L, "Samsung S20 plus", "All new mobile phone Samsung S20 plus"));
        productRepository.save(new Product(9L, "Samsung S20 ultra", "All new mobile phone Samsung S20 ultra"));

        userRepository.deleteAll();

        User us1 = new User(1L, "sebastian", "seb@mail");
        User us2 = new User(2L, "ayla", "ayla@mail");
        User us3 = new User(3L, "spinneta", "spinneta@mail");
        User us4 = new User(4L, "cerati", "cerati@mail");
        User us5 = new User(5L, "elkin", "elkin@mail");
        User us6 = new User(6L, "manuel", "manuel@mail");
        User us7 = new User(7L, "dusty", "dusty@mail");
        User us8 = new User(8L, "stelvio", "stelvio@mail");
        User us9 = new User(9L, "alicia", "alicia@mail");
        User us10 = new User(10L, "harrison", "harrison@mail");

        userRepository.save(us1);
        userRepository.save(us2);
        userRepository.save(us3);
        userRepository.save(us4);
        userRepository.save(us5);
        userRepository.save(us6);
        userRepository.save(us7);
        userRepository.save(us8);
        userRepository.save(us9);
        userRepository.save(us10);

        todoRepository.deleteAll();

        todoRepository.save(new Todo(1L, "description 1 with a lot bla blab blab bla", 4, new Date(), us1, "pending"));
        todoRepository.save(new Todo(2L, "description 2", 5, new Date(), us1, "pending"));
        todoRepository.save(new Todo(3L, "description 3", 4, new Date(), us1, "pending"));
        todoRepository.save(new Todo(4L, "description 4", 4, new Date(), us2, "pending"));
        todoRepository.save(new Todo(5L, "description 5 with a lot bla blab blab bla", 8, new Date(), us2, "pending"));
        todoRepository.save(new Todo(6L, "description 6 with a lot bla blab blab bla", 4, new Date(), us2, "pending"));
        todoRepository.save(new Todo(7L, "description 7", 4, new Date(), us3, "pending"));
        todoRepository.save(new Todo(8L, "description 8", 3, new Date(), us3, "pending"));
        todoRepository.save(new Todo(9L, "description 9", 6, new Date(), us3, "pending"));
        todoRepository.save(new Todo(10L, "description 10 with a lot bla blab blab bla", 6, new Date(),us1 , "pending"));
        todoRepository.save(new Todo(11L, "description 11", 1, new Date(), us1, "pending"));
        todoRepository.save(new Todo(12L, "description 12 with a lot bla blab blab bla", 2, new Date(), us1, "pending"));
        todoRepository.save(new Todo(13L, "description 13 with a lot bla blab blab bla", 5, new Date(),us1 , "pending"));
        todoRepository.save(new Todo(14L, "description 14", 3, new Date(),us4 , "pending"));
        todoRepository.save(new Todo(15L, "description 15 with a lot bla blab blab bla", 4, new Date(), us1, "pending"));
        todoRepository.save(new Todo(16L, "description 16", 8, new Date(), us10, "pending"));
        todoRepository.save(new Todo(17L, "description 17", 9, new Date(), us10, "pending"));
        todoRepository.save(new Todo(18L, "description 18 with a lot bla blab blab bla", 4, new Date(), us10, "pending"));
        todoRepository.save(new Todo(19L, "description 19", 3, new Date(), us9, "pending"));
        todoRepository.save(new Todo(20L, "description 20", 6, new Date(), us9, "pending"));
        todoRepository.save(new Todo(21L, "description 21", 7, new Date(), us9, "pending"));
        todoRepository.save(new Todo(22L, "description 22", 8, new Date(), us8, "pending"));
        todoRepository.save(new Todo(23L, "description 23", 3, new Date(), us7, "pending"));
        todoRepository.save(new Todo(24L, "description 24", 1, new Date(), us6, "pending"));
        todoRepository.save(new Todo(25L, "description 25", 2, new Date(), us5, "pending"));

        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");

        customerRepository.findAll().stream().forEach(System.out::println);
        System.out.println();

        System.out.println("Creating users");
        System.out.println("-------------------------------");

        userRepository.findAll().stream().forEach(System.out::println);
        System.out.println();

        System.out.println("find a responsable with email seb@mail");
        System.out.println("-------------------------------");

        todoRepository.findByResponsable(us1, PageRequest.of(0, 3)).stream()
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Paginated search of products by criteria:");
        System.out.println("-------------------------------");

        productRepository.findByDescriptionContaining("plus", PageRequest.of(0, 2)).stream()
                .forEach(System.out::println);
        System.out.println();


        System.out.println("Todos where the dueDate has expired");
        System.out.println("-------------------------------");
        Query query = new Query();
        query.addCriteria(Criteria.where("dueDate").lt(new Date().toString()));
        List<Todo> todoList = mongoOperation.find(query, Todo.class);
        for (Todo todo : todoList) {
            System.out.println(todo.toString());
        }
        System.out.println();

        System.out.println("Todos that are assigned to given user and have priority greater equal to 5");
        System.out.println("-------------------------------");
        Query query2 = new Query();
        query2.addCriteria(Criteria.where("priority").gte(5));
        List<Todo> todoList2 = mongoOperation.find(query2, Todo.class);
        for (Todo todo : todoList2) {
            System.out.println(todo.toString());
        }
        System.out.println();

        /**
         System.out.println("Users that have assigned more than 2 Todos");
         System.out.println("-------------------------------");
         Query query3 = new Query();
         query.addCriteria(Criteria.where("dueDate").lt(new Date().toString()));
         List<Todo> todoList3 = mongoOperation.find(query3, Todo.class);
         for(Todo todo: todoList){
         System.out.println(todo.toString());
         }
         System.out.println();
         **/

        System.out.println("Todos that contains a description with a length greater than 30 characters");
        System.out.println("-------------------------------");
        Query query4 = new Query();
        query4.addCriteria(Criteria.where("description").regex("^[A-Za-z0-9\\s$&+,:;=?@#|'<>.^*()%!-]{30,}"));
        List<Todo> todoList4 = mongoOperation.find(query4, Todo.class);
        for (Todo todo : todoList4) {
            System.out.println(todo.toString());
        }
        System.out.println();

        System.out.println("Punto 8");
        System.out.println("-------------------------------");

        System.out.println("Todos where the dueDate has expired");
        System.out.println("-------------------------------");

        List<Todo> todoList1 = (List<Todo>) todoRepository.findAll();
        for(Todo data: todoList1 ){
            if( data.getDueDate().compareTo(new Date()) < 0){
                System.out.println(data.toString());
            }
        }
        System.out.println();
        System.out.println("Todos that are assigned to given user and have priority greater equal to 5");
        System.out.println("-------------------------------");

        for(Todo data: todoList1 ){
            if( data.getPriority()>4){
                System.out.println(data.toString());
            }
        }

        System.out.println();
        System.out.println("Users that have assigned more than 2 Todos");
        System.out.println("-------------------------------");
        int res = 0;
        List<User> userList = userRepository.findAll();
        for(User user: userList){
            res=0;
            for(Todo todo: todoList1){
                if( user.getEmail().equals(todo.getresponsable().getEmail())){
                    res+=1;
                }
            }
            if(res>2){
                System.out.println(user.toString());
            }
        }

        System.out.println();
        System.out.println("Todos that contains a description with a length greater than 30 characters");
        System.out.println("-------------------------------");
        for(Todo todo: todoList1){
            if(todo.getDescription().length()>30){
                System.out.println(todo.toString());
            }
        }

        System.out.println();
    }

}