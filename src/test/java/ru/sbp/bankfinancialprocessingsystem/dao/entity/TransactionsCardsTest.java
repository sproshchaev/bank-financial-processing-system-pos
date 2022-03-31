package ru.sbp.bankfinancialprocessingsystem.dao.entity;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Класс TransactionsCardsTest выполняет Модульное тестирование JUnit класса TransactionsCards
 *
 * @author Sergey Proshchaev
 * @version 1.0
 * @see TransactionsCards#Object()
 */
class TransactionsCardsTest {

    /**
     * Метод transactionsCards_Successful_Test() выполняет Модульное тестирование JUnit
     * полей класса TransactionsCards
     */
    @Test
    void transactionsCards_Successful_Test() throws ParseException {
        TransactionsCards transactionsCards = new TransactionsCards(
                1,
                "12345678901234567890",
                new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/01/2022 00:00:00").getTime()),
                "Payment",
                99.99,
                "RUB",
                "000002",
                "010203",
                "4000000000000002");
        String resultExpected = "TransactionsCards{id=1, numberAccount='12345678901234567890', dateTransaction=2022-01-01, operationType='Payment', sumTransaction=99.99, currencyType='RUB', terminalId='000002', codeAuthorization='010203', cardNumber='4000000000000002'}";
        Assert.assertEquals(transactionsCards.toString(), resultExpected);
    }
}