package ru.sbp.bankfinancialprocessingsystem.dao.entity.enums;

import ru.sbp.bankfinancialprocessingsystem.dao.entity.Cards;

/**
 * Класс enum содержит описание значений поля в таблие cards.payment_system
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 * @see Cards#Object()
 */
public enum PaymentSystemType {
    VISA,
    MC,
    МИР;

    PaymentSystemType() {
    }

}
