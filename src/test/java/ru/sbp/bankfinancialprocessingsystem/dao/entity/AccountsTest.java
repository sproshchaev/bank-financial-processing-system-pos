package ru.sbp.bankfinancialprocessingsystem.dao.entity;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.AccountType;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.CurrencyType;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Класс AccountsTest выполняет Модульное тестирование JUnit класса Accounts
 *
 * @author Sergey Proshchaev
 * @version 1.0
 * @see Accounts#Object()
 */
class AccountsTest {

    /**
     * Метод accounts_Successful_Test() выполняет Модульное тестирование JUnit
     * полей класса Accounts
     */
    @Test
    void accounts_Successful_Test() throws ParseException {

        Accounts accounts = new Accounts("12345678901234567890",
                "mail@mail.ru",
                false,
                new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/01/2022 00:00:00").getTime()),
                CurrencyType.RUB,
                1.99,
                AccountType.Card,
                null);

        String resultExpected = "Accounts{numberAccount='12345678901234567890', userLogin='mail@mail.ru', accountActive=false, dateOpen=2022-01-01, currency=RUB, balance=1.99, accountType=Card, dateClose=null}";
        Assert.assertEquals(accounts.toString(), resultExpected);
    }
}