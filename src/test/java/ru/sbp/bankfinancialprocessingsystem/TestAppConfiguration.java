package ru.sbp.bankfinancialprocessingsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Класс TestAppConfiguration выполняет Модульное тестирование JUnit
 * конфигурации Spring Boot
 *
 * @author Sergey Proshchaev
 * @version 1.0
 */
@Configuration
public class TestAppConfiguration {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertiesResolver() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
