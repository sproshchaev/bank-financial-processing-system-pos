package ru.sbp.bankfinancialprocessingsystem.dao.entity.enums;

import ru.sbp.bankfinancialprocessingsystem.dao.entity.Transactions;

/**
 * Класс enum содержит описание значений поля в таблие transactions.operation_type
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 * @see Transactions#Object()
 */
public enum OperationType {
    CashIn,
    CashOut,
    Payment,
    MoneyTransferIn,
    MoneyTransferOut,
    Refund;

    OperationType() {
    }

}
