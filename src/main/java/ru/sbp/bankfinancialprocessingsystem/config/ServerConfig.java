package ru.sbp.bankfinancialprocessingsystem.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Класс ServerConfig содержит конфигурацию проекта
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 */
@Configuration
@ComponentScan(basePackages = "ru.sbp.bankfinancialprocessingsystem")
@EnableJpaRepositories(basePackages = "ru.sbp.bankfinancialprocessingsystem.dao.repositories")
@PropertySource(value = {"classpath:application.properties", "classpath:pos.properties"}
        , name = "ss"
        , encoding = "utf-8"
        , ignoreResourceNotFound = true)
public class ServerConfig {

}
