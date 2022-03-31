package ru.sbp.bankfinancialprocessingsystem.service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс GenAuthorizationCode содержит методы генерации уникального кода авторизации в течении суток
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 */
public class GenAuthorizationCode {

    /**
     * Метод genAuthorizationCode создает строку с уникальным кодом авторизации в течении суток
     *
     * @return - String
     */
    public static String genAuthorizationCode() {
        return new SimpleDateFormat("ssHHmm").format(new Date());
    }

}
