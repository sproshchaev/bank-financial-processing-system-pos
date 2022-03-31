package ru.sbp.bankfinancialprocessingsystem.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

/**
 * Класс GenAuthorizationCodeTest выполняет Модульное тестирование JUnit класса GenAuthorizationCode
 *
 * @author Sergey Proshchaev
 * @version 1.0
 * @see GenAuthorizationCode#Object()
 */
class GenAuthorizationCodeTest {

    /**
     * Метод genAuthorizationCode_Successful_Test() выполняет Модульное тестирование JUnit
     * класса GenAuthorizationCode
     */
    @Test
    void genAuthorizationCode_Successful_Test() throws ParseException {
        String authorizationCode = GenAuthorizationCode.genAuthorizationCode();
        Assert.assertEquals(authorizationCode.length(), 6);
    }

}