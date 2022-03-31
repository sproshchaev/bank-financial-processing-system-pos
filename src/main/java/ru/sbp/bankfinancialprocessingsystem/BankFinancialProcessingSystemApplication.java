package ru.sbp.bankfinancialprocessingsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Класс BankFinancialProcessingSystemApplication является точкой входа в проект
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 */

@SpringBootApplication
public class BankFinancialProcessingSystemApplication {

    private static final Logger logger = LoggerFactory.getLogger(BankFinancialProcessingSystemApplication.class);

    public static void main(String[] args) {

        logger.info("BankFinancialProcessingSystemApplication run...");
        SpringApplication.run(BankFinancialProcessingSystemApplication.class, args);
    }
}