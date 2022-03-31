package ru.sbp.bankfinancialprocessingsystem.dao.entity.enums;

import ru.sbp.bankfinancialprocessingsystem.dao.entity.Accounts;

/**
 * Класс enum содержит описание значений поля в таблие accounts.account_type
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 * @see Accounts#Object()
 */
public enum AccountType {
    Current,
    Card,
    Savings;

    AccountType() {
    }

}
