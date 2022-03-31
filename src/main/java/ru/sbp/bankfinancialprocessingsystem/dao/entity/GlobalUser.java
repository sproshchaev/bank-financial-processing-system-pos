package ru.sbp.bankfinancialprocessingsystem.dao.entity;

import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.UserRoleType;

import javax.persistence.*;

/**
 * Класс GlobalUser - POJO-класс (Plain Old Java Object) таблицы global_user
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 * @see GlobalUser#Object()
 * @see UserRoleType#Object()
 */
@Entity
@Table(name = "global_user", schema = "public", catalog = "backofficedb")
public class GlobalUser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_login")
    private String userLogin;
    @Basic
    @Column(name = "user_password")
    private String userPassword;

    @Basic
    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRoleType userRole;

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Object getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleType userRole) {
        this.userRole = userRole;
    }

    /**
     * Конструктор класса
     */
    public GlobalUser() {
    }

    /**
     * Конструктор класса с параметрами
     *
     * @param - String userLogin,
     * @param - String userPassword,
     * @param - UserRoleType userRole
     */
    public GlobalUser(String userLogin, String userPassword, UserRoleType userRole) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GlobalUser that = (GlobalUser) o;

        if (userLogin != null ? !userLogin.equals(that.userLogin) : that.userLogin != null) return false;
        if (userPassword != null ? !userPassword.equals(that.userPassword) : that.userPassword != null) return false;
        if (userRole != null ? !userRole.equals(that.userRole) : that.userRole != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userLogin != null ? userLogin.hashCode() : 0;
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userRole != null ? userRole.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GlobalUser{" +
                "userLogin='" + userLogin + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
