package ru.sbp.bankfinancialprocessingsystem.dao.entity;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.BankDataRepository;

/**
 * Класс BankDataTest выполняет Модульное тестирование JUnit класса BankData
 *
 * @author Sergey Proshchaev
 * @version 1.0
 * @see BankDataRepository#Object()
 */
class BankDataTest {

    /**
     * Метод bankDataTest_Successful_Test() выполняет Модульное тестирование JUnit
     * полей класса BankData
     */
    @Test
    void bankDataTest_Successful_Test() {
        BankData bankData = new BankData(1,
                "044525225",
                "Публичное акционерное общество «Сбербанк России»",
                "ПАО Сбербанк",
                "Генеральная лицензия Банка России на осуществление банковских операций №1481 от 11.08.2015 г.",
                "Россия, Москва, 117312, ул. Вавилова, д. 19 ",
                "Москва, 117997, ул. Вавилова, д. 19 ",
                "30101810400000000225",
                "773601001",
                "7707083893",
                "1027700132195",
                "SABRRUMM");

        String resultExpected = "BankData{id=1, bic='044525225', fullName='Публичное акционерное общество «Сбербанк России»', abbreviatedName='ПАО Сбербанк', license='Генеральная лицензия Банка России на осуществление банковских операций №1481 от 11.08.2015 г.', registeredAddress='Россия, Москва, 117312, ул. Вавилова, д. 19 ', postalAddress='Москва, 117997, ул. Вавилова, д. 19 ', correspondentAccount='30101810400000000225', kpp='773601001', inn='7707083893', ogrn='1027700132195', swift='SABRRUMM'}";
        Assert.assertEquals(bankData.toString(), resultExpected);

    }
}