package ru.sbp.bankfinancialprocessingsystem.dao.entity.enums;

import ru.sbp.bankfinancialprocessingsystem.dao.entity.GlobalUser;

/**
 * Класс enum содержит описание значений поля в таблие global_user.user_role
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 * @see GlobalUser#Object()
 */
public enum UserRoleType {
    User,
    Operator,
    Admin;

    UserRoleType() {
    }

}
