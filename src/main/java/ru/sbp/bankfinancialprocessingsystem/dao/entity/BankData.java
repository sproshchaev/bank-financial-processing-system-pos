package ru.sbp.bankfinancialprocessingsystem.dao.entity;

import ru.sbp.bankfinancialprocessingsystem.dao.repositories.BankDataRepository;

import javax.persistence.*;

/**
 * Класс BankData - POJO-класс (Plain Old Java Object) таблицы bank_data
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 * @see BankDataRepository#Object()
 */
@Entity
@Table(name = "bank_data", schema = "public", catalog = "backofficedb")
public class BankData {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "bic")
    private String bic;
    @Basic
    @Column(name = "full_name")
    private String fullName;
    @Basic
    @Column(name = "abbreviated_name")
    private String abbreviatedName;
    @Basic
    @Column(name = "license")
    private String license;
    @Basic
    @Column(name = "registered_address")
    private String registeredAddress;
    @Basic
    @Column(name = "postal_address")
    private String postalAddress;
    @Basic
    @Column(name = "correspondent_account")
    private String correspondentAccount;
    @Basic
    @Column(name = "kpp")
    private String kpp;
    @Basic
    @Column(name = "inn")
    private String inn;
    @Basic
    @Column(name = "ogrn")
    private String ogrn;
    @Basic
    @Column(name = "swift")
    private String swift;

    /**
     * Конструктор класса
     */
    public BankData() {
    }

    /**
     * Конструктор класса с параметрами
     *
     * @param - int id
     * @param - String bic БИК
     * @param - String fullName Полное наименование
     * @param - String abbreviatedName Сокращенное наименование
     * @param - String license Лицензия
     * @param - String registeredAddress Адрес регистрации
     * @param - String postalAddress Почтовый адрес
     * @param - String correspondentAccount Коррекспондентский счет
     * @param - String kpp КПП
     * @param - String inn ИНН
     * @param - String ogrn ОГРН
     * @param - String swift SWIFT
     */
    public BankData(int id, String bic, String fullName, String abbreviatedName, String license, String registeredAddress, String postalAddress, String correspondentAccount, String kpp, String inn, String ogrn, String swift) {
        this.id = id;
        this.bic = bic;
        this.fullName = fullName;
        this.abbreviatedName = abbreviatedName;
        this.license = license;
        this.registeredAddress = registeredAddress;
        this.postalAddress = postalAddress;
        this.correspondentAccount = correspondentAccount;
        this.kpp = kpp;
        this.inn = inn;
        this.ogrn = ogrn;
        this.swift = swift;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAbbreviatedName() {
        return abbreviatedName;
    }

    public void setAbbreviatedName(String abbreviatedName) {
        this.abbreviatedName = abbreviatedName;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getCorrespondentAccount() {
        return correspondentAccount;
    }

    public void setCorrespondentAccount(String correspondentAccount) {
        this.correspondentAccount = correspondentAccount;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankData bankData = (BankData) o;

        if (id != bankData.id) return false;
        if (bic != null ? !bic.equals(bankData.bic) : bankData.bic != null) return false;
        if (fullName != null ? !fullName.equals(bankData.fullName) : bankData.fullName != null) return false;
        if (abbreviatedName != null ? !abbreviatedName.equals(bankData.abbreviatedName) : bankData.abbreviatedName != null)
            return false;
        if (license != null ? !license.equals(bankData.license) : bankData.license != null) return false;
        if (registeredAddress != null ? !registeredAddress.equals(bankData.registeredAddress) : bankData.registeredAddress != null)
            return false;
        if (postalAddress != null ? !postalAddress.equals(bankData.postalAddress) : bankData.postalAddress != null)
            return false;
        if (correspondentAccount != null ? !correspondentAccount.equals(bankData.correspondentAccount) : bankData.correspondentAccount != null)
            return false;
        if (kpp != null ? !kpp.equals(bankData.kpp) : bankData.kpp != null) return false;
        if (inn != null ? !inn.equals(bankData.inn) : bankData.inn != null) return false;
        if (ogrn != null ? !ogrn.equals(bankData.ogrn) : bankData.ogrn != null) return false;
        if (swift != null ? !swift.equals(bankData.swift) : bankData.swift != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (bic != null ? bic.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (abbreviatedName != null ? abbreviatedName.hashCode() : 0);
        result = 31 * result + (license != null ? license.hashCode() : 0);
        result = 31 * result + (registeredAddress != null ? registeredAddress.hashCode() : 0);
        result = 31 * result + (postalAddress != null ? postalAddress.hashCode() : 0);
        result = 31 * result + (correspondentAccount != null ? correspondentAccount.hashCode() : 0);
        result = 31 * result + (kpp != null ? kpp.hashCode() : 0);
        result = 31 * result + (inn != null ? inn.hashCode() : 0);
        result = 31 * result + (ogrn != null ? ogrn.hashCode() : 0);
        result = 31 * result + (swift != null ? swift.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BankData{" +
                "id=" + id +
                ", bic='" + bic + '\'' +
                ", fullName='" + fullName + '\'' +
                ", abbreviatedName='" + abbreviatedName + '\'' +
                ", license='" + license + '\'' +
                ", registeredAddress='" + registeredAddress + '\'' +
                ", postalAddress='" + postalAddress + '\'' +
                ", correspondentAccount='" + correspondentAccount + '\'' +
                ", kpp='" + kpp + '\'' +
                ", inn='" + inn + '\'' +
                ", ogrn='" + ogrn + '\'' +
                ", swift='" + swift + '\'' +
                '}';
    }
}
