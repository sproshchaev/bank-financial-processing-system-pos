package ru.sbp.bankfinancialprocessingsystem.dao.entity;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.CardStatusType;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.PaymentSystemType;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Класс CardsTest выполняет Модульное тестирование JUnit класса Cards
 *
 * @author Sergey Proshchaev
 * @version 1.0
 * @see Cards#Object() // ru.sbp.bankfinancialprocessingsystem.dao.entity
 */
class CardsTest {

    /**
     * Метод cards_Successful_Test() выполняет Модульное тестирование JUnit
     * полей класса Cards
     */
    @Test
    void cards_Successful_Test() throws ParseException {
        Cards cards = new Cards("4000000000000002",
                "12345678901234567890",
                new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/01/2022 00:00:00").getTime()),
                "PETROV IVAN",
                PaymentSystemType.VISA,
                CardStatusType.Valid
        );
        String resultExpected = "Cards{cardNumber='4000000000000002', numberAccount='12345678901234567890', expirationDate=2022-01-01, cardHolderName='PETROV IVAN', paymentSystem=VISA, cardStatus=Valid}";
        Assert.assertEquals(cards.toString(), resultExpected);

    }
}