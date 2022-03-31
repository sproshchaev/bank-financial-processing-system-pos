package ru.sbp.bankfinancialprocessingsystem.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

/**
 * Класс PosUserInfoTest выполняет Модульное тестирование JUnit класса PosUserInfo
 *
 * @author Sergey Proshchaev
 * @version 1.0
 * @see PosUserInfo#Object()
 */
class PosUserInfoTest {

    /**
     * Метод posUserInfo_Successful_Test() выполняет Модульное тестирование JUnit
     * полей класса PosUserInfo
     */
    @Test
    void posUserInfo_Successful_Test() throws ParseException {
        PosUserInfo posUserInfo = new PosUserInfo("user",
                "user",
                "Name",
                "MANAGER"
        );
        System.out.println(posUserInfo.toString());
        String resultExpected = "UserCache{login='user', password='user', name='Name', role='MANAGER'}";
        Assert.assertEquals(posUserInfo.toString(), resultExpected);
    }


}