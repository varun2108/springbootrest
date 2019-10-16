package com.in28minutes.springboot.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory
            .getLogger(UserCommandLineRunner.class);

    @Autowired
    private UserRepository repository;

    

	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.save(new User("Ranga", "Admin"));
        repository.save(new User("Ravi", "User"));
        repository.save(new User("Satish", "Admin"));
        repository.save(new User("Raghu", "User"));

        log.info("-------------------------------");
        log.info("Finding all users");
        log.info("-------------------------------");
        for (User user : repository.findAll()) {
            log.info(user.toString());
            
            log.info("-------------------------------");
            log.info("Finding user with id 1");
            log.info("-------------------------------");
            User user1 = repository.findOne(1L);
            log.info(user1.toString());

            log.info("-------------------------------");
            log.info("Finding all Admins");
            log.info("-------------------------------");
            for (User admin : repository.findByRole("Admin")) {
                log.info(admin.toString());
                // Do something...
            }

	}

}
}