package ru.sbp.bankfinancialprocessingsystem.dao.entity;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Класс ClientsTest выполняет Модульное тестирование JUnit класса Clients
 *
 * @author Sergey Proshchaev
 * @version 1.0
 * @see Clients#Object()
 */
class ClientsTest {

    /**
     * Метод clients_Successful_Test() выполняет Модульное тестирование JUnit
     * полей класса Clients
     */
    @Test
    void clients_Successful_Test() throws ParseException {
        Clients clients = new Clients("ivanov",
                "Иванов",
                "Степан",
                "Петрович",
                new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("02/02/1980 00:00:00").getTime()),
                "Серия 54 05 Номер 123457 Выдан в городе Москве",
                "ПОМ 21",
                new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/01/2014 00:00:00").getTime()),
                "ivanov@mail.ru",
                "+79631234568"
        );
        System.out.println(clients.toString());
        String resultExpected = "Clients{userLogin='ivanov', firstName='Иванов', secondName='Степан', middleName='Петрович', birthday=1980-02-02, passport='Серия 54 05 Номер 123457 Выдан в городе Москве', passportOrg='ПОМ 21', passportDate=2014-01-01, email='ivanov@mail.ru', phone='+79631234568'}";
        Assert.assertEquals(clients.toString(), resultExpected);

    }
}