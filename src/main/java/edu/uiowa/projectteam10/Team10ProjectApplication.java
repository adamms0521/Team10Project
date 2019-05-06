package edu.uiowa.projectteam10;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("edu.uiowa.projectteam10")
@EnableJpaRepositories("edu.uiowa.projectteam10")
public class Team10ProjectApplication{

    public static void main(String[] args) {
        SpringApplication.run(Team10ProjectApplication.class, args);
    }

}