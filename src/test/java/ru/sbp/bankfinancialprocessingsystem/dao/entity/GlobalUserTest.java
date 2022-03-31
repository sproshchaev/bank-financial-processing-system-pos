package ru.sbp.bankfinancialprocessingsystem.dao.entity;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.UserRoleType;

/**
 * Класс GlobalUserTest выполняет Модульное тестирование JUnit класса GlobalUser
 *
 * @author Sergey Proshchaev
 * @version 1.0
 * @see GlobalUser#Object()
 */
class GlobalUserTest {

    /**
     * Метод globalUser_Successful_Test() выполняет Модульное тестирование JUnit
     * полей класса GlobalUser
     */
    @Test
    void globalUser_Successful_Test() {
        GlobalUser globalUser = new GlobalUser("user", "123456", UserRoleType.User);
        String resultExpected = "GlobalUser{userLogin='user', userPassword='123456', userRole=User}";
        Assert.assertEquals(globalUser.toString(), resultExpected);
    }
}