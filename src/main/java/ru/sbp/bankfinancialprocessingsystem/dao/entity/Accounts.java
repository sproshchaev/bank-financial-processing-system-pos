package ru.sbp.bankfinancialprocessingsystem.dao.entity;

import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.AccountType;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.CurrencyType;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.AccountsRepository;

import javax.persistence.*;
import java.sql.Date;

/**
 * Класс Accounts - POJO-класс (Plain Old Java Object) таблицы accounts
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 * @see AccountsRepository#Object()
 */
@Entity
public class Accounts {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "number_account")
    private String numberAccount;
    @Basic
    @Column(name = "user_login")
    private String userLogin;
    @Basic
    @Column(name = "account_active")
    private Boolean accountActive;
    @Basic
    @Column(name = "date_open")
    private Date dateOpen;
    @Basic
    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    private CurrencyType currency;
    @Basic
    @Column(name = "balance")
    private Double balance;
    @Basic
    @Column(name = "account_type")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Basic
    @Column(name = "date_close")
    private Date dateClose;

    /**
     * Конструктор класса
     */
    public Accounts() {
    }

    /**
     * Конструктор класса с параметрами
     *
     * @param - String numberAccount номер счета 20 знаков
     * @param - String userLogin логин пользователя
     * @param - Boolean accountActive признак отсутствия ограничений по счету
     * @param - Date dateOpen дата открытия
     * @param - CurrencyType currency валюта счета
     * @param - Double balance исходящий остаток
     * @param - AccountType accountType тип счета
     * @param - Date dateClose дата закрытия счета
     */
    public Accounts(String numberAccount, String userLogin, Boolean accountActive, Date dateOpen, CurrencyType currency, Double balance, AccountType accountType, Date dateClose) {
        this.numberAccount = numberAccount;
        this.userLogin = userLogin;
        this.accountActive = accountActive;
        this.dateOpen = dateOpen;
        this.currency = currency;
        this.balance = balance;
        this.accountType = accountType;
        this.dateClose = dateClose;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Boolean getAccountActive() {
        return accountActive;
    }

    public void setAccountActive(Boolean accountActive) {
        this.accountActive = accountActive;
    }

    public Date getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(Date dateOpen) {
        this.dateOpen = dateOpen;
    }

    public CurrencyType getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Date getDateClose() {
        return dateClose;
    }

    public void setDateClose(Date dateClose) {
        this.dateClose = dateClose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Accounts accounts = (Accounts) o;

        if (numberAccount != null ? !numberAccount.equals(accounts.numberAccount) : accounts.numberAccount != null)
            return false;
        if (userLogin != null ? !userLogin.equals(accounts.userLogin) : accounts.userLogin != null) return false;
        if (accountActive != null ? !accountActive.equals(accounts.accountActive) : accounts.accountActive != null)
            return false;
        if (dateOpen != null ? !dateOpen.equals(accounts.dateOpen) : accounts.dateOpen != null) return false;
        if (currency != null ? !currency.equals(accounts.currency) : accounts.currency != null) return false;
        if (balance != null ? !balance.equals(accounts.balance) : accounts.balance != null) return false;
        if (accountType != null ? !accountType.equals(accounts.accountType) : accounts.accountType != null)
            return false;
        if (dateClose != null ? !dateClose.equals(accounts.dateClose) : accounts.dateClose != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numberAccount != null ? numberAccount.hashCode() : 0;
        result = 31 * result + (userLogin != null ? userLogin.hashCode() : 0);
        result = 31 * result + (accountActive != null ? accountActive.hashCode() : 0);
        result = 31 * result + (dateOpen != null ? dateOpen.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (accountType != null ? accountType.hashCode() : 0);
        result = 31 * result + (dateClose != null ? dateClose.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "numberAccount='" + numberAccount + '\'' +
                ", userLogin='" + userLogin + '\'' +
                ", accountActive=" + accountActive +
                ", dateOpen=" + dateOpen +
                ", currency=" + currency +
                ", balance=" + balance +
                ", accountType=" + accountType +
                ", dateClose=" + dateClose +
                '}';
    }
}
