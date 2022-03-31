package ru.sbp.bankfinancialprocessingsystem.pos;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Класс PaymentTest выполняет Модульное тестирование JUnit класса Payment
 *
 * @author Sergey Proshchaev
 * @version 1.0
 * @see Payment#Object()
 */
class PaymentTest {

    /**
     * Метод cards_Successful_Test() выполняет Модульное тестирование JUnit
     * полей класса Payment
     */
    @Test
    void payment_Successful_Test() throws ParseException {
        Payment payment = new Payment("4000000000000002",
                "1224",
                new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/01/2022 00:00:00").getTime()),
                99.99,
                "Payment"
        );
        String resultExpected = "Payment{cardNumber='4000000000000002', cardDateExp='1224', dateOperation=2022-01-01, summaTrans=99.99, operationType='Payment'}";
        Assert.assertEquals(payment.toString(), resultExpected);
    }
}