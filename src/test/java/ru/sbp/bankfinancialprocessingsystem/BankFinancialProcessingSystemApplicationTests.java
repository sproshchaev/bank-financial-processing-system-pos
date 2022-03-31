package ru.sbp.bankfinancialprocessingsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * Класс BankFinancialProcessingSystemApplicationTests выполняет Модульное тестирование JUnit
 * класса BankFinancialProcessingSystemApplication
 *
 * @author Sergey Proshchaev
 * @version 1.0
 * @see BankFinancialProcessingSystemApplication#Object()
 */
@SpringBootTest
@ContextConfiguration(classes = ru.sbp.bankfinancialprocessingsystem.TestAppConfiguration.class)
class BankFinancialProcessingSystemApplicationTests {

    @Test
    void contextLoads() {
    }

}
