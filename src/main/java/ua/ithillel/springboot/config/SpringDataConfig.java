package ua.ithillel.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"ua.ithillel.springboot.repo"})
public class SpringDataConfig {
}
