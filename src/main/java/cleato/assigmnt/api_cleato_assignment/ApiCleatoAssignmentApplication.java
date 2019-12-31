package cleato.assigmnt.api_cleato_assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class ApiCleatoAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiCleatoAssignmentApplication.class, args);
    }

}
