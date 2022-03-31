package ru.sbp.bankfinancialprocessingsystem.dao.entity;

import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.CardStatusType;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.PaymentSystemType;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.CardsRepository;

import javax.persistence.*;
import java.sql.Date;

/**
 * Класс Cards - POJO-класс (Plain Old Java Object) таблицы cards
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 * @see CardsRepository#Object()
 */
@Entity
public class Cards {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "card_number")
    private String cardNumber;
    @Basic
    @Column(name = "number_account")
    private String numberAccount;
    @Basic
    @Column(name = "expiration_date")
    private Date expirationDate;
    @Basic
    @Column(name = "card_holder_name")
    private String cardHolderName;
    @Basic
    @Column(name = "payment_system")
    @Enumerated(EnumType.STRING)
    private PaymentSystemType paymentSystem;
    @Basic
    @Column(name = "card_status")
    @Enumerated(EnumType.STRING)
    private CardStatusType cardStatus;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public PaymentSystemType getPaymentSystem() {
        return paymentSystem;
    }

    public void setPaymentSystem(PaymentSystemType paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    public CardStatusType getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatusType cardStatus) {
        this.cardStatus = cardStatus;
    }

    /**
     * Конструктор класса
     */
    public Cards() {
    }

    /**
     * Конструктор класса с параметрами
     *
     * @param - String cardNumber
     * @param - String numberAccount
     * @param - Date expirationDate
     * @param - String cardHolderName
     * @param - PaymentSystemType paymentSystem
     * @param - CardStatusType cardStatus
     */
    public Cards(String cardNumber, String numberAccount, Date expirationDate, String cardHolderName, PaymentSystemType paymentSystem, CardStatusType cardStatus) {
        this.cardNumber = cardNumber;
        this.numberAccount = numberAccount;
        this.expirationDate = expirationDate;
        this.cardHolderName = cardHolderName;
        this.paymentSystem = paymentSystem;
        this.cardStatus = cardStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cards cards = (Cards) o;

        if (cardNumber != null ? !cardNumber.equals(cards.cardNumber) : cards.cardNumber != null) return false;
        if (numberAccount != null ? !numberAccount.equals(cards.numberAccount) : cards.numberAccount != null)
            return false;
        if (expirationDate != null ? !expirationDate.equals(cards.expirationDate) : cards.expirationDate != null)
            return false;
        if (cardHolderName != null ? !cardHolderName.equals(cards.cardHolderName) : cards.cardHolderName != null)
            return false;
        if (paymentSystem != null ? !paymentSystem.equals(cards.paymentSystem) : cards.paymentSystem != null)
            return false;
        if (cardStatus != null ? !cardStatus.equals(cards.cardStatus) : cards.cardStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cardNumber != null ? cardNumber.hashCode() : 0;
        result = 31 * result + (numberAccount != null ? numberAccount.hashCode() : 0);
        result = 31 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
        result = 31 * result + (cardHolderName != null ? cardHolderName.hashCode() : 0);
        result = 31 * result + (paymentSystem != null ? paymentSystem.hashCode() : 0);
        result = 31 * result + (cardStatus != null ? cardStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cards{" +
                "cardNumber='" + cardNumber + '\'' +
                ", numberAccount='" + numberAccount + '\'' +
                ", expirationDate=" + expirationDate +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", paymentSystem=" + paymentSystem +
                ", cardStatus=" + cardStatus +
                '}';
    }
}
