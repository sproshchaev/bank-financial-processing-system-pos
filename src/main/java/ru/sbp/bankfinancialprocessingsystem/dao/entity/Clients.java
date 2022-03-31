package ru.sbp.bankfinancialprocessingsystem.dao.entity;

import ru.sbp.bankfinancialprocessingsystem.dao.repositories.ClientsRepository;

import javax.persistence.*;
import java.sql.Date;

/**
 * Класс Clients - POJO-класс (Plain Old Java Object) таблицы clients
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 * @see ClientsRepository#Object()
 */
@Entity
@Table(name = "clients", schema = "public", catalog = "backofficedb")
public class Clients {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_login")
    private String userLogin;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "middle_name")
    private String middleName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "birthday")
    private Date birthday;
    @Basic
    @Column(name = "passport")
    private String passport;
    @Basic
    @Column(name = "passport_org")
    private String passportOrg;
    @Basic
    @Column(name = "passport_date")
    private Date passportDate;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "phone")
    private String phone;

    /**
     * Конструктор класса
     */
    public Clients() {
    }

    /**
     * Конструктор класса с параметрами
     *
     * @param - String userLogin логин
     * @param - String firstName имя
     * @param - String middleName отчество
     * @param - String secondName фамилия
     * @param - Date birthday дата рождения
     * @param - String passport паспорт, серия, номер
     * @param - String passportOrg паспорт, кем выдан
     * @param - Date passportDate паспорт, дата выдачи
     * @param - String email адрес электронной почты
     * @param - String phone телефон
     */
    public Clients(String userLogin, String firstName, String middleName, String lastName, Date birthday, String passport, String passportOrg, Date passportDate, String email, String phone) {
        this.userLogin = userLogin;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.passport = passport;
        this.passportOrg = passportOrg;
        this.passportDate = passportDate;
        this.email = email;
        this.phone = phone;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String secondName) {
        this.middleName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String middleName) {
        this.lastName = middleName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPassportOrg() {
        return passportOrg;
    }

    public void setPassportOrg(String passportOrg) {
        this.passportOrg = passportOrg;
    }

    public Date getPassportDate() {
        return passportDate;
    }

    public void setPassportDate(Date passportDate) {
        this.passportDate = passportDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clients clients = (Clients) o;

        if (userLogin != null ? !userLogin.equals(clients.userLogin) : clients.userLogin != null) return false;
        if (firstName != null ? !firstName.equals(clients.firstName) : clients.firstName != null) return false;
        if (middleName != null ? !middleName.equals(clients.middleName) : clients.middleName != null) return false;
        if (lastName != null ? !lastName.equals(clients.lastName) : clients.lastName != null) return false;
        if (birthday != null ? !birthday.equals(clients.birthday) : clients.birthday != null) return false;
        if (passport != null ? !passport.equals(clients.passport) : clients.passport != null) return false;
        if (passportOrg != null ? !passportOrg.equals(clients.passportOrg) : clients.passportOrg != null)
            return false;
        if (passportDate != null ? !passportDate.equals(clients.passportDate) : clients.passportDate != null)
            return false;
        if (email != null ? !email.equals(clients.email) : clients.email != null) return false;
        if (phone != null ? !phone.equals(clients.phone) : clients.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userLogin != null ? userLogin.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        result = 31 * result + (passportOrg != null ? passportOrg.hashCode() : 0);
        result = 31 * result + (passportDate != null ? passportDate.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "userLogin='" + userLogin + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + middleName + '\'' +
                ", middleName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", passport='" + passport + '\'' +
                ", passportOrg='" + passportOrg + '\'' +
                ", passportDate=" + passportDate +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
