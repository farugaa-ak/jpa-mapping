package com.example.hibernatejpa;

import com.example.hibernatejpa.model.manytomany.Employee;
import com.example.hibernatejpa.model.manytomany.Meeting;
import com.example.hibernatejpa.model.onetomany.Product;
import com.example.hibernatejpa.model.onetomany.ShoppingCart;
import com.example.hibernatejpa.model.onetoone.Adress;
import com.example.hibernatejpa.model.onetoone.Contact;
import com.example.hibernatejpa.model.onetoone.User;
import com.example.hibernatejpa.repository.EmployeeRepository;
import com.example.hibernatejpa.repository.MeetingRepository;
import com.example.hibernatejpa.repository.ProductRepository;
import com.example.hibernatejpa.repository.ShoppingCartRepository;
import com.example.hibernatejpa.repository.UserRepository;
import com.example.hibernatejpa.service.EmployeeMeetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class HibernateJpaApplication {


    private static final Logger log = LoggerFactory.getLogger(HibernateJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(HibernateJpaApplication.class, args);
    }

    @Autowired
    MeetingRepository meetingRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeMeetingService employeeMeetingService;

    @Bean
    @Transactional
    public CommandLineRunner demo(ShoppingCartRepository shoppingCartRepository, UserRepository userRepository, ProductRepository productRepository) {
        return (args) -> {


            ShoppingCart shoppingCart = new ShoppingCart("karta zakupowa 1");

            Product product = new Product("produkt 1", shoppingCart);
            Product product2 = new Product("maslo ", shoppingCart);
            Product product3 = new Product("mleko", shoppingCart);
            Set<Product> products = new HashSet<Product>();
            products.add(product);
            products.add(product2);
            products.add(product3);
            shoppingCart.setProducts(products);


            shoppingCartRepository.save(shoppingCart);
            log.info("==========");
            productRepository.save(products);
            log.info("==========");


            ShoppingCart shoppingCart2 = new ShoppingCart("sc2");
            Set<Product> products2 = new HashSet<Product>() {{
                add(new Product("p99", shoppingCart2));
                add(new Product("p88", shoppingCart2));
                add(new Product("p77", shoppingCart2));
            }};
            shoppingCart2.setProducts(products2);

            shoppingCartRepository.save(shoppingCart2);

            shoppingCart2.setName("sc222");


            User user = new User("Witek");
            Adress adress = new Adress("Krakow", user);
            Contact contact = new Contact("email", "9012839012");
            user.setContact(contact);
            user.setAdress(adress);

            userRepository.save(user);

            log.info("userSize={}", userRepository.findAll().size());
            user.setName("asdfasd");


            userRepository.findAll().forEach(user1 -> log.info("user={}", user1));

            ShoppingCart sc1 = shoppingCartRepository.findByName("karta zakupowa 1");
            log.info("sc name={} id={}", sc1.getName(), sc1.getId());


            log.info("====================ManyToMany");

            Meeting meeting1 = new Meeting("meeting1");
            Meeting meeting2 = new Meeting("meeting2");

            Employee employee1 = new Employee("E1", "EE1");
            Employee employee2 = new Employee("E2", "EE2");

            employee1.addMeeting(meeting1);
            employee1.addMeeting(meeting2);
            employee2.addMeeting(meeting2);

            meetingRepository.save(meeting1);
            meetingRepository.save(meeting2);

            employeeRepository.save(employee1);
            employeeRepository.save(employee2);


            employeeMeetingService.logAllEmployees();
            employeeMeetingService.logAllMeetings();


        };

    }
}
