package ru.sbp.bankfinancialprocessingsystem.dao.entity;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.CurrencyType;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.OperationType;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Класс TransactionsTest выполняет Модульное тестирование JUnit класса Transactions
 *
 * @author Sergey Proshchaev
 * @version 1.0
 * @see Transactions#Object()
 */
class TransactionsTest {

    /**
     * Метод transactions_Successful_Test()  выполняет Модульное тестирование JUnit
     * полей класса Transactions
     */
    @Test
    void transactions_Successful_Test() throws ParseException {
        Transactions transactions = new Transactions(
                1,
                "12345678901234567890",
                new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/01/2022 00:00:00").getTime()),
                OperationType.Payment,
                99.99,
                CurrencyType.RUB,
                "000002",
                "010203");
        String resultExpected = "Transactions{id=1, numberAccount='12345678901234567890', dateTransaction=2022-01-01, operationType=Payment, sumTransaction=99.99, currencyType=RUB, terminalId='000002', codeAuthorization='010203'}";
        Assert.assertEquals(transactions.toString(), resultExpected);
    }
}