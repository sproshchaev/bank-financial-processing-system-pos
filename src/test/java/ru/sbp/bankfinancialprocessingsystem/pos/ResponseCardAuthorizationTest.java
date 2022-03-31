package ru.sbp.bankfinancialprocessingsystem.pos;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

/**
 * Класс ResponseCardAuthorizationTest выполняет Модульное тестирование JUnit класса ResponseCardAuthorization
 *
 * @author Sergey Proshchaev
 * @version 1.0
 * @see Payment#Object()
 */
class ResponseCardAuthorizationTest {

    /**
     * Метод responseCardAuthorization_Successful_Test() выполняет Модульное тестирование JUnit
     * полей класса ResponseCardAuthorizationTest
     */
    @Test
    void responseCardAuthorization_Successful_Test() throws ParseException {
        ResponseCardAuthorization responseCardAuthorization = new ResponseCardAuthorization("00",
                "одобрено и завершено",
                "010203"
        );
        String resultExpected = "ResponseCardAuthorization{errorCode='00', errorDescription='одобрено и завершено', authorizationCode='010203'}";
        Assert.assertEquals(responseCardAuthorization.toString(), resultExpected);
    }

}