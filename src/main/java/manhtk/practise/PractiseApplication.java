package manhtk.practise;

import manhtk.practise.service.PhoneService;
import manhtk.practise.service.PhoneServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@EnableSpringDataWebSupport
@ComponentScan("manhtk.practise.controller")
@EntityScan("manhtk.practise.model")
@EnableJpaRepositories("manhtk.practise.repository")
public class PractiseApplication {

    @Bean
    public PhoneService phoneService(){
        return new PhoneServiceImpl();
    }

    public static void main(String[] args) {
        SpringApplication.run(PractiseApplication.class, args);
    }

}
